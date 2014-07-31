package com.fiu.manhunt.server;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.RejectedExecutionException;
import java.util.concurrent.Semaphore;

import com.fiu.manhunt.data.DbWrapper;
import com.fiu.manhunt.entities.GameMatch;
import com.fiu.manhunt.entities.Player;

/**
 * Class GameLogicController
 */
public class GameLogicController {

	// constants
	private final int MAX_PLAYERS = 50;				// max players per instance.
	private final int MAX_GAME_INSTANCES = 1;		// maximum number of instances.
	private final int MAX_THREADS = 10;				// maximum thread number for pool
	private final int SEMAPHORE_PERMITS = 1;		// max semaphore permits.

	private volatile List<GameMatch> _gameMatchs;	// list of game matches
	private DbWrapper _dbWrapper;		// db class
	
	// web service and threading
	private Webservice _webService;
	private Thread _webServiceThread;
	
	// locks
	private Semaphore _wsSignaller;
	private Semaphore _mhSignaller;
	
	//
	private boolean _active = false;
	private ExecutorService _executor;				// thread pool

	/**
	 * 
	 */
	public GameLogicController() {
		_gameMatchs = new ArrayList<GameMatch>();
	};

	/**
	 * Set the value of gameMatch
	 * @param gamematch the new value added to gameMatchs
	 */
	public void setGameMatch(GameMatch gameMatch) {
		_gameMatchs.add(gameMatch);
	}

	/**
	 * Get the value of gameMatch
	 * @return the value of gameMatch
	 */
	public List<GameMatch> getGameMatch() {
		return _gameMatchs;
	}

	/**
	 * Set the value of dbWrapper
	 * @param dbConthe new value of dbWrapper
	 */
	public void setDbWrapper(ServerSide.DbWrapper dbCon) {
		_dbWrapper = dbCon;
	}

	/**
	 * Get the value of dbWrapper
	 * @return the value of dbWrapper
	 */
	public ServerSide.DbWrapper getDbWrapper() {
		return _dbWrapper;
	}
	
	/**
	 * Begin running server
	 */
	public void start() {
		System.out.println("Init concurrency support...");
		_executor = Executors.newFixedThreadPool(MAX_THREADS);
		_active = true;
		_wsSignaller = new Semaphore(SEMAPHORE_PERMITS);
		_mhSignaller = new Semaphore(SEMAPHORE_PERMITS);
		
		System.out.println("Starting web service...");
		// init web service.
		_webService = new Webservice(_wsSignaller);
		_webServiceThread = new Thread(_webService);
		_webServiceThread.start();
		
		loop();
		
	}
	
	private void loop() {
		System.out.println("Listening for actionables...");
		while(_active) {
			try {
				// wait for event
				_wsSignaller.wait();
				System.out.println("Received request...");
				// get a lock or wait for it
				while(!_wsSignaller.tryAcquire()) { }
				// pass message to handler has hard coded game match!!!
				Runnable mesgHandler = new MessageHandler(_webService.messageQueue.peek(), _mhSignaller, _gameMatchs.get(0));
				// spawn handler if allowed
				_executor.execute(mesgHandler);
				// thread spawn sucessful so pop mesg.
				_webService.messageQueue.poll();
				// release lock
				_wsSignaller.release();
			} catch(RejectedExecutionException E) {
				// thread spawn limit reached, release lock and don't pop.
				_wsSignaller.release();
				System.out.println(E.getMessage());
			}catch(Exception E) {
				System.out.println(E.getMessage());
			}
		}
	}

	/**
	 * @return int
	 * @param new_parameter
	 */
	private int createInstance(Player new_parameter) {
		return 0;
	}

	/**
	 * @return boolean
	 * @param id
	 */
	private boolean removeInstance(int id) {
		return false;
	}
	
	/**
	 * handles all incoming actions
	 * @author Team 3
	 *
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
