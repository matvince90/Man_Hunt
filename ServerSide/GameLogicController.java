package ServerSide;


/**
 * Class GameLogicController
 */
public class GameLogicController {

    //
    // Fields
    //

  private List<ServerSide.ServerGameMatch> gameMatch;
  private int MAX_PLAYERS;
  private int MAX_GAME_INSTANCES = 1;
  private ServerSide.DbWrapper dbWrapper;
  
    //
    // Constructors
    //
    public GameLogicController () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of gameMatch
     * @param newVar the new value of gameMatch
     */
  private void setGameMatch (List<ServerSide.ServerGameMatch> newVar) {
      gameMatch = newVar;
  }

    /**
     * Get the value of gameMatch
     * @return the value of gameMatch
     */
  private List<ServerSide.ServerGameMatch> getGameMatch () {
      return gameMatch;
  }

    /**
     * Set the value of MAX_PLAYERS
     * @param newVar the new value of MAX_PLAYERS
     */
  private void setMAX_PLAYERS (int newVar) {
      MAX_PLAYERS = newVar;
  }

    /**
     * Get the value of MAX_PLAYERS
     * @return the value of MAX_PLAYERS
     */
  private int getMAX_PLAYERS () {
      return MAX_PLAYERS;
  }

    /**
     * Set the value of MAX_GAME_INSTANCES
     * @param newVar the new value of MAX_GAME_INSTANCES
     */
  private void setMAX_GAME_INSTANCES (int newVar) {
      MAX_GAME_INSTANCES = newVar;
  }

    /**
     * Get the value of MAX_GAME_INSTANCES
     * @return the value of MAX_GAME_INSTANCES
     */
  private int getMAX_GAME_INSTANCES () {
      return MAX_GAME_INSTANCES;
  }

    /**
     * Set the value of dbWrapper
     * @param newVar the new value of dbWrapper
     */
  private void setDbWrapper (ServerSide.DbWrapper newVar) {
      dbWrapper = newVar;
  }

    /**
     * Get the value of dbWrapper
     * @return the value of dbWrapper
     */
  private ServerSide.DbWrapper getDbWrapper () {
      return dbWrapper;
  }

    //
    // Other methods
    //

    /**
     * @return       ServerSide.ServerGameMatch
     * @param        playerInformation
     */
  public ServerSide.ServerGameMatch playerUpdate(ServerSide.ServerPlayerInformation playerInformation)
  {
    }


    /**
     * @param        playerId
     */
  public void removePlayer(int playerId)
  {
    }


    /**
     * @return       int
     * @param        new_parameter
     */
  public int createInstance(ServerSide.ServerPlayerInformation new_parameter)
  {
    }


    /**
     * @return       boolean
     * @param        id
     */
  public boolean removeInstance(int id)
  {
    }


}
