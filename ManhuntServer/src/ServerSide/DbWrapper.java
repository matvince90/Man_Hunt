package ServerSide;


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
  public boolean removePlayer(int playerId);


    /**
     * @return       ServerSide.ServerGameMatch
     * @param        playerInformation
     */
  public GameMatch updatePlayer(Player playerInformation);


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
     * @return       boolean
     * @param        playerEmail
     */
  public boolean unBanPlayer(String playerEmail);


}
