package ServerSide;


/**
 * Class Webservice
 */
public class Webservice {

    //
    // Fields
    //

  private List<Thread> threads;
  private int listenerPort;
  private List<String> methodList;
  private ServerSide.GameLogicController gameLogicController;
  
    //
    // Constructors
    //
    public Webservice () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of threads
     * @param newVar the new value of threads
     */
  private void setThreads (List<Thread> newVar) {
      threads = newVar;
  }

    /**
     * Get the value of threads
     * @return the value of threads
     */
  private List<Thread> getThreads () {
      return threads;
  }

    /**
     * Set the value of listenerPort
     * @param newVar the new value of listenerPort
     */
  private void setListenerPort (int newVar) {
      listenerPort = newVar;
  }

    /**
     * Get the value of listenerPort
     * @return the value of listenerPort
     */
  private int getListenerPort () {
      return listenerPort;
  }

    /**
     * Set the value of methodList
     * @param newVar the new value of methodList
     */
  private void setMethodList (List<String> newVar) {
      methodList = newVar;
  }

    /**
     * Get the value of methodList
     * @return the value of methodList
     */
  private List<String> getMethodList () {
      return methodList;
  }

    /**
     * Set the value of gameLogicController
     * @param newVar the new value of gameLogicController
     */
  private void setGameLogicController (ServerSide.GameLogicController newVar) {
      gameLogicController = newVar;
  }

    /**
     * Get the value of gameLogicController
     * @return the value of gameLogicController
     */
  private ServerSide.GameLogicController getGameLogicController () {
      return gameLogicController;
  }

    //
    // Other methods
    //

    /**
     * @param        method @RequestParam(value="method", required=false,
     * defaultValue="") String method
     * @param        data @RequestParam(value="data", required=false, defaultValue="")
     * String data
     */
  public void handleRequest(String method, String data)
  {
    }


}
