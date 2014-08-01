package com.fiu.manhunt.GameModel;

public class PowerUpCommandFactory {
	
	private Player player;

	public PowerUpCommandFactory(Player player) {
		this.player = player;
	}

	public PowerUpCommand CreatePowerUpCommand(PowerUp.PowerUps type) {

		PowerUpCommand powerUpCommand = null;

		if (type == PowerUp.PowerUps.Cloak) 
		{
			powerUpCommand = new CloakPowerUp(player);
		}
		
		return powerUpCommand;
	}

}
