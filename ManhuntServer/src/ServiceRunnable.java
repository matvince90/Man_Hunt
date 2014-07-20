/**
 * 
 * @author Team 3
 *
 */
public class ServiceRunnable implements Runnable {

	private ServerSide.GameLogicController _gameLogicController;
	public void run() {
		this._gameLogicController = new ServerSide.GameLogicController();
		this._gameLogicController.start();
	}

}
