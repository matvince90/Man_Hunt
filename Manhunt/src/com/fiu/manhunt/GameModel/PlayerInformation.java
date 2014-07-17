package GameModel;


/**
 * Class PlayerInformation
 */
public class PlayerInformation {

    //
    // Fields
    //

  private int powerUpUseTimestamp;
  private GameModel.PlayerType playerType = 0;
  private GameModel.PowerUp powerUpInventory;
  private Location location;
  private int id;
  
    //
    // Constructors
    //
    public PlayerInformation () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of powerUpUseTimestamp
     * @param newVar the new value of powerUpUseTimestamp
     */
  private void setPowerUpUseTimestamp (int newVar) {
      powerUpUseTimestamp = newVar;
  }

    /**
     * Get the value of powerUpUseTimestamp
     * @return the value of powerUpUseTimestamp
     */
  private int getPowerUpUseTimestamp () {
      return powerUpUseTimestamp;
  }

    /**
     * Set the value of playerType
     * @param newVar the new value of playerType
     */
  private void setPlayerType (GameModel.PlayerType newVar) {
      playerType = newVar;
  }

    /**
     * Get the value of playerType
     * @return the value of playerType
     */
  private GameModel.PlayerType getPlayerType () {
      return playerType;
  }

    /**
     * Set the value of powerUpInventory
     * @param newVar the new value of powerUpInventory
     */
  private void setPowerUpInventory (GameModel.PowerUp newVar) {
      powerUpInventory = newVar;
  }

    /**
     * Get the value of powerUpInventory
     * @return the value of powerUpInventory
     */
  private GameModel.PowerUp getPowerUpInventory () {
      return powerUpInventory;
  }

    /**
     * Set the value of location
     * @param newVar the new value of location
     */
  private void setLocation (Location newVar) {
      location = newVar;
  }

    /**
     * Get the value of location
     * @return the value of location
     */
  private Location getLocation () {
      return location;
  }

    /**
     * Set the value of id
     * @param newVar the new value of id
     */
  private void setId (int newVar) {
      id = newVar;
  }

    /**
     * Get the value of id
     * @return the value of id
     */
  private int getId () {
      return id;
  }

    //
    // Other methods
    //

    /**
     * @return       Location
     */
  public Location getLocation()
  {
    }


    /**
     * @return       String
     */
  public String getPlayerName()
  {
    }


    /**
     * @return       int
     */
  public int getId()
  {
    }


    /**
     * @return       GameModel.PowerUpCommand
     * @param        powerupType
     */
  public GameModel.PowerUpCommand getPowerUp(String powerupType)
  {
    }


    /**
     * @param        powerUp
     */
  public void addPowerUp(GameModel.PowerUp powerUp)
  {
    }


    /**
     * @param        playerName
     */
  public void setPlayerName(String playerName)
  {
    }


    /**
     * @param        setId
     */
  public void setId(int setId)
  {
    }


    /**
     * @param        location
     */
  public void setLocations(Location location)
  {
    }


    /**
     * @param        playerType
     */
  public void setPlayerType(GameModel.PlayerType playerType)
  {
    }


    /**
     */
  public void cleanPowerUps()
  {
    }


}
