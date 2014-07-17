package ComManager;


/**
 * Class ComMessage
 */
abstract public class ComMessage {

    //
    // Fields
    //

  private String method;
  private String data;
  private Callable<T> function;
  
    //
    // Constructors
    //
    public ComMessage () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of method
     * @param newVar the new value of method
     */
  private void setMethod (String newVar) {
      method = newVar;
  }

    /**
     * Get the value of method
     * @return the value of method
     */
  private String getMethod () {
      return method;
  }

    /**
     * Set the value of data
     * @param newVar the new value of data
     */
  private void setData (String newVar) {
      data = newVar;
  }

    /**
     * Get the value of data
     * @return the value of data
     */
  private String getData () {
      return data;
  }

    /**
     * Set the value of function
     * @param newVar the new value of function
     */
  private void setFunction (Callable<T> newVar) {
      function = newVar;
  }

    /**
     * Get the value of function
     * @return the value of function
     */
  private Callable<T> getFunction () {
      return function;
  }

    //
    // Other methods
    //

    /**
     * @param        data
     */
  public void setData(String data)
  {
    }


    /**
     * @param        method
     */
  public void setMethod(String method)
  {
    }


    /**
     * @param        function
     */
  public void setFunction(Callable<T> function)
  {
    }


    /**
     * @return       Callable<T>
     */
  public Callable<T> getFunction()
  {
    }


    /**
     * @return       String
     */
  public String getData()
  {
    }


    /**
     * @return       String
     */
  public String getMethod()
  {
    }


}
