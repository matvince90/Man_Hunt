package com.fiu.manhunt.ComManager;


/**
 * Class MessageDispatcher
 */
public class MessageDispatcher {

    //
    // Fields
    //

  protected Queue<ComManager.ComMessage> MessageQueue;
  private String serverAddress;
  private int serverPort;
  private int threadLimit;
  private List<ComManager.ComRequestThread> comRequestThreads;
  
    //
    // Constructors
    //
    public MessageDispatcher () { };
  
    //
    // Methods
    //


    //
    // Accessor methods
    //

    /**
     * Set the value of MessageQueue
     * @param newVar the new value of MessageQueue
     */
  protected void setMessageQueue (Queue<ComManager.ComMessage> newVar) {
      MessageQueue = newVar;
  }

    /**
     * Get the value of MessageQueue
     * @return the value of MessageQueue
     */
  protected Queue<ComManager.ComMessage> getMessageQueue () {
      return MessageQueue;
  }

    /**
     * Set the value of serverAddress
     * @param newVar the new value of serverAddress
     */
  private void setServerAddress (String newVar) {
      serverAddress = newVar;
  }

    /**
     * Get the value of serverAddress
     * @return the value of serverAddress
     */
  private String getServerAddress () {
      return serverAddress;
  }

    /**
     * Set the value of serverPort
     * @param newVar the new value of serverPort
     */
  private void setServerPort (int newVar) {
      serverPort = newVar;
  }

    /**
     * Get the value of serverPort
     * @return the value of serverPort
     */
  private int getServerPort () {
      return serverPort;
  }

    /**
     * Set the value of threadLimit
     * @param newVar the new value of threadLimit
     */
  private void setThreadLimit (int newVar) {
      threadLimit = newVar;
  }

    /**
     * Get the value of threadLimit
     * @return the value of threadLimit
     */
  private int getThreadLimit () {
      return threadLimit;
  }

    /**
     * Set the value of comRequestThreads
     * @param newVar the new value of comRequestThreads
     */
  private void setComRequestThreads (List<ComManager.ComRequestThread> newVar) {
      comRequestThreads = newVar;
  }

    /**
     * Get the value of comRequestThreads
     * @return the value of comRequestThreads
     */
  private List<ComManager.ComRequestThread> getComRequestThreads () {
      return comRequestThreads;
  }

    //
    // Other methods
    //

    /**
     * @return       boolean
     * @param        message
     */
  public boolean sendMessage(ComManager.ComMessage message)
  {
    }


    /**
     * @return       AsyncTask
     * @param        message
     */
  public AsyncTask startThread(ComManager.ComMessage message)
  {
    }


}
