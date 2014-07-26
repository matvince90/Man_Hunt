//package ServerSide;

import java.util.List;
import java.util.UUID;


/**
 * Class DbWrapper
 */ 
public interface DbWrapper {

    /**
     * @return       boolean 
     * @param        playerInformation
     */
  public boolean addPlayer(Player playerInformation);

    /**
     * @return       boolean
     * @param        playerId
     */
  public boolean removePlayer(UUID playerId);
  
    /**
     * @return        Player 
     * @param         playerId
     */
  public Player getPlayer(UUID playerId);

    /**
     * @return       boolean 
     * @param        playerInformation
     */
  public boolean updatePlayer(Player playerInformation);

    /**
     * @return       boolean
     * @param        playerInformation
     */
  public boolean banPlayer(Player playerInformation);

    /**
     * @return       boolean 
     * @param        gameMatch
     */
  public boolean createGameMatch(GameMatch gameMatch);

    /**
     * @return       boolean
     * @param        gameMatchId
     */
  public boolean removeGameMatch(int gameMatchId);
  
    /**
     * @return        boolean 
     * @param         gameMatchId
     */
  public boolean getGameMatch(int gameMatchId);

    /**
     * @return       List   
     */
  public List getGameMatches();

    /**
     * @return       boolean
     * @param        playerEmail
     */
  public boolean unBanPlayer(String playerEmail);

}
