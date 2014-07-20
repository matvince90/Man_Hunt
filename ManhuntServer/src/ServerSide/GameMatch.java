package ServerSide;

import java.util.ArrayList;
import java.util.List;


/**
 * Class ServerGameMatch
 */
public class GameMatch {

    //
    // Fields
    //

  private List<Player> matchPlayers;
  private int startTimestamp;
  private int id;
  private boolean active;
  
    //
    // Constructors
    //
    public GameMatch () { this.matchPlayers = new ArrayList<Player>(); };
  
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
  public void addMatchPlayer (Player player) {
      this.matchPlayers.add(player);
  }

    /**
     * Get the value of matchPlayers
     * @return the value of matchPlayers
     */
  public List<Player> getMatchPlayers () {
      return this.matchPlayers;
  }

    /**
     * Set the value of startTimestamp
     * @param newVar the new value of startTimestamp
     */
  public void setStartTimestamp (int time) {
      startTimestamp = time;
  }

    /**
     * Get the value of startTimestamp
     * @return the value of startTimestamp
     */
  public int getStartTimestamp () {
      return startTimestamp;
  }

    /**
     * Set the value of id
     * @param newVar the new value of id
     */
  public void setId (int newVar) {
      id = newVar;
  }

    /**
     * Get the value of id
     * @return the value of id
     */
  public int getId () {
      return id;
  }

    /**
     * Set the value of active
     * @param newVar the new value of active
     */
  public void setActive (boolean newVar) {
      active = newVar;
  }

    /**
     * Get the value of active
     * @return the value of active
     */
  public boolean getActive () {
      return active;
  }

    //
    // Other methods
    //

    /**
     * @param        player
     */
  public void addPlayer(List<Player> player)
  {
    }


    /**
     * @param        id
     */
  public void removePlayer(int id)
  {
    }


    /**
     * @return       List<Player>
     */
  public List<Player> getPlayers()
  {
	  return null;
    }


    /**
     * @return       boolean
     */
  public boolean isActive()
  {
	  return true;
    }


    /**
     * @param        id
     */
  public void ServerGameMatch(int id)
  {
    }


}
