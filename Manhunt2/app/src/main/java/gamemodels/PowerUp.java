package gamemodels;
 
public class PowerUp {

	public enum PowerUps {
		Cloak
	}

	//
	// Fields
	//
	private PowerUps type;
	private long startTime;
	private long duration;
	private long coolDownDuration;
	private boolean isActive;
	private String iconPath;

	//
	// Constructors
	//

	public PowerUp() {
		this(PowerUps.Cloak);
	};

	public PowerUp(PowerUps type) {
		this.type = type;

		// duration in Milliseconds
		this.duration = 60 * 1000;
		this.coolDownDuration = 120 * 1000;
		this.startTime = System.currentTimeMillis();

		this.isActive = false;
		this.iconPath = "path to default icon";
	}

	//
	// Methods
	//

	/**
	 * Set the value of type
	 * 
	 * @param newVar
	 *            the new value of type
	 */
	public void setType(PowerUps newVar) {
		type = newVar;
	}

	/**
	 * Get the value of type
	 * 
	 * @return the value of type
	 */
	public PowerUps getType() {
		return type;
	}

	/**
	 * Set the value of duration
	 * 
	 * @param newVar
	 *            the new value of duration
	 */
	public void setDuration(int newVar) {
		duration = newVar;
	}

	/**
	 * Get the value of duration
	 * 
	 * @return the value of duration
	 */
	public long getDuration() {
		return duration;
	}

	/**
	 * Set the value of coolDown
	 * 
	 * @param newVar
	 *            the new value of coolDown
	 */
	public void setCoolDown(int newVar) {
		coolDownDuration = newVar;
	}

	/**
	 * Get the value of coolDown
	 * 
	 * @return the value of coolDown
	 */
	public long getCoolDown() {
		return coolDownDuration;
	}

	/**
	 * Set the value of isActive
	 * 
	 * @param newVar
	 *            the new value of isActive
	 */
	public void setIsActive(boolean newVar) {
		isActive = newVar;
	}

	/**
	 * Get the value of isActive
	 * 
	 * @return the value of isActive
	 */
	public boolean IsActive() {
		return isActive;
	}

	/**
	 * Set the value of icon
	 * 
	 * @param newVar
	 *            the new value of icon
	 */
	public void setIcon(String newVar) {
		iconPath = newVar;
	}

	/**
	 * Get the value of icon
	 * 
	 * @return the value of icon
	 */
	public String getIcon() {
		return iconPath;
	}

	public long getStartTime() {
		return startTime;
	}

	public void setStartTime(long startTime) {
		this.startTime = startTime;
	}
}
