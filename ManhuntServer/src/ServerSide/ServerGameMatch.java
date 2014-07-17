package ServerSide;


/**
 * Class ServerGameMatch
 */
public class ServerGameMatch {

    //
    // Fields
    //

  private List<ServerSide.ServerPlayerInformation> matchPlayers;
  private int startTimestamp;
  private int id;
  private boolean active;
  
    //
    // Constructors
    //
    public ServerGameMatch () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of matchPlayers
     * @param newVar the new value of matchPlayers
     */
  private void setMatchPlayers (List<ServerSide.ServerPlayerInformation> newVar) {
      matchPlayers = newVar;
  }

    /**
     * Get the value of matchPlayers
     * @return the value of matchPlayers
     */
  private List<ServerSide.ServerPlayerInformation> getMatchPlayers () {
      return matchPlayers;
  }

    /**
     * Set the value of startTimestamp
     * @param newVar the new value of startTimestamp
     */
  private void setStartTimestamp (int newVar) {
      startTimestamp = newVar;
  }

    /**
     * Get the value of startTimestamp
     * @return the value of startTimestamp
     */
  private int getStartTimestamp () {
      return startTimestamp;
  }

    /**
     * Set the value of id
     * @param newVar the new value of id
     */
  private void setId (int newVar) {
      id = newVar;
  }

    /**
     * Get the value of id
     * @return the value of id
     */
  private int getId () {
      return id;
  }

    /**
     * Set the value of active
     * @param newVar the new value of active
     */
  private void setActive (boolean newVar) {
      active = newVar;
  }

    /**
     * Get the value of active
     * @return the value of active
     */
  private boolean getActive () {
      return active;
  }

    //
    // Other methods
    //

    /**
     * @param        playerInformation
     */
  public void addPlayer(List<ServerSide.ServerPlayerInformation> playerInformation)
  {
    }


    /**
     * @param        id
     */
  public void removePlayer(int id)
  {
    }


    /**
     * @return       List<ServerSide.ServerPlayerInformation>
     */
  public List<ServerSide.ServerPlayerInformation> getPlayers()
  {
    }


    /**
     * @return       boolean
     */
  public boolean isActive()
  {
    }


    /**
     * @param        id
     */
  public void ServerGameMatch(int id)
  {
    }


}
