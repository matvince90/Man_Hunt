package com.fiu.manhunt.data;

import java.util.*;
import java.sql.*;

import com.fiu.manhunt.entities.Player;
import com.fiu.manhunt.entities.GameMatch;

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

    
    public List<String> getPlayer(String email) {
   
        ArrayList<String> playerData = null;
        int playerId = 0;

        try {
            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT * " +
                                 "FROM Player " + 
                                 "WHERE email='" + email + "'");
            
            playerData = new ArrayList<String>();

            while(rs.next()) {
                playerData.add(rs.getString("pid"));
                playerId = rs.getInt("pid");
                playerData.add(rs.getString("email"));
                playerData.add(rs.getString("latitude"));
                playerData.add(rs.getString("longitude"));
                playerData.add(rs.getString("status"));
            }

            rs.close();
            st.close();

            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT gid FROM GameMatchPlayers " +
                                "WHERE pid=" + playerId);

            if(rs.next()) {
                playerData.add(rs.getString("gid"));
            }
            else {
                playerData.add("0");
            }

            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return playerData;
        }

        return playerData;
    }

    
	public int addPlayer(Player playerInformation) {
      
        int pid = 0;

        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("INSERT INTO Player " + 
                    "(pid, email, latitude, longitude, status) VALUES (DEFAULT, '" + 
                    playerInformation.getEmail() + "','" +
                    playerInformation.getLatitude() + "','" +
                    playerInformation.getLongitude() + "','" +
                    playerInformation.getType() + "')");

            st.close();

            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT currval('player_pid_seq')");

            while(rs.next()) {
                pid = rs.getInt("currval");
            }

            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return pid; 
        }

		return pid;
	}

    
    public boolean addPlayerToGameMatch(int pid, int gid) {

        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("INSERT INTO gamematchplayers " +
                             "(pid, gid) VALUES (" +
                             pid + ", " + gid + ")");

            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    
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

    
	public boolean updatePlayer(Player playerInformation) {
	
        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("UPDATE Player " +
                             "SET email='" + playerInformation.getEmail() + "', " +
                             "latitude=" + playerInformation.getLatitude() + ", " + 
                             "longitude=" + playerInformation.getLongitude() + ", " + 
                             "status=" + playerInformation.getType() + 
                             "WHERE pid=" + playerInformation.getId());

            st.close();
        }
        catch (SQLException e) {
                e.printStackTrace();
                return false;
        }

		return true;
	}

    
	public boolean banPlayer(String email) {
       
        int pid = 0;

        try {
            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM Player " +
                                 "WHERE email='" + email + "'");

            while(rs.next()) {
                pid = rs.getInt("pid");
            }

            rs.close();
            st.close();

            st = _dbConnection.createStatement();
            st.executeUpdate("INSERT INTO BanList VALUES (" +
                             pid + ")"); 
   
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

		return true;
	}

    
    public boolean checkBanPlayer(String email) {

        int playerId = 0;

        try {
            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT pid FROM Player " +
                                 "WHERE email='" + email + "'");

            while(rs.next()) {
                playerId = rs.getInt("pid");
            }

            rs.close();
            st.close();

            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM BanList " +
                                 "WHERE pid=" + playerId);

            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }

        return true;
    }

    
    public boolean unBanPlayer(String email) {
	  
        int pid = 0;

        try {
            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM Player " +
                                 "WHERE email='" + email + "'");

            while(rs.next()) {
                pid = rs.getInt("pid");
            }

            rs.close();
            st.close();

            st = _dbConnection.createStatement();
            st.executeUpdate("DELETE FROM BanList WHERE pid=" + pid);

            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return false;
        }
		return true;
	}

    
	public List<String> getGameMatch(int gameMatchId) {
	
        ArrayList<String>  gameMatchData = new ArrayList<String>();

        try {
            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT * " +
                                 "FROM GameMatch " +
                                 "WHERE gid=" + gameMatchId);

            while(rs.next()) {
                gameMatchData.add(rs.getString("gid"));
                gameMatchData.add(rs.getString("startTime"));
                gameMatchData.add(rs.getString("active"));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
                
		return gameMatchData;
	}

    
	public int createGameMatch(GameMatch gameMatch) {
       
        int gid = 0;

        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("INSERT INTO GameMatch " + 
                             "(gid, starttime, active) VALUES (DEFAULT, '" +
                             gameMatch.getStartTimestamp() + "'," +
                             gameMatch.isActive() + ")");

            st.close();

            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT currval('gamematch_gid_seq')");

            while(rs.next()) {
                gid = rs.getInt("currval");
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
            return gid;
        }

		return gid;
	}

    
	public boolean removeGameMatch(int gameMatchId) {

        try {
            st = _dbConnection.createStatement();
            st.executeUpdate("DELETE FROM GameMatch WHERE gid=" + gameMatchId);

            st.close();
        }
        catch(SQLException e) {
            e.printStackTrace();
            return false;
        }

		return true;
	}

    
    public List<Integer> getAllGameMatches() {
        
        ArrayList<Integer> allGameMatches = new ArrayList<Integer>();

        try {
            st = _dbConnection.createStatement();
            rs = st.executeQuery("SELECT * FROM GameMatch");

            while(rs.next()) {
                allGameMatches.add(rs.getInt("gid"));
            }

            rs.close();
            st.close();
        }
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }

        return allGameMatches;
    }

    
    public List<Integer> getAllGameMatchPlayers(int gameMatchId) {

        return null;
    }
}
