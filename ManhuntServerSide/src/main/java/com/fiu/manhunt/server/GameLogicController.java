package com.fiu.manhunt.server;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import com.fiu.manhunt.data.DbWrapper;
import com.fiu.manhunt.data.JDBC;
import com.fiu.manhunt.entities.GameMatch;
import com.fiu.manhunt.entities.Player;

/**
 * Class GameLogicController
 */
public class GameLogicController {

	// constants
	private static final int MAX_PLAYERS = 50;				// max players per instance.
	private static final int MAX_GAME_INSTANCES = 1;		// maximum number of instances.

	private static List<GameMatch> _gameMatches;				// list of game matches
	private static DbWrapper _dbWrapper;					// db class
	
	private static GameLogicController _instance = null;	// singleton instance

	/**
	 * 
	 * @param dbCon
	 */
	protected GameLogicController(DbWrapper dbCon) {
		_dbWrapper = dbCon;
		_gameMatches = new ArrayList<GameMatch>();
		initStateSetup();
	}
	
	/**
	 * 
	 * @return
	 */
	public static GameLogicController getInstance() {
		if(_instance == null) {
			JDBC db = new JDBC();
			_instance = new GameLogicController(db);
		}
		return _instance;
	}

	/**
	 * 
	 */
	private void initStateSetup() {
		List<Integer> gameMatchIds =  _dbWrapper.getAllGameMatches();
		for(int id: gameMatchIds) {
			_gameMatches.add(new GameMatch(id, _dbWrapper));
		}
		if(_gameMatches.size() < 1)
			createMatch();
	}
	
	/**
	 * Update the player
	 * @param playerData
	 * @return
	 */
	public PlayerMessageData updatePlayer(PlayerMessageData.PlayerData playerData) {
		if(playerData.get_email().isEmpty() || playerData.get_lat() < 0 || playerData.get_long() < 0 || !validateEmail(playerData.get_email()))
			return null;
		
		// attempt to get the game match.
		GameMatch gm = new GameMatch(_gameMatches.get(0).getId(), _dbWrapper);
		
		
		// check if game match is valid
		if(gm.getId() > 0) {
			// attempt to get the player by email
			Player player = new Player(playerData.get_email(), _dbWrapper);
			
			// either way set the update variables
			player.setLatitude(playerData.get_lat());
			player.setLongitude(playerData.get_long());
			player.setType(playerData.get_type());
			// check if we are updating this player or adding it
			if(player.getId() > 0)  {
				gm.updateMatchPlayer(player);
			} else {
				player.set_email(playerData.get_email());
				gm.addMatchPlayer(player, gm.getId());
			}
			
			// get the list of players in the current match.
			List<Player> gmPlayers = gm.getMatchPlayers();
			if(gmPlayers.size() > 0)
				return PlayerMessageDataFactory.createPlayerMessageData(gmPlayers);
		}
		
		return null;
		
	}
	
	private void createMatch() {
		if(_gameMatches.size() < MAX_GAME_INSTANCES) {
			_gameMatches.add(new GameMatch(_dbWrapper));
		}
	}
	
	private boolean validateEmail(String email) {
		Pattern p = Pattern.compile(".+@.+\\.[a-z]+");
		Matcher m = p.matcher(email);
		boolean matchFound = m.matches();
		if (matchFound) {
			return true;
		}
		return false;
	}

}
