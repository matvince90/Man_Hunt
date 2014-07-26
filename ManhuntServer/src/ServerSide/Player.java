package ServerSide;

import java.util.UUID;

/**
 * Class ServerPlayerInformation
 */
class Player {

	// 
	private String _email;
	private float _latitude;
	private float _longitude;
	private UUID _id;
	private int _type;
	
	/**
	 * new player
	 */
	public Player() {
	};
	
	/**
	 * if the player exist populate it iwth db data.
	 * @param _id
	 */
	public Player(UUID _id) {
	};

	//
	// Accessors and Mutators
	//
	
	/**
	 * Get the value of email
	 * @return String
	 */
	public String getEmail() {
		return _email;
	}
	
	/**
	 * Set the value of email
	 * @param email
	 */
	public void setEmail(String email) {
		_email = email;
	}
	
	/**
	 * Get the value of id
	 * @return UUID
	 */
	public UUID getId() {
		return _id;
	}

	/**
	 * Set the value of id
	 * @param id
	 */
	public void setId(UUID id) {
		_id = id;
	}

	/**
	 * Get the value of latitude
	 * @return float
	 */
	public float getlatititude() {
		return _latitude;
	}

	/**
	 * Set the value of latitude
	 * @param latitude
	 */
	public void setLatitude(float latitude) {
		_latitude = latitude;
	}

	/**
	 * Get the value of longitude
	 * @return float
	 */
	public float getLongitude() {
		return _longitude;
	}

	/**
	 * Set the value of longitude
	 * @param longitude
	 */
	public void setLongitude(float longitude) {
		_longitude = longitude;
	}
	
	/**
	 * get the value of type (Predator/Prey)
	 * @return integer
	 */
	public int getType() {
		return _type;
	}
	
	/**
	 * set the value of type(Predator/Prey)
	 * @param status
	 */
	public void setType(int type) {
		_type = type;
	}
	
	public void syncPlayer() {
		
	}

}
