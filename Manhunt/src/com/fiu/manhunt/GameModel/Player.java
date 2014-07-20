package com.fiu.manhunt.GameModel;

import android.location.Location; 
import java.util.*; 
 
public class Player {
 
	public enum Type{
		Predator,
		Prey
	}
	
  private long powerUpUseTimestamp;
  private String name;
  private String playerType;
  private List<PowerUp> powerUpInventory;
  private Location location;
  private int id;
  
    //
    // Constructors
    //
    public Player (int id, Player.Type type) {  
    	this.powerUpInventory = new LinkedList<PowerUp>();
    	this.location = null;
    	this.playerType = type.toString();  
    	this.id = id;
    }; 
    
    /**
     * Set the value of powerUpUseTimestamp
     * @param newVar the new value of powerUpUseTimestamp
     */
  public void resetPowerUpUseTimestamp () {
      powerUpUseTimestamp = System.currentTimeMillis();
  }
  
  /**
   * Get the value of location
   * @return the value of location
   */
	public Location getLocation () {
	    return location;
	}
  
	  /**
	   * Hides player's current location
	   */
	  
	  public void hideLocation(){
		  this.location = null;
	  }

    /**
     * Get the value of powerUpUseTimestamp
     * @return the value of powerUpUseTimestamp
     */
  public long getPowerUpLastUsedTimestamp () {
      return powerUpUseTimestamp;
  }

    /**
     * Set the value of playerType
     * @param newVar the new value of playerType
     */
  public void setPlayerType(Type newVar) {
      playerType = newVar.toString();
  }

    /**
     * Get the value of playerType
     * @return the value of playerType
     */
  public String getPlayerType () {
      return playerType;
  }

    /**
     * Set the value of powerUpInventory
     * @param newVar the new value of powerUpInventory
     */
  public void setPowerUpInventory (List<PowerUp> inventory) {
      powerUpInventory = inventory;
  }

    /**
     * Get the value of powerUpInventory
     * @return the value of powerUpInventory
     */
  public List<PowerUp> getPowerUpInventory () {
      return powerUpInventory;
  }
  
  /**
   * Adds a PowerUp to the powerUpInventory 
   */
  public void addPowerUp(PowerUp powerUp){
	  this.powerUpInventory.add(powerUp);
  }
  
  /**
   * Removes a PowerUp from the powerUpInventory 
   */
  public void removePowerUp(PowerUp powerUp){
	  this.powerUpInventory.remove(powerUp);
  }

    /**
     * Set the value of location
     * @param newVar the new value of location
     */
  private void setLocation(Location newVar) {
      location = newVar;
  }
 
    /**
     * Set the value of id
     * @param newVar the new value of id
     */
  public void setId (int newVar) {
      id = newVar;
  }

    /**
     * Get the value of id
     * @return the value of id
     */
  public int getId () {
      return id;
  }
  
    /**
     * @param        playerName
     */
  public void getPlayerName()
  {
	  //Logic to get playerName using player id
	  
  }
  
    /**
     * @param        location
     */
  public void setLocations(Location location)
  {
  }
 
    /**
     */
  public void cleanPowerUps()
  {
	  this.powerUpInventory.clear();
  } 
}
