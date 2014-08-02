package gamemodels;

class CloakPowerUp implements PowerUpCommand {

	private Player player;
	private PowerUp powerUp;
	private GameMatchSingleton gameMatch;

	public CloakPowerUp(Player currentPlayer) {
		// this.player gets current player
		this.player = currentPlayer;
		this.powerUp = new PowerUp();
		this.gameMatch = GameMatchSingleton.getInstance();
	}

	public void execute() {
		// Cool down: making sure cool down is not active
		// if the time that has passed since last power up use is greater than
		// the cool down, then execute
		if (System.currentTimeMillis() - player.getPowerUpLastUsedTimestamp() > powerUp
				.getCoolDown()) {
			this.powerUp.setIsActive(true);

			// Removes current powerUp from User
			this.player.removePowerUp(powerUp);

			long startTime = System.currentTimeMillis();
			long powerUpDuration = this.powerUp.getDuration();

			// If the PowerUp selected was 'Cloak'
			if (this.powerUp.getType() == PowerUp.PowerUps.Cloak) {
				// Hides location indefinitely until location is set to be
				// displayed again
				this.gameMatch.hideCurrentPlayer();

				while ((System.currentTimeMillis() - startTime) < powerUpDuration) {
					try {
						Thread.sleep(powerUpDuration);
					} catch (InterruptedException e) {
						System.out.println(e);
					}
				}

				this.player.getLocation();
			} else {
				// Space for future PowerUp Implementations
			}

			this.powerUp.setIsActive(false);
		}

	}

}
