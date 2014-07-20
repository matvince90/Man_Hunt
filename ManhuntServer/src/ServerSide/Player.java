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
	 * 
	 */
	public Player() {
	};


	/**
	 * @return String
	 */
	public String getEmail() {
		return _email;
	}

	/**
	 * @return int
	 */
	public UUID getId() {
		return _id;
	}

	/**
	 * @return float
	 */
	public float getlatititude() {
		return _latitude;
	}

	/**
	 * @return float
	 */
	public float getLongitude() {
		return _longitude;
	}

	/**
	 * @return int
	 */
	public int getType() {
		return _type;
	}

	/**
	 * @param email
	 */
	public void setEmail(String email) {
	}

	/**
	 * @param id
	 */
	public void setId(UUID id) {
		_id = id;
	}

	/**
	 * @param latitude
	 */
	public void setLatitude(float latitude) {
	}

	/**
	 * @param longitude
	 */
	public void setLongitude(float longitude) {
	}

	/**
	 * @param status
	 */
	public void setType(int type) {
		_type = type;
	}

}
