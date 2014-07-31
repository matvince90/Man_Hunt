package com.fiu.manhunt.resteasy;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.Response;

@Path("/manhunt")
public class RESTEasyHelloWorldService {

	@GET
	@Path("/update")
	public Response responseMsg( @PathParam("pathParameter") String pathParameter, 
			@DefaultValue("Nothing to say") @QueryParam("queryParameter") String queryParameter) {
		// exposed at http://localhost:8081/ManhuntServerSide/rest/RESTEasyHelloWorld/JavaCodeGeeks?=029394
		String response = "Hello from: " + pathParameter + " : " + queryParameter;

		return Response.status(200).entity(response).build();
	}
}