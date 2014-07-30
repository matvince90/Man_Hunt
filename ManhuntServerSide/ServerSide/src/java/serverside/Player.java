package ServerSide;

import java.util.UUID;

/**
 * Class ServerPlayerInformation
 */
class Player {

	private JDBC _jdbc;
	private String _email;
	private float _latitude;
	private float _longitude;
	private UUID _id;
	private int _type;
	
	/**
	 * new player
	 */
	public Player() {
		setId();
		_jdbc.addPlayer(this);
	};
	
	/**
	 * if the player exist populate it with db data.
	 * @param _id
	 */
	public Player(UUID id) {
		if (_jdbc.getPlayer(id)) {
			_email = _jdbc.getPlayer(id).getEmail();
			_latitude = _jdbc.getPlayer(id).getLatitude();
			_longitude = _jdbc.getPlayer(id).getLongitude();
			_id = _jdbc.getPlayer(id).getId();
			_type = _jdbc.getPlayer(id).getType();
		}
	}
	
	/**
	 * Get the value of email
	 * @return String
	 */
	public String getEmail() {
		return _email;
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
	public void setId() {
		if (_id == null) {
			_id = _jdbc.getHighestId() + 1;
		}
	}

	/**
	 * Get the value of latitude
	 * @return float
	 */
	public float getLatitude() {
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

}
