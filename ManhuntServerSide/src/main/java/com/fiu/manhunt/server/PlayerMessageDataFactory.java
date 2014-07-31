package com.fiu.manhunt.server;

import java.util.List;

import com.fiu.manhunt.entities.Player;
import com.google.gson.Gson;

public class PlayerMessageDataFactory {
	
	public static PlayerMessageData createPlayerMessageData(List<Player> players) {
		PlayerMessageData playerMessageData = new PlayerMessageData();
		int playerCount, i = 0;
		if((playerCount = players.size()) > 0) {
			playerMessageData.playerData = new PlayerMessageData.PlayerData[playerCount];
			for(Player player: players)
				playerMessageData.playerData[i++] = PlayerMessageDataFactory.createPlayerData(player);
				
		}
		return null;
	}
	
	public static PlayerMessageData.PlayerData createPlayerData(Player player) {
		PlayerMessageData.PlayerData playerData = new PlayerMessageData.PlayerData();
		playerData.set_lat(player.getLatitude());
		playerData.set_long(player.getLongitude());
		playerData.set_type(player.getType());
		return playerData;
	}
	
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
