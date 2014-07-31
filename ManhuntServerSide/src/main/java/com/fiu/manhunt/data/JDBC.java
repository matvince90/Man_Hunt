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
    private ResultSet rs;
  
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
    public List<String> getPlayer(int playerId) {
   
        ArrayList<String> playerData = new ArrayList<String>();

        try {
            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT * " +
                                           "FROM Player " + 
                                           "WHERE pid=" + playerId);

            while(rs.next()) {
                playerData.add(rs.getString("pid"));
                playerData.add(rs.getString("email"));
                playerData.add(rs.getString("latitude"));
                playerData.add(rs.getString("longitude"));
                playerData.add(rs.getString("type"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return playerData;
    }

    @Override
	public int addPlayer(Player playerInformation) {
      
        int pid = 0;

        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("INSERT INTO Player " + 
                    "(pid, email, latitude, longitude, type) VALUES (DEFAULT, '" + 
                    playerInformation.getEmail() + "','" +
                    playerInformation.getLatitude() + "','" +
                    playerInformation.getLongitude() + "','" +
                    playerInformation.getType() + "')");

            st.close();

            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT pid FROM Player WHERE email='" +
                            playerInformation.getEmail() + "'");

            while(rs.next()) {
                pid = rs.getInt("pid");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return pid; 
        }

		return pid;
	}

    @Override
	public boolean removePlayer(int playerId) {
	
        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("DELETE FROM Player WHERE pid=" + playerId);

            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

		return true;
	}

    @Override
	public boolean updatePlayer(Player playerInformation) {
	
        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("UPDATE Player " +
                             "SET email='" + playerInformation.getEmail() + "', " +
                             "latitude=" + playerInformation.getLatitude() + ", " + 
                             "longitude=" + playerInformation.getLongitude() + ", " + 
                             "type=" + playerInformation.getType() + 
                             "WHERE pid=" + playerInformation.getId());

            st.close();
        }
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
                             playerInformation.getId() + "','" +
                             playerInformation.getEmail() + "','" +
                             playerInformation.getLatitude() + "','" +
                             playerInformation.getLongitude() + "','" +
                             playerInformation.getType() + "')");
    
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

		return false;
	}

    @Override
    public boolean unBanPlayer(int playerId) {
	    
        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("DELETE FROM BanList WHERE pid=" + playerId);

            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

		return true;
	}

    @Override
	public List<String> getGameMatch(int gameMatchId) {
		// TODO Auto-generated method stub
		return null;
	}

    @Override
	public int createGameMatch(GameMatch gameMatch) {
        // TODO 
		return 0;
	}

    @Override
	public boolean removeGameMatch(int gameMatchId) {
		// TODO Auto-generated method stub
		return false;
	}

    @Override
    public List<Integer> getGameMatches() {
        // TODO
        return null;
    }
}
