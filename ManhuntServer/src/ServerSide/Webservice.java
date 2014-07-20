package ServerSide;

import java.util.LinkedList;
import java.util.Queue;
import java.util.UUID;
import java.util.concurrent.Semaphore;

import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;

/**
 * Class Webservice
 */
@Path(value = "/manhunt")
public class Webservice implements Runnable {
	
	// instance variables
	public volatile Queue<WebserviceMessage> messageQueue;
	private Semaphore signalController;

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
	public Webservice(Semaphore signalController) {
		this.messageQueue = new LinkedList<WebserviceMessage>();
		this.signalController = signalController;
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
		// this section needs another runnable class to handle so that we don't block the web service listener
		while(!this.signalController.tryAcquire())
			this.messageQueue.add(mesg);
		this.signalController.release();
		this.signalController.notify();
		// end of code that needs new class.
	}


	public void run() {
		// TODO Auto-generated method stub
		
	}

}
