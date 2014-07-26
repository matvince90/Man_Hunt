package ServerSide;

import java.util.ArrayList;
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

	private volatile List<GameMatch> _gameMatchs;			// list of game matches
	private ServerSide.DbWrapper _dbWrapper;	// db class
	
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
	public GameLogicController(ServerSide.DbWrapper dbCon) {
		_gameMatchs = new ArrayList<GameMatch>();
		_dbWrapper = dbCon;
	};
	
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
		_gameMatchs.add(gameMatch);
	}

	/**
	 * Get the value of gameMatch
	 * @return the value of gameMatch
	 */
	private List<GameMatch> getGameMatch() {
		return _gameMatchs;
	}
	
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
				Runnable mesgHandler = new MessageHandler(_webService.messageQueue.peek(), _mhSignaller, _gameMatchs.get(0));
				
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
		
		private Webservice.WebserviceMessage _msg;
		private Semaphore _gameMatchSignal;
		private GameMatch _gameMatch;
		
		public MessageHandler(Webservice.WebserviceMessage mesg, Semaphore gameMatchSignal, GameMatch gameMatch) {
			_msg = mesg;
		}
		
		public void run() {
			switch(_msg.action) {
				case "Update":
					updatePlayer(parsePlayer());
					break;
				default:
					break;
			}
		}
		
		// blocking code.
		private void updatePlayer(Player player) {
			while(_gameMatchSignal.tryAcquire());
			_gameMatch.updateMatchPlayer(player);
			_gameMatchSignal.release();
		}
		
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
