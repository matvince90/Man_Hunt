package ServerSide;

import java.util.List;
import java.util.UUID;


/**
 * Class DbWrapper
 */ 
public interface DbWrapper {

    /**
     * @return       int
     * @param        playerInformation
     */
  public int addPlayer(Player playerInformation);

    /**
     * @return       boolean
     * @param        playerId
     */
  public boolean removePlayer(UUID playerId);
  
  /**
   * 
   * @param playerId
   * @return
   */
  public List getPlayer(UUID playerId);

    /**
     * @return       ServerSide.ServerGameMatch
     * @param        playerInformation
     */
  public List updatePlayer(Player playerInformation);

    /**
     * @return       boolean
     * @param        playerInformation
     */
  public boolean banPlayer(Player playerInformation);

    /**
     * @return       int
     * @param        gameMatch
     */
  public int createGameMatch(GameMatch gameMatch);

    /**
     * @return       boolean
     * @param        gameMatchId
     */
  public boolean removeGameMatch(int gameMatchId);
  
  /**
   * 
   * @return list of game matches currently active.
   */
  public List getGameMatches();
  
  /**
   * 
   * @param gameMatchId
   * @return
   */
  public List getGameMatch(int gameMatchId);


    /**
     * @return       boolean
     * @param        playerEmail
     */
  public boolean unBanPlayer(String playerEmail);


}
