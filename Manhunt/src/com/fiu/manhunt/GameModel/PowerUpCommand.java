package com.fiu.manhunt.GameModel;
 
  class PowerUpCommand implements Command {
 
  private  PowerUp powerUp = null;
   
  public PowerUpCommand () { 
	  
  };
  
  private void setPowerUp(PowerUp newVar) {
      powerUp = newVar;
  }
 
  private PowerUp getPowerUp() {
      return powerUp;
  }
 
  public void execute()
  {
    
  }
 
}
