package com.fiu.manhunt.GameModel;


/**
 * Class PowerUp
 */
public class PowerUp {

    //
    // Fields
    // 
  private String name;
  private int duration;
  private int coolDownDuration;
  private boolean isActive;
  private String iconPath;
  
    //
    // Constructors
    //
  	
	public PowerUp () {
		this("Default");
	};
	
	public PowerUp (String name){
	  	this.name = name;
	  	this.duration = 60;
	  	this.coolDownDuration = 120;
	  	this.isActive = false;
	  	this.iconPath = "path to default icon";
	}
  
    //
    // Methods
    //
  
    /**
     * Set the value of name
     * @param newVar the new value of name
     */
  public void setName (String newVar) {
      name = newVar;
  }

    /**
     * Get the value of name
     * @return the value of name
     */
  public String getName () {
      return name;
  }

    /**
     * Set the value of duration
     * @param newVar the new value of duration
     */
  public void setDuration (int newVar) {
      duration = newVar;
  }

    /**
     * Get the value of duration
     * @return the value of duration
     */
  public int getDuration () {
      return duration;
  }

    /**
     * Set the value of coolDown
     * @param newVar the new value of coolDown
     */
  public void setCoolDown (int newVar) {
      coolDownDuration = newVar;
  }

    /**
     * Get the value of coolDown
     * @return the value of coolDown
     */
  public int getCoolDown () {
      return coolDownDuration;
  }

    /**
     * Set the value of isActive
     * @param newVar the new value of isActive
     */
  public void setIsActive (boolean newVar) {
      isActive = newVar;
  }

    /**
     * Get the value of isActive
     * @return the value of isActive
     */
  public boolean getIsActive () {
      return isActive;
  }

    /**
     * Set the value of icon
     * @param newVar the new value of icon
     */
  public void setIcon (String newVar) {
      iconPath = newVar;
  }

    /**
     * Get the value of icon
     * @return the value of icon
     */
  public String getIcon () {
      return iconPath;
  } 
}
