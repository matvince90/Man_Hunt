package GameModel;


/**
 * Class GameMatchSingleton
 */
class GameMatchSingleton {

    //
    // Fields
    //

  static private GameModel.GameMatchSingleton instance;
  private GameModel.GameMap gameMap;
  private List<GameModel.PlayerInformation> matchPlayers;
  private int currentPlayer;
  private int startTime;
  
    //
    // Constructors
    //
    public GameMatchSingleton () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Get the value of instance
     * @return the value of instance
     */
  private GameModel.GameMatchSingleton getInstance () {
      return instance;
  }

    /**
     * Set the value of gameMap
     * @param newVar the new value of gameMap
     */
  private void setGameMap (GameModel.GameMap newVar) {
      gameMap = newVar;
  }

    /**
     * Get the value of gameMap
     * @return the value of gameMap
     */
  private GameModel.GameMap getGameMap () {
      return gameMap;
  }

    /**
     * Set the value of matchPlayers
     * @param newVar the new value of matchPlayers
     */
  private void setMatchPlayers (List<GameModel.PlayerInformation> newVar) {
      matchPlayers = newVar;
  }

    /**
     * Get the value of matchPlayers
     * @return the value of matchPlayers
     */
  private List<GameModel.PlayerInformation> getMatchPlayers () {
      return matchPlayers;
  }

    /**
     * Set the value of currentPlayer
     * @param newVar the new value of currentPlayer
     */
  private void setCurrentPlayer (int newVar) {
      currentPlayer = newVar;
  }

    /**
     * Get the value of currentPlayer
     * @return the value of currentPlayer
     */
  private int getCurrentPlayer () {
      return currentPlayer;
  }

    /**
     * Set the value of startTime
     * @param newVar the new value of startTime
     */
  private void setStartTime (int newVar) {
      startTime = newVar;
  }

    /**
     * Get the value of startTime
     * @return the value of startTime
     */
  private int getStartTime () {
      return startTime;
  }

    //
    // Other methods
    //

    /**
     */
  public void updateMatchData()
  {
    }


    /**
     * @return       boolean
     * @param        powerupType
     */
  public boolean usePowerUp(String powerupType)
  {
    }


    /**
     */
  public void endMatch()
  {
    }


    /**
     * @return       boolean
     */
  public boolean startMatch()
  {
    }


    /**
     * @param        action
     * @param        data
     * @param        function
     */
  public void sendMesg(String action, String data, Callable<T> function)
  {
    }


    /**
     */
  public void getPowerUpList()
  {
    }


    /**
     * @param        playerType
     */
  public void transformPlayerType(GameModel.PlayerType playerType)
  {
    }


    /**
     * @return       GameModel.PlayerInformation
     */
  public GameModel.PlayerInformation getCurrentPlayer()
  {
    }


    /**
     */
  public void updateGameMatch()
  {
    }


    /**
     */
  public void showTagButton()
  {
    }


}
