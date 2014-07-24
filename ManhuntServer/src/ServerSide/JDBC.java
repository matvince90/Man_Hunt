package ServerSide;

import java.util.List;
import java.util.UUID;


/**
 * Class JDBC
 */
class JDBC implements DbWrapper {

    //
    // Fields
    //

  private Object _dbConnection;
  
    //
    // Constructors
    //
    public JDBC () { _dbConnection = new Object(); }

	public int addPlayer(Player playerInformation) {
		// TODO Auto-generated method stub
		return 0;
	}

	public boolean removePlayer(int playerId) {
		// TODO Auto-generated method stub
		return false;
	}

	public List updatePlayer(Player playerInformation) {
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
	}

	@Override
	public boolean removePlayer(UUID playerId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public List getPlayer(UUID playerId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List getGameMatch(int gameMatchId) {
		// TODO Auto-generated method stub
		return null;
	};
  
}
