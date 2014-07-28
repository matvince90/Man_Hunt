package ServerSide;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.Semaphore;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.core.Response;

/**
 * Class Webservice
 */
@Path(value = "/manhunt")
public class Webservice implements Runnable {
	
	// instance variables
	public volatile Queue<WebserviceMessage> messageQueue;
	private Semaphore _signalController;

	/**
	 * A message structure for passing messages from the queue to the controller.
	 * @author Team 3
	 */
	public class WebserviceMessage {
		public UUID id;			// id for this message
		public String action;	// the action which should be taken for this message
		public String data;		// data contained in the message, seperated by :
	}

	/**
	 * The constructor initializes the queue which should be followed by setting the port and starting the service.
	 * @param signalController is a active sempaphore for touching the message queue.
	 */
	public Webservice(Semaphore signalController) {
		this.messageQueue = new LinkedList<WebserviceMessage>();
		_signalController = signalController;
	}

	/**
	 * This method receives and stashes the communication via HTTP service like TomCat.
	 * @param action
	 * @param data
	 */
	@POST
	@Path(value = "/update")
	@Produces("application/json")
	public Response handleRequest(@PathParam(value = "action") String action,
			@PathParam(value = "data") String data) {
		
		// create a message
		WebserviceMessage mesg = new WebserviceMessage();
		mesg.id = UUID.randomUUID(); // collisions start after 2^29.
		mesg.data = data;
		mesg.action = action;
		
		// this section needs another runnable class to handle so that we don't block the web service listener
		while(!_signalController.tryAcquire())
			this.messageQueue.add(mesg);
		_signalController.release();
		_signalController.notify();
		// end of code that needs new class.
		
		return null; // need to add a wait semaphore to this.
	}


	public void run() {
		// todo start webservice.
		
	}

}
