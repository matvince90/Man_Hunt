package ServerSide;


/**
 * Class DbWrapper
 */
abstract public class DbWrapper {

    //
    // Fields
    //

  
    //
    // Constructors
    //
    public DbWrapper () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    //
    // Other methods
    //

    /**
     * @return       int
     * @param        playerInformation
     */
  public int addPlayer(ServerSide.ServerPlayerInformation playerInformation)
  {
    }


    /**
     * @return       boolean
     * @param        playerId
     */
  public boolean removePlayer(int playerId)
  {
    }


    /**
     * @return       ServerSide.ServerGameMatch
     * @param        playerInformation
     */
  public ServerSide.ServerGameMatch updatePlayer(ServerSide.ServerPlayerInformation playerInformation)
  {
    }


    /**
     * @return       boolean
     * @param        playerInformation
     */
  public boolean banPlayer(ServerSide.ServerPlayerInformation playerInformation)
  {
    }


    /**
     * @return       int
     * @param        gameMatch
     */
  public int createGameMatch(ServerSide.ServerGameMatch gameMatch)
  {
    }


    /**
     * @return       boolean
     * @param        gameMatchId
     */
  public boolean removeGameMatch(int gameMatchId)
  {
    }


    /**
     * @return       boolean
     * @param        playerEmail
     */
  public boolean unBanPlayer(String playerEmail)
  {
    }


}
