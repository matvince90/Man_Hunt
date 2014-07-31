package com.fiu.manhunt.server;

import java.util.List;

import com.fiu.manhunt.entities.Player;
import com.google.gson.Gson;

public class PlayerMessageDataFactory {
	
	public static PlayerMessageData createPlayerMessageData(List<Player> players) {
		return null;
	}
	
	public static PlayerMessageData.PlayerData createPlayerData(Player player) {
		return null;
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
