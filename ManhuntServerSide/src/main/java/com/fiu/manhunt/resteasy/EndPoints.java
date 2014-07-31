package com.fiu.manhunt.resteasy;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

import com.fiu.manhunt.server.GameLogicController;
import com.fiu.manhunt.server.PlayerMessageData;
import com.fiu.manhunt.server.PlayerMessageDataFactory;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

/**
 * 
 * @author Team 3
 *
 */
@Path("/manhunt")
public class EndPoints {

	/**
	 * 
	 * @param playerJsonData
	 * @return
	 */
	@GET
	@Path("/update")
	public Response responseMsg( @FormParam("mdata") String playerJsonData) {
		// exposed at http://localhost:8081/ManhuntServerSide/rest/manhunt/update

		// use the playerdata factory to create a valid player object
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
				return Response.status(200).entity(jsonMessage).build();
		}
		
		// something was null.
		return Response.status(500).entity("You broke it!").build();
	}
}