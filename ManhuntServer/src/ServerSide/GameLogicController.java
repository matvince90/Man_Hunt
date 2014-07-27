package ServerSide;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

/**
 * Class GameLogicController
 */
public class GameLogicController {

	// constants
	private final int MAX_PLAYERS = 50;			// max players per instance.
	private final int MAX_GAME_INSTANCES = 1;	// maximum number of instances.
	private final int MAX_THREADS = 10;			// maximum thread number for pool
	private final int SEMAPHORE_PERMITS = 1;	// max semaphore permits.

	// volatile var
	private volatile List<GameMatch> _gameMatches;			// list of game matches
	private DbWrapper _dbWrapper;	// db class
	
	// web service and threading
	private Webservice _webService;				// web service.
	private Thread _webServiceThread;			// the thread concerned with the webservice
	
	// locks
	private Semaphore _wsSignaller;				// concurrency via webservice
	private Semaphore _mhSignaller;				// concurrency via webservice
	
	//
	private boolean _active = false;			// loop termination.
	private ExecutorService _executor;			// thread pool

	/**
	 * 
	 */
	public GameLogicController(DbWrapper dbCon) {
		_gameMatches = new ArrayList<GameMatch>();
		_dbWrapper = dbCon;
		
		// sync the instances objects with DB.
		initSyncDb();
	};
	
	/**
	 * initial syncing of the game matches and databases.
	 */
	private void initSyncDb() {
		List tempGames = _dbWrapper.getGameMatches();
		
		for(Iterator i = tempGames.iterator(); i.hasNext();) {
			GameMatch gm = new GameMatch(Integer.parseInt(i.toString()));
			_gameMatches.add(gm);
		}
	}
	
	/**
	 * sync all game matches with the database
	 */
	private void syncDb() {
		for(GameMatch gm: _gameMatches)
			gm.syncGameMatch();
	}
	
	/**
	 * Begin running server
	 */
	public void start() {
		// init thread pool and semaphores
		System.out.println("Init concurrency support...");
		_executor = Executors.newFixedThreadPool(MAX_THREADS);
		_active = true;
		_wsSignaller = new Semaphore(SEMAPHORE_PERMITS);
		_mhSignaller = new Semaphore(SEMAPHORE_PERMITS);
		
		// init web service
		System.out.println("Starting web service...");
		
		// init web service.
		_webService = new Webservice(_wsSignaller);
		_webServiceThread = new Thread(_webService);
		_webServiceThread.start();
		
		// start the loop
		loop();
		
	}
	
	/**
	 * Set the value of gameMatch
	 * @param gamematch the new value added to gameMatchs
	 */
	private void setGameMatch(GameMatch gameMatch) {
		_gameMatches.add(gameMatch);
	}

	/**
	 * Get the value of gameMatch
	 * @return the value of gameMatch
	 */
	private List<GameMatch> getGameMatch() {
		return _gameMatches;
	}
	
	/**
	 * Main loop for decision making and event handling.
	 */
	private void loop() {
		System.out.println("Listening for actionables...");
		while(_active) {
			try {
				// wait for event signal
				_wsSignaller.wait();
				System.out.println("Received request...");
				
				// get a lock or wait for it
				while(!_wsSignaller.tryAcquire()) { }
				
				// pass message to handler (has hard coded game match!!!)
				Runnable mesgHandler = new MessageHandler(_webService.messageQueue.peek(), _mhSignaller, _gameMatches.get(0));
				
				// spawn handler if allowed
				_executor.execute(mesgHandler);
				
				// thread spawn successful so pop mesg.
				_webService.messageQueue.poll();
				
				// release lock
				_wsSignaller.release();
				
			} catch(RejectedExecutionException E) {
				// thread spawn limit reached, release lock and don't pop.
				_wsSignaller.release();
				
				System.out.println(E.getMessage());
				
			}catch(Exception E) {
				// something else broke.
				System.out.println(E.getMessage());
			}
		}
	}
	
	/**
	 * local class that handles all incoming actions
	 * @author Team 3
	 */
	public class MessageHandler implements Runnable {
		
		// variables
		private Webservice.WebserviceMessage _msg;
		private Semaphore _gameMatchSignal;
		private GameMatch _gameMatch;
		
		/**
		 * 
		 * @param mesg
		 * @param gameMatchSignal
		 * @param gameMatch
		 */
		public MessageHandler(Webservice.WebserviceMessage mesg, Semaphore gameMatchSignal, GameMatch gameMatch) {
			_msg = mesg;
			_gameMatchSignal = gameMatchSignal;
			_gameMatch = gameMatch;
		}
		
		
		/**
		 * 
		 */
		public void run() {
			switch(_msg.action) {
				case "Update":
					updatePlayer(parsePlayer());
					break;
				default:
					break;
			}
		}
		
		/**
		 * 
		 * @param player
		 */
		private void updatePlayer(Player player) {
			// blocking code for this thread pool
			while(_gameMatchSignal.tryAcquire());
			_gameMatch.updateMatchPlayer(player);
			_gameMatchSignal.release();
		}
		
		/**
		 * 
		 * @return
		 */
		private Player parsePlayer() {
			Player player = new Player();
			String[] arr = _msg.data.split(":");
			player.setId(UUID.fromString(arr[1]));
			player.setEmail(arr[2]);
			player.setLatitude(Long.getLong(arr[3]));
			player.setLongitude(Long.getLong(arr[4]));
			player.setType(Integer.parseInt(arr[5]));
			return player;
		}
		
	}

}
