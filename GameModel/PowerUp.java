package GameModel;


/**
 * Class PowerUp
 */
public class PowerUp {

    //
    // Fields
    //

  private String name;
  private int duration = 60;
  private int coolDown = 120;
  private boolean isActive = false;
  private String icon;
  
    //
    // Constructors
    //
    public PowerUp () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of name
     * @param newVar the new value of name
     */
  private void setName (String newVar) {
      name = newVar;
  }

    /**
     * Get the value of name
     * @return the value of name
     */
  private String getName () {
      return name;
  }

    /**
     * Set the value of duration
     * @param newVar the new value of duration
     */
  private void setDuration (int newVar) {
      duration = newVar;
  }

    /**
     * Get the value of duration
     * @return the value of duration
     */
  private int getDuration () {
      return duration;
  }

    /**
     * Set the value of coolDown
     * @param newVar the new value of coolDown
     */
  private void setCoolDown (int newVar) {
      coolDown = newVar;
  }

    /**
     * Get the value of coolDown
     * @return the value of coolDown
     */
  private int getCoolDown () {
      return coolDown;
  }

    /**
     * Set the value of isActive
     * @param newVar the new value of isActive
     */
  private void setIsActive (boolean newVar) {
      isActive = newVar;
  }

    /**
     * Get the value of isActive
     * @return the value of isActive
     */
  private boolean getIsActive () {
      return isActive;
  }

    /**
     * Set the value of icon
     * @param newVar the new value of icon
     */
  private void setIcon (String newVar) {
      icon = newVar;
  }

    /**
     * Get the value of icon
     * @return the value of icon
     */
  private String getIcon () {
      return icon;
  }

    //
    // Other methods
    //

    /**
     * @return       String
     */
  public String getName()
  {
    }


    /**
     * @return       int
     */
  public int getDuration()
  {
    }


    /**
     * @return       int
     */
  public int getCoolDown()
  {
    }


    /**
     * @return       boolean
     */
  public boolean getActive()
  {
    }


    /**
     * @param        name
     */
  public void setName(String name)
  {
    }


    /**
     * @param        state
     */
  public void setActive(boolean state)
  {
    }


    /**
     * @param        icon
     */
  public void setIcon(String icon)
  {
    }


    /**
     * @return       String
     */
  public String getIcon()
  {
    }


}
