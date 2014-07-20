package ServerSide;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Class Webservice
 */
@Path(value = "/manhunt")
public class Webservice {
	
	// instance variables
	private int listenerPort;
	private Queue<WebserviceMessage> messageQueue;

	/**
	 * A message structure for passing messages from the queue to the controller.
	 * @author Team 3
	 *
	 */
	public class WebserviceMessage {
		public UUID id;			// id for this message
		public String action;	// the action which should be taken for this message
		public String data;		// data contained in the message, seperated by :
	}

	/**
	 * The constructor initializes the queue which should be followed by setting the port and starting the service.
	 */
	public Webservice() {
		this.messageQueue = new LinkedList<WebserviceMessage>();
	}


	/**
	 * Set the value of listener Port
	 * @param newVar the new value of listenerPort
	 */
	public void setListenerPort(int port) {
		this.listenerPort = port;
	}

	/**
	 * Get the listener Port
	 * @return the value of listenerPort
	 */
	public int getListenerPort() {
		return this.listenerPort;
	}

	public void start() {

	}

	/**
	 * This method receives and stashes the communication via HTTP service like TomCat.
	 * @param action
	 * @param data
	 */
	@POST
	@Path(value = "/update")
	public void handleRequest(@PathParam(value = "action") String action,
			@PathParam(value = "data") String data) {
		WebserviceMessage mesg = new WebserviceMessage();
		mesg.id = UUID.randomUUID(); // collisions start after 2^29.
		mesg.data = data;
		mesg.action = action;
		this.messageQueue.add(mesg);
	}

}
