package GameModel;


/**
 * Class PowerUpCommand
 */
class PowerUpCommand extends Command {

    //
    // Fields
    //

  private GameModel.PowerUp powerUp = null;
  
    //
    // Constructors
    //
    public PowerUpCommand () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of powerUp
     * @param newVar the new value of powerUp
     */
  private void setPowerUp (GameModel.PowerUp newVar) {
      powerUp = newVar;
  }

    /**
     * Get the value of powerUp
     * @return the value of powerUp
     */
  private GameModel.PowerUp getPowerUp () {
      return powerUp;
  }

    //
    // Other methods
    //

    /**
     */
  public void execute()
  {
    }


    /**
     * @param        powerUp
     */
  public void setPowerUp(GameModel.PowerUp powerUp)
  {
    }


}
