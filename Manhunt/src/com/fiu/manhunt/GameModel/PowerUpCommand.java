package com.fiu.manhunt.GameModel;
 
  class PowerUpCommand implements Command {
 
  private  PowerUp powerUp = null;
   
  public PowerUpCommand (PowerUp powerUp) { 
	  this.powerUp = powerUp;
  }; 
 
  public void execute()
  {
	  long startTime = System.currentTimeMillis();
	  int duration = this.powerUp.getDuration();
	  
	  while ((System.currentTimeMillis()-startTime)< duration){
		  //execution of the powerUp
		  
		  
		  
		  
		  
	  }
  }
 
}
