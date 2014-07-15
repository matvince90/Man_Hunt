package ServerSide;


/**
 * Class ServerPlayerInformation
 */
class ServerPlayerInformation {

    //
    // Fields
    //

  private String email;
  private float latitude;
  private float longitude;
  private int id;
  private int status;
  
    //
    // Constructors
    //
    public ServerPlayerInformation () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of email
     * @param newVar the new value of email
     */
  private void setEmail (String newVar) {
      email = newVar;
  }

    /**
     * Get the value of email
     * @return the value of email
     */
  private String getEmail () {
      return email;
  }

    /**
     * Set the value of latitude
     * @param newVar the new value of latitude
     */
  private void setLatitude (float newVar) {
      latitude = newVar;
  }

    /**
     * Get the value of latitude
     * @return the value of latitude
     */
  private float getLatitude () {
      return latitude;
  }

    /**
     * Set the value of longitude
     * @param newVar the new value of longitude
     */
  private void setLongitude (float newVar) {
      longitude = newVar;
  }

    /**
     * Get the value of longitude
     * @return the value of longitude
     */
  private float getLongitude () {
      return longitude;
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
     * Set the value of status
     * @param newVar the new value of status
     */
  private void setStatus (int newVar) {
      status = newVar;
  }

    /**
     * Get the value of status
     * @return the value of status
     */
  private int getStatus () {
      return status;
  }

    //
    // Other methods
    //

    /**
     * @return       String
     */
  public String getEmail()
  {
    }


    /**
     * @return       int
     */
  public int getId()
  {
    }


    /**
     * @return       float
     */
  public float getlatititude()
  {
    }


    /**
     * @return       float
     */
  public float getLongitude()
  {
    }


    /**
     * @return       int
     */
  public int getStatus()
  {
    }


    /**
     * @param        email
     */
  public void setEmail(String email)
  {
    }


    /**
     * @param        id
     */
  public void setId(int id)
  {
    }


    /**
     * @param        latitude
     */
  public void setLatitude(float latitude)
  {
    }


    /**
     * @param        longitude
     */
  public void setLongitude(float longitude)
  {
    }


    /**
     * @param        status
     */
  public void setStatus(int status)
  {
    }


}
