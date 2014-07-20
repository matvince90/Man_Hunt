package ServerSide;

import java.util.ArrayList;
import java.util.List;
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

	private List<GameMatch> gameMatchs;			// list of game matches
	private ServerSide.DbWrapper dbWrapper;		// db class
	private Webservice webService;
	private Thread webServiceThread;
	private Semaphore wsSignaller;
	private boolean active = false;
	private ExecutorService executor;			// thread pool

	/**
	 * 
	 */
	public GameLogicController() {
		this.gameMatchs = new ArrayList<GameMatch>();
	};

	/**
	 * Set the value of gameMatch
	 * @param gamematch the new value added to gameMatchs
	 */
	public void setGameMatch(GameMatch gameMatch) {
		this.gameMatchs.add(gameMatch);
	}

	/**
	 * Get the value of gameMatch
	 * @return the value of gameMatch
	 */
	public List<GameMatch> getGameMatch() {
		return this.gameMatchs;
	}

	/**
	 * Set the value of dbWrapper
	 * @param dbConthe new value of dbWrapper
	 */
	public void setDbWrapper(ServerSide.DbWrapper dbCon) {
		this.dbWrapper = dbCon;
	}

	/**
	 * Get the value of dbWrapper
	 * @return the value of dbWrapper
	 */
	public ServerSide.DbWrapper getDbWrapper() {
		return this.dbWrapper;
	}
	
	/**
	 * Begin running server
	 */
	public void start() {
		System.out.println("Init concurrency support...");
		this.executor = Executors.newFixedThreadPool(MAX_THREADS);
		this.active = true;
		this.wsSignaller = new Semaphore(SEMAPHORE_PERMITS);
		
		System.out.println("Starting web service...");
		// init web service.
		this.webService = new Webservice(this.wsSignaller);
		this.webServiceThread = new Thread(this.webService);
		this.webServiceThread.start();
		
		loop();
		
	}
	
	private void loop() {
		System.out.println("Listening for actionables...");
		while(this.active) {
			try {
				// wait for event
				this.wsSignaller.wait();
				System.out.println("Received request...");
				// get a lock or wait for it
				while(!this.wsSignaller.tryAcquire()) { }
				// pass message to handler
				Runnable mesgHandler = new MessageHandler(this.webService.messageQueue.peek());
				// spawn handler if allowed
				executor.execute(mesgHandler);
				// thread spawn sucessful so pop mesg.
				this.webService.messageQueue.poll();
				// release lock
				this.wsSignaller.release();
			} catch(RejectedExecutionException E) {
				// thread spawn limit reached, release lock and don't pop.
				this.wsSignaller.release();
				System.out.println(E.getMessage());
			}catch(Exception E) {
				System.out.println(E.getMessage());
			}
		}
	}

	/**
	 * @return ServerSide.ServerGameMatch
	 * @param player
	 */
	public GameMatch playerUpdate(Player player) {
		return null;
	}

	/**
	 * @param playerId
	 */
	public void removePlayer(int playerId) {
	}

	/**
	 * @return int
	 * @param new_parameter
	 */
	public int createInstance(Player new_parameter) {
		return 0;
	}

	/**
	 * @return boolean
	 * @param id
	 */
	public boolean removeInstance(int id) {
		return false;
	}
	
	/**
	 * handles all incoming actions
	 * @author Team 3
	 *
	 */
	public class MessageHandler implements Runnable {
		
		public MessageHandler(Webservice.WebserviceMessage mesg) {
			
		}
		public void run() {
			// TODO Auto-generated method stub
			
		}
		
	}

}
