package com.fiu.manhunt.GameModel;
 
  class PowerUpCommand implements Command {
 
  private  PowerUp powerUp = null;
   
  public PowerUpCommand (PowerUp powerUp) { 
	  this.powerUp = powerUp;
  }; 
 
  public void execute()
  {
	  this.powerUp.setIsActive(true);
	  
	  //GameMatch is modified due to the PowerUp
	  GameMatchSingleton gameMatch = GameMatchSingleton.getInstance();
	  
	  long startTime = System.currentTimeMillis();
	  int duration = this.powerUp.getDuration();
	  
	  while ((System.currentTimeMillis()-startTime)< duration && this.powerUp.IsActive()){
		  //execution of the powerUp
		  
		  
		  
		  
		  
	  }
	  
	  this.powerUp.setIsActive(false);
  }
 
}
