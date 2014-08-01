package com.fiu.manhunt.test.modules;

import com.fiu.manhunt.server.GameLogicController;
import com.fiu.manhunt.server.PlayerMessageData;
import com.fiu.manhunt.server.PlayerMessageDataFactory;
import com.google.gson.Gson;

public class ControllerTest {

	public String TestPlayerUpdate(String playerJsonData) {

		PlayerMessageData.PlayerData playerData = PlayerMessageDataFactory.createPlayerData(playerJsonData);

		// if we recieved valid json then move along.
		if(playerData != null) {
			
			// get the glc singleton instance
			GameLogicController glc = GameLogicController.getInstance();

			// create json from updated player list.
			Gson gson = new Gson();
			

			// get the update list as well as update the player sending request and turn it into json.
			String jsonMessage = gson.toJson(glc.updatePlayer(playerData));

			// check for valid output and talk back.
			if(jsonMessage != null)
				return jsonMessage;
		}
		
		return null;
	}// 5432
}
