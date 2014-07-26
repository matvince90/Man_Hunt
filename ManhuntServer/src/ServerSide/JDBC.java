//package ServerSide;

import java.util.*;
import java.sql.*;

/**
 * Class JDBC
 */
class JDBC implements DbWrapper {

    // Fields
    private Connection _dbConnection;
    private Statement st;
  
    // Constructors
    public JDBC () { 
       
        _dbConnection = null;

        try {
            Class.forName("org.postgresql.Driver");
            String url = "jdbc:postgresql://127.0.0.1/ManhuntDB";
            _dbConnection = DriverManager.getConnection(url, "mahmed", "M4u1S6a6");
        }
        catch (ClassNotFoundException e) {
            e.printStackTrace();
            System.exit(1);
        }
        catch (SQLException e) {
            e.printStackTrace();
            System.exit(2);
        }
    }

    @Override
    public boolean getPlayer(UUID playerId) {
    
        try {

        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    @Override
	public int addPlayer(Player playerInformation) {
       
        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("INSERT INTO Player VALUES ('" + 
                    playerInformation.getId() + "','" + 
                    playerInformation.getEmail() + "','" +
                    playerInformation.getLatitude() + "','" +
                    playerInformation.getLongitude() + "','" +
                    playerInformation.getType() + "')");
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return -1; 
        }

		return 0;
	}

    @Override
	public boolean removePlayer(UUID playerId) {
	
        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("DELETE FROM Player WHERE pid=" + playerId);
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

		return false;
	}

    @Override
	public boolean updatePlayer(Player playerInformation) {
	
        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("UPDATE Player " +
                             "SET email=" + playerInformation.getEmail + ", " +
                             "SET latitude=" + playerInformation.getLatitude + ", " + 
                             "SET longitude=" + playerInformation.getLongitude + ", " + 
                             "SET status=" + playerInformation.getStatus + 
                             "WHERE pid=" + playerInformation.getId);
            st.close();
            catch (SQLException e) {
                e.printStackTrace();
                return false;
            }

		return true;
	}

    @Override
	public boolean banPlayer(Player playerInformation) {
        
        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("INSERT INTO BanList VALUES ('" +
                             "playerInformation.getId() + "')");
            st.close()
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

		return false;
	}

    @Override
    public boolean unBanPlayer(String playerEmail) {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
	public boolean createGameMatch(GameMatch gameMatch) {
		// TODO Auto-generated method stub
		return 0;
	}

    @Override
	public boolean removeGameMatch(int gameMatchId) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean getGameMatch(int gameMatchId) {
		// TODO Auto-generated method stub
		return null;
	}
  
}
