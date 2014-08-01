package com.fiu.manhunt.test.modules;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;

import org.junit.Test;

import com.fiu.manhunt.server.GameLogicController;
import com.fiu.manhunt.server.PlayerMessageData;
import com.fiu.manhunt.server.PlayerMessageDataFactory;

import com.google.gson.Gson;

public class ControllerTest {
	@Test
	public String TestPlayerUpdate(String playerJsonData) {
		PlayerMessageData.PlayerData playerData = PlayerMessageDataFactory.createPlayerData(playerJsonData);
		
		//assertNull("Player data expected to be parsed, not null.", playerData);
		// if we recieved valid json then move along.
		if(playerData != null) {
			
			// get the glc singleton instance
			GameLogicController glc = GameLogicController.getInstance();
			
			// create json from updated player list.
			Gson gson = new Gson();
			
			// get the update list as well as update the player sending request and turn it into json.
			String jsonMessage = gson.toJson(glc.updatePlayer(playerData));
			
			//assertNull("GameMatch data expected to be serial json, not null.", playerData);
			
			// check for valid output and talk back.
			if(jsonMessage != null)
				return jsonMessage;
		}
		
		return null;
	}// 5432
}
