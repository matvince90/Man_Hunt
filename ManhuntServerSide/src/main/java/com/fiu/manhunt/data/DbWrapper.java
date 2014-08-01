package com.fiu.manhunt.data;

import java.util.List;

import com.fiu.manhunt.entities.GameMatch;
import com.fiu.manhunt.entities.Player;

/**
 * Class DbWrapper
 */ 
public interface DbWrapper {

    /**
     * @return        Player 
     * @param         playerId
     */
  public List<String> getPlayer(String email);

    /**
     * @return       boolean 
     * @param        playerInformation
     */
  public int addPlayer(Player playerInformation);

    /**
     * @return       boolean
     * @param        pid, gid
     */
  public boolean addPlayerToGameMatch(int playerId, int gameMatchId);

    /**
     * @return       boolean 
     * @param        playerInformation
     */
  public boolean updatePlayer(Player playerInformation);

    /**
     * @return       boolean
     * @param        playerId
     */
  public boolean removePlayer(int playerId);
    
    /**
     * @return       boolean
     * @param        playerInformation
     */
  public boolean banPlayer(String email);

    /**
     * @return       boolean
     * @param        pid
     */
  public boolean checkBanPlayer(String email);

    /**
     * @return       boolean
     * @param        playerEmail
     */
  public boolean unBanPlayer(String email);

    /**
     * @return        boolean 
     * @param         gameMatchId
     */
  public List<String> getGameMatch(int gameMatchId);

    /**
     * @return       boolean 
     * @param        gameMatch
     */
  public int createGameMatch(GameMatch gameMatch);

    /**
     * @return       boolean
     * @param        gameMatchId
     */
  public boolean removeGameMatch(int gameMatchId);
    
    /**
     * @return       List   
     */
  public List<Integer> getAllGameMatches();

    /**
     * @return       List<String>
     * @param        int
     */
  public List<String> getAllGameMatchPlayers(int gameMatchId);
    
}
