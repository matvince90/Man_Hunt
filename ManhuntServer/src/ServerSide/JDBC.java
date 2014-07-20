package ServerSide;


/**
 * Class JDBC
 */
class JDBC implements DbWrapper {

    //
    // Fields
    //

  private Object dbConnection;
  
    //
    // Constructors
    //
    public JDBC () { dbConnection = new Object(); }

	public int addPlayer(Player playerInformation) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean removePlayer(int playerId) {
		// TODO Auto-generated method stub
		return false;
	}

	public GameMatch updatePlayer(Player playerInformation) {
		// TODO Auto-generated method stub
		return null;
	}

	public boolean banPlayer(Player playerInformation) {
		// TODO Auto-generated method stub
		return false;
	}

	public int createGameMatch(GameMatch gameMatch) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean removeGameMatch(int gameMatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	public boolean unBanPlayer(String playerEmail) {
		// TODO Auto-generated method stub
		return false;
	};
  
}
