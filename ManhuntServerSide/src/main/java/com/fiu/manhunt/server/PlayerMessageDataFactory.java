package com.fiu.manhunt.server;

import java.util.List;

import com.fiu.manhunt.entities.Player;
import com.google.gson.Gson;

/**
 * Set of static factory methods for creating player message data to be parsed from or serialized to JSON.
 * @author Team 3
 */
public class PlayerMessageDataFactory {
	
	/**
	 * Takes a list of player objects and strips them down to the necessary attributes for clients
	 * to update the game state.
	 * @param players takes as a parameter a list of player objects
	 * @return an arbitrary array of PlayerData objects contained within a message object
	 */
	public static PlayerMessageData createPlayerMessageData(List<Player> players) {
		PlayerMessageData playerMessageData = new PlayerMessageData();
		int playerCount = players.size(), 
				i = 0;
		if(playerCount > 0) {
			playerMessageData.playerData = new PlayerMessageData.PlayerData[playerCount];
			for(Player player: players)
				playerMessageData.playerData[i++] = PlayerMessageDataFactory.createPlayerData(player, playerMessageData);
			return playerMessageData;
				
		}
		return null;
	}
	
	/**
	 * 
	 * @param player
	 * @param pmd
	 * @return
	 */
	public static PlayerMessageData.PlayerData createPlayerData(Player player, PlayerMessageData pmd) {
		PlayerMessageData.PlayerData playerData = pmd.new PlayerData();
		playerData.set_lat(player.getLatitude());
		playerData.set_long(player.getLongitude());
		playerData.set_type(player.getType());
		return playerData;
	}
	
	/**
	 * 
	 * @param playerJson
	 * @return
	 */
	public static PlayerMessageData.PlayerData createPlayerData(String playerJson) {
		try {
			PlayerMessageData.PlayerData playerData = new Gson().fromJson(playerJson, PlayerMessageData.PlayerData.class);
			return playerData;
		} catch(com.google.gson.JsonSyntaxException ex) {
			return null;
		} catch(com.google.gson.JsonParseException ex) {
			return null;
		}
	}

}
