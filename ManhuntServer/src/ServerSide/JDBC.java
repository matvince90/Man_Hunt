package ServerSide;


/**
 * Class JDBC
 */
class JDBC extends DbWrapper {

    //
    // Fields
    //

  private dbCon dbConnection;
  
    //
    // Constructors
    //
    public JDBC () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of dbConnection
     * @param newVar the new value of dbConnection
     */
  private void setDbConnection (dbCon newVar) {
      dbConnection = newVar;
  }

    /**
     * Get the value of dbConnection
     * @return the value of dbConnection
     */
  private dbCon getDbConnection () {
      return dbConnection;
  }

    //
    // Other methods
    //

    /**
     * @return       int
     * @param        playerInformation
     */
  public int addPlayer(ServerPlayerInformation playerInformation)
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
  public ServerSide.ServerGameMatch updatePlayer(ServerPlayerInformation playerInformation)
  {
    }


    /**
     * @return       boolean
     * @param        playerInformation
     */
  public boolean banPlayer(ServerPlayerInformation playerInformation)
  {
    }


    /**
     * @return       int
     * @param        gameMatch
     */
  public int createGameMatch(ServerGameMatch gameMatch)
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
