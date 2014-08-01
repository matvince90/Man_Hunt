package com.fiu.manhunt.GameModel;

import android.location.Location;
import java.util.*;

public class Player {

	public enum Type {
		Predator, Prey
	}

	private long powerUpUseTimestamp;
	private String name;
	private String playerType;
	private List<PowerUp> powerUpInventory;
	private Location location;
	private UUID id;

	//
	// Constructors
	//
	public Player(UUID id, Player.Type type) {
		this.powerUpInventory = new LinkedList<PowerUp>();
		this.location = null;
		this.playerType = type.toString();
		this.id = id;
	};
  
	public void resetPowerUpUseTimestamp() {
		powerUpUseTimestamp = System.currentTimeMillis();
	}

	public Location getLocation() {
		return location;
	}

	public void hideLocation() {
		this.location = null;
	}

	public long getPowerUpLastUsedTimestamp() {
		return powerUpUseTimestamp;
	}

	public void setPlayerType(Type newVar) {
		playerType = newVar.toString();
	}

	public String getPlayerType() {
		return playerType;
	}

	public void setPowerUpInventory(List<PowerUp> inventory) {
		powerUpInventory = inventory;
	}

	public List<PowerUp> getPowerUpInventory() {
		return powerUpInventory;
	}

	public void addPowerUp(PowerUp powerUp) {
		this.powerUpInventory.add(powerUp);
	}

	public void removePowerUp(PowerUp powerUp) {
		this.powerUpInventory.remove(powerUp);
	}

	public void setLocation(Location newVar) {
		location = newVar;
	}

	public void setId(UUID newVar) {
		id = newVar;
	}

	public UUID getId() {
		return id;
	}

	public void getPlayerName() {
		// Logic to get playerName using player id

	}

	public void setLocations(Location location) {
	}

	public void cleanPowerUps() {
		this.powerUpInventory.clear();
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
}
