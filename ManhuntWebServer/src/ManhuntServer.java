/**
 * ManHuntServer class spawns a thread which invokes the server application.
 * @author Team 3
 *
 */
public class ManhuntServer {

	/**
	 * Main entry point for the server application
	 * @param args
	 */
	public static void main(String[] args) {
		(new Thread(new ServiceRunnable())).start();
	}

}
