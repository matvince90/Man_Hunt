package com.fiu.manhunt.GameModel;

import android.location.Location;

import java.util.*; 

/**
 * Class PlayerInformation
 */
public class Player {
 
	private enum Type{
		Predator,
		Prey
	}
	
  private Date powerUpUseTimestamp;
  private String name;
  private String playerType;
  private List<PowerUp> powerUpInventory;
  private Location location;
  private int id;
  
    //
    // Constructors
    //
    public Player (int id, Player.Type type) { 
    	this.powerUpUseTimestamp = null;
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
      powerUpUseTimestamp = Calendar.getInstance().getTime();
  }

    /**
     * Get the value of powerUpUseTimestamp
     * @return the value of powerUpUseTimestamp
     */
  public Date getPowerUpLastUsedTimestamp () {
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
     * Get the value of location
     * @return the value of location
     */
  public Location getLocation () {
      return location;
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
  public void setPlayerName(String playerName)
  {
	  this.name = playerName;
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
