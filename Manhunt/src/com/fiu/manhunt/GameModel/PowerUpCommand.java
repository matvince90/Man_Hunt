package com.fiu.manhunt.GameModel;
 
  class PowerUpCommand implements Command {
 
  private Player player;
  private PowerUp powerUp;
  private GameMatchSingleton gameMatch;
  
  public PowerUpCommand (Player player, PowerUp powerUp) { 
	  this.player = player;
	  this.powerUp = powerUp;
	  this.gameMatch = GameMatchSingleton.getInstance();
  }
 
  public void execute() 
  { 
	  //Cool down: making sure cool down is not active
	  //if the time that has passed since last power up use is greater than the cool down, then execute
	  if(System.currentTimeMillis() - player.getPowerUpLastUsedTimestamp() > powerUp.getCoolDown())
	  {
		  this.powerUp.setIsActive(true);
		  
		  //Removes current powerUp from User
		  this.player.removePowerUp(powerUp); 
		  
		  long startTime = System.currentTimeMillis();
		  long powerUpDuration = this.powerUp.getDuration();
		  
		  //If the PowerUp selected was 'Cloak'
		  if(this.powerUp.getType() == PowerUp.PowerUps.Cloak)
		  {
			  //Hides location indefinitely until location is set to be displayed again
			  this.player.hideLocation(); 
			  
			  while ((System.currentTimeMillis()-startTime)< powerUpDuration)
			  {
				  try{
					  Thread.sleep(1000);
				  }
				  catch(InterruptedException e)
				  {
					  System.out.println(e);
				  }
			  }
			  
			  this.player.getLocation(); 
		  }
		  else
		  {
			  //Space for future PowerUp Implementations
		  }
		  
		  this.powerUp.setIsActive(false); 
	  }
	  
  }
 
}
