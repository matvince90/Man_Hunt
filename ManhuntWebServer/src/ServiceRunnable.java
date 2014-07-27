/**
 * 
 * @author Team 3
 *
 */
public class ServiceRunnable implements Runnable {

	private ServerSide.GameLogicController _gameLogicController;
	public void run() {
		JDBC dbCon = new JDBC();
		this._gameLogicController = new ServerSide.GameLogicController(dbCon);
		this._gameLogicController.start();
	}

}
