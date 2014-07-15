package GameModel;


/**
 * Class GameMap
 */
public class GameMap {

    //
    // Fields
    //

  private uiGameMap uiGameMap;
  private float[] gameBoundaries;
  
    //
    // Constructors
    //
    public GameMap () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of uiGameMap
     * @param newVar the new value of uiGameMap
     */
  private void setUiGameMap (uiGameMap newVar) {
      uiGameMap = newVar;
  }

    /**
     * Get the value of uiGameMap
     * @return the value of uiGameMap
     */
  private uiGameMap getUiGameMap () {
      return uiGameMap;
  }

    /**
     * Set the value of gameBoundaries
     * @param newVar the new value of gameBoundaries
     */
  private void setGameBoundaries (float[] newVar) {
      gameBoundaries = newVar;
  }

    /**
     * Get the value of gameBoundaries
     * @return the value of gameBoundaries
     */
  private float[] getGameBoundaries () {
      return gameBoundaries;
  }

    //
    // Other methods
    //

    /**
     * @return       uiGameMap
     */
  public uiGameMap refreshGameMap()
  {
    }


    /**
     * @return       Location
     */
  public Location getPlayerLocation()
  {
    }


    /**
     * @return       boolean
     */
  public boolean detectClosestPredator()
  {
    }


    /**
     * @param        markers
     */
  public void plotMarkers(List<Marker> markers)
  {
    }


    /**
     * @return       List<Marker>
     * @param        markers
     */
  private List<Marker> outOfBounds(List<Marker> markers)
  {
    }


    /**
     * @param        location
     */
  private void markerFactory(Location[] location)
  {
    }


}
