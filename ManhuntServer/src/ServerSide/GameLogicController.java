package ServerSide;

import java.util.ArrayList;
import java.util.List;

/**
 * Class GameLogicController
 */
public class GameLogicController {

	//
	// Fields
	//

	private List<GameMatch> gameMatch;
	private int MAX_PLAYERS;
	private int MAX_GAME_INSTANCES = 1;
	private ServerSide.DbWrapper dbWrapper;

	//
	// Constructors
	//
	public GameLogicController() {
		this.gameMatch = new ArrayList<GameMatch>();
	};

	//
	// Methods
	//

	//
	// Accessor methods
	//

	/**
	 * Set the value of gameMatch
	 * 
	 * @param newVar
	 *            the new value of gameMatch
	 */
	public void setGameMatch(List<GameMatch> newVar) {
		gameMatch = newVar;
	}

	/**
	 * Get the value of gameMatch
	 * 
	 * @return the value of gameMatch
	 */
	public List<GameMatch> getGameMatch() {
		return gameMatch;
	}

	/**
	 * Set the value of MAX_PLAYERS
	 * 
	 * @param newVar
	 *            the new value of MAX_PLAYERS
	 */
	public void setMAX_PLAYERS(int newVar) {
		MAX_PLAYERS = newVar;
	}

	/**
	 * Get the value of MAX_PLAYERS
	 * 
	 * @return the value of MAX_PLAYERS
	 */
	public int getMAX_PLAYERS() {
		return MAX_PLAYERS;
	}

	/**
	 * Set the value of MAX_GAME_INSTANCES
	 * 
	 * @param newVar
	 *            the new value of MAX_GAME_INSTANCES
	 */
	public void setMAX_GAME_INSTANCES(int newVar) {
		MAX_GAME_INSTANCES = newVar;
	}

	/**
	 * Get the value of MAX_GAME_INSTANCES
	 * 
	 * @return the value of MAX_GAME_INSTANCES
	 */
	public int getMAX_GAME_INSTANCES() {
		return MAX_GAME_INSTANCES;
	}

	/**
	 * Set the value of dbWrapper
	 * 
	 * @param newVar
	 *            the new value of dbWrapper
	 */
	public void setDbWrapper(ServerSide.DbWrapper newVar) {
		dbWrapper = newVar;
	}

	/**
	 * Get the value of dbWrapper
	 * 
	 * @return the value of dbWrapper
	 */
	public ServerSide.DbWrapper getDbWrapper() {
		return dbWrapper;
	}
	
	
	public void start() {
		
	}

	//
	// Other methods
	//

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

}
