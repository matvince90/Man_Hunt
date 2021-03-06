package com.fiu.manhunt.entities;

import java.util.ArrayList;
import java.util.List;

import com.fiu.manhunt.data.DbWrapper;
import com.fiu.manhunt.server.ServerOutput;

/**
 * Class ServerGameMatch
 */
public class GameMatch {
	private DbWrapper _dbCon;
	private List<Player> _matchPlayers;
	private int _startTimestamp;
	private int _id;
	private boolean _active;
  
	/**
	 * returns a newly created game match
	 */
	public GameMatch(DbWrapper db) {
		_dbCon = db;
		_matchPlayers = new ArrayList<Player>();
		//_id = _dbCon.getHighestId() + 1;
		_dbCon.createGameMatch(this);
	}
	/**
	 * returns a game match with db context
	 * @param id, game match id
	 */
	public GameMatch(int id, DbWrapper db) {
		_dbCon = db;
		List<String> gm = _dbCon.getGameMatch(id);
		if(gm != null && gm.size() > 0) {
			_id = id;
			_matchPlayers = new ArrayList<Player>();
			List<String> pIds = _dbCon.getAllGameMatchPlayers(id);
			for(String i: pIds) {
				if(!_dbCon.checkBanPlayer(i.toLowerCase()))
					_matchPlayers.add(new Player(i, _dbCon));
				else
					ServerOutput.println("Match init found banned player in match, removed from output.");
					
			}
		}
	}
    
    /**
     * Set the value of matchPlayers
     * @param newVar the new value of matchPlayers
     */
    public void addMatchPlayer (Player player, int matchId) {
    	int id = _dbCon.addPlayer(player);
    	_dbCon.addPlayerToGameMatch(id, matchId);
    	if(id > 0){
    		_matchPlayers.add(player);
    	}
	}
  
    /**
     * Get the value of matchPlayers
     * @return the value of matchPlayers
     */
  	public List<Player> getMatchPlayers(String doNotInclude) {
  		List<Player> result = new ArrayList<Player>();
  		// strip out the requesting player
  		for(Player p: _matchPlayers) {
  			if(!p.getEmail().equalsIgnoreCase(doNotInclude)) {
  				result.add(p);
  			}
  		}
  		return result;
	}
  	/**
  	 * 
  	 * @param player
  	 */
  	public void updateMatchPlayer(Player player) {
  		int totalPlayers = _matchPlayers.size();
  		for(int i = 0; i < totalPlayers; i++) {
  			Player p = _matchPlayers.get(i);
  			if(p.getId() == player.getId()) {
  				_matchPlayers.set(i, player);
  				_dbCon.updatePlayer(player);
  				break;
  			}
  		}
	}

    /**
     * Get the value of startTimestamp
     * @return the value of startTimestamp
     */
	public int getStartTimestamp () {
  		return _startTimestamp;
	}

    /**
     * Get the value of id
     * @return the value of id
     */
	public int getId () {
  		return _id;
	}

    /**
     * Return game active state
     * @return       boolean
     */
	public boolean isActive(){
  		return _active;
	}

    /**
     * Set the value of active
     * @param newVar the new value of active
     */
	public void setActive (boolean active) {
  		_active = active;
	}
  	
    //
    // Other methods
    //
  	
    /**
     * Add new players to game from given list
     * @param        player
     */
  	public void addPlayer(List<Player> player){
  		for(Player p : player){
  			addMatchPlayer(p, _id);
  		}
	}

    /**
     * remove a player from given ID
     * @param        id
     */
  	public void removePlayer(int id){
  		for(Player p : _matchPlayers) {
  			if (p.getId() == id) {
  				_matchPlayers.remove(p);
  				_dbCon.removePlayer(p.getId());
  			}
  		}
  	}
}
