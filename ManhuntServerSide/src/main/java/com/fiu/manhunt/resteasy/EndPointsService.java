package com.fiu.manhunt.resteasy;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.FormParam;
import javax.ws.rs.core.Response;

import com.fiu.manhunt.server.GameLogicController;
import com.fiu.manhunt.server.PlayerMessageData;
import com.fiu.manhunt.server.PlayerMessageDataFactory;

import com.google.gson.Gson;

/**
 * This endpoint set currently only has one endpoint, that is update and is exposed as {host}/manhunt/update
 * update takes a playerdata localclass via playermessagedata and updates the controller with the new information, returning the state
 * of the current game match from the database input and output is expected to be in JSON.
 * @author Team 3
 *
 */
@Path("/manhunt")
public class EndPointsService {

	/**
	 * This endpoint expects to receive POST data in JSON format that is equivalent to PlayerMEssageData.PlayerData
	 * object. It will parse the JSON into the strongly typed object and update the controller with the new data
	 * Finally, returning the games state as the response to the request.
	 * @param playerJsonData
	 * @return
	 */
	@GET
	public Response responseMsg( @FormParam("playerJsonData") String playerJsonData) {
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