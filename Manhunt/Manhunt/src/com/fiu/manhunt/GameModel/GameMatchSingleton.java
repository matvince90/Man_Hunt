package com.fiu.manhunt.GameModel;

import java.util.*; 
 
class GameMatchSingleton {
 
  static private GameMatchSingleton instance = null;
  private GameMap gameMap;
  private List<Player> matchPlayers;
  private Player currentPlayer;
  private long startTime;
  private boolean matchStarted;
    
    //
    // Constructors
    //
  protected GameMatchSingleton () { 
	  this.gameMap = null;
	  this.matchPlayers = null;
	  this.currentPlayer = null; 
	  this.matchStarted = false; 
  };
  
    //
    // Methods
    //
  
  public static GameMatchSingleton getInstance() {
	   
	     if(instance == null) {
	        instance = new GameMatchSingleton();
	     }
	     
	     return instance;
	  }
  
/**
 * Starts GameMatch
 */
  public void startMatch()
  {
	  if(!matchStarted)
	  {
		  this.startTime = System.currentTimeMillis(); 
		  this.matchStarted = true;
	  } 
  }
  
  /**
   * Main Game Loop
   */
  public void GameLoop()
  {
	  
  }
  
  /**
   * Ends GameMatch
   */

  public void endMatch()
  {
   
  }
  
  public void hideCurrentPlayer()
  {
	  this.currentPlayer.hideLocation();
  }
  
    /**
     * Set the value of gameMap
     * @param newVar the new value of gameMap
     */
  public void setGameMap (GameMap newVar) {
      gameMap = newVar;
  }

    /**
     * Get the value of gameMap
     * @return the value of gameMap
     */
  public GameMap getGameMap () {
      return gameMap;
  }

    /**
     * Set the value of matchPlayers
     * @param newVar the new value of matchPlayers
     */
  public void setMatchPlayers (List<Player> newVar) {
      matchPlayers = newVar;
  }

    /**
     * Get the value of matchPlayers
     * @return the value of matchPlayers
     */
  public List<Player> getMatchPlayers () {
      return matchPlayers;
  }

    /**
     * Set the value of currentPlayer
     * @param newVar the new value of currentPlayer
     */
  public void setCurrentPlayer(Player player) {
      currentPlayer = player;
  }
  
    /**
     * Set the value of startTime
     * @param newVar the new value of startTime
     */
  public void setStartTime(long newVar) {
      startTime = newVar;
  }

    /**
     * Get the value of startTime
     * @return the value of startTime
     */
  public long getStartTime() {
      return startTime;
  }
 
    /**
     */
  public void updateMatchData()
  {
    
  }
 
//    /**
//     * @param        action
//     * @param        data
//     * @param        function
//     */
//  public void sendMesg(String action, String data, Callable<T> function)
//  {
//  
//  }


    /**
     */
  public List<PowerUp> getPowerUpList(Player player)
  {
	  return player.getPowerUpInventory();
    }


    /**
     * @param        playerType
     */
  public void transformPlayerType(Player.Type type)
  {
	this.currentPlayer.setPlayerType(type);
  }


    /**
     * @return       GameModel.PlayerInformation
     */
  public Player getCurrentPlayer()
  {
	  return this.currentPlayer;
  }
 
  public void updateGameMatch()
  {
	  //updates all of the game match variables
	  
  }
 
  public void showTagButton()
  {
	  
  } 
}
