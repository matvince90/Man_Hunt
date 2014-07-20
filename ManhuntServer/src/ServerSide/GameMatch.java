package ServerSide;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;


/**
 * Class ServerGameMatch
 */
public class GameMatch {

  private List<Player> _matchPlayers;
  private int _startTimestamp;
  private int _id;
  private boolean _active;
  
    //
    // Constructors
    //
    public GameMatch () { _matchPlayers = new ArrayList<Player>(); };

    /**
     * Set the value of matchPlayers
     * @param newVar the new value of matchPlayers
     */
  public void addMatchPlayer (Player player) {
      _matchPlayers.add(player);
  }

    /**
     * Get the value of matchPlayers
     * @return the value of matchPlayers
     */
  public List<Player> getMatchPlayers () {
      return _matchPlayers;
  }
  
  public Player getMatchPlayer(UUID uid) {
	  for(Player p: _matchPlayers) {
		  if(uid.equals(p.getId()))
			  return p;
	  }
	  return null;
  }
  
  public void updateMatchPlayer(Player player) {
	  for(int i = 0; i < _matchPlayers.size(); i++) {
		  Player p = _matchPlayers.get(i);
		  if(p.getId().equals(player.getId()))
			  _matchPlayers.add(i, player);
	  }
  }

    /**
     * Set the value of startTimestamp
     * @param newVar the new value of startTimestamp
     */
  public void setStartTimestamp (int time) {
      _startTimestamp = time;
  }

    /**
     * Get the value of startTimestamp
     * @return the value of startTimestamp
     */
  public int getStartTimestamp () {
      return _startTimestamp;
  }

    /**
     * Set the value of id
     * @param newVar the new value of id
     */
  public void setId (int id) {
      _id = id;
  }

    /**
     * Get the value of id
     * @return the value of id
     */
  public int getId () {
      return _id;
  }

    /**
     * Set the value of active
     * @param newVar the new value of active
     */
  public void setActive (boolean active) {
      _active = active;
  }

    /**
     * Get the value of active
     * @return the value of active
     */
  public boolean getActive () {
      return _active;
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
