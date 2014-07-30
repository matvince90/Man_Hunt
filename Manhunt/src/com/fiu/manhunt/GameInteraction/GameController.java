package com.fiu.manhunt.GameInteraction;
import GameModel.Singleton_T_;


/**
 * Class GameController
 */
public class GameController {

    //
    // Fields
    //

  protected AsyncTask gamePlay;
  private GameModel.Singleton<T> gameMatchSingleton;
  private com.fiu.manhunt.GameInteraction.GameActivity gameActivity;
  
    //
    // Constructors
    //
    public GameController () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of gamePlay
     * @param newVar the new value of gamePlay
     */
  protected void setGamePlay (AsyncTask newVar) {
      gamePlay = newVar;
  }

    /**
     * Get the value of gamePlay
     * @return the value of gamePlay
     */
  protected AsyncTask getGamePlay () {
      return gamePlay;
  }

    /**
     * Set the value of gameMatchSingleton
     * @param newVar the new value of gameMatchSingleton
     */
  private void setGameMatchSingleton (GameModel.Singleton<T> newVar) {
      gameMatchSingleton = newVar;
  }

    /**
     * Get the value of gameMatchSingleton
     * @return the value of gameMatchSingleton
     */
  private GameModel.Singleton<T> getGameMatchSingleton () {
      return gameMatchSingleton;
  }

    /**
     * Set the value of gameActivity
     * @param newVar the new value of gameActivity
     */
  private void setGameActivity (GameInteraction.GameActivity newVar) {
      gameActivity = newVar;
  }

    /**
     * Get the value of gameActivity
     * @return the value of gameActivity
     */
  private com.fiu.manhunt.GameInteraction.GameActivity getGameActivity () {
      return gameActivity;
  }

    //
    // Other methods
    //

    /**
     */
  public void showTagButton()
  {
    }


    /**
     */
  public void tapTagButton()
  {
    }


    /**
     */
  public void startGameMatch()
  {
    }


    /**
     * @param        powerUpType
     */
  public void tapPowerUpButton(String powerUpType)
  {
    }


    /**
     */
  public void displayPowerUpList()
  {
    }


    /**
     */
  public void buyPowerUp()
  {
    }


    /**
     * @param        gameMap
     */
  public void refreshGameMap(uiGameMap gameMap)
  {
    }


    /**
     */
  public void displayTagButton()
  {
    }


}
