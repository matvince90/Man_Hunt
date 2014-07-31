package src.test;

import com.fiu.manhunt.server.GameLogicController;
import com.fiu.manhunt.server.PlayerMessageData;

import com.google.gson.Gson;

public class ControllerTest {
	
	public static void main(String[] args) {
		PlayerMessageData.PlayerData pd = new PlayerMessageData.PlayerData();
		pd.set_email("test@gmail.com");
		pd.set_lat((double) 049.2049902);
		pd.set_long((double) 25.253535);
		GameLogicController glc = GameLogicController.getInstance();
		PlayerMessageData playerData = glc.updatePlayer(pd);
		Gson gson = new Gson();
		String json = gson.toJson(playerData);
	}
}