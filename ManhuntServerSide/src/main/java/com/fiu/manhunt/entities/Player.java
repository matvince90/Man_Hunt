package com.fiu.manhunt.entities;

import java.util.UUID;

import com.fiu.manhunt.data.DbWrapper;

/**
 * Class ServerPlayerInformation
 */
public class Player {

	private DbWrapper _dbCon;
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
		_dbCon.addPlayer(this);
	};
	
	/**
	 * if the player exist populate it with db data.
	 * @param _id
	 */
	public Player(int id) {
		if (_dbCon.getPlayer(id)) {
			_email = _dbCon.getPlayer(id).getEmail();
			_latitude = _dbCon.getPlayer(id).getLatitude();
			_longitude = _dbCon.getPlayer(id).getLongitude();
			_id = _dbCon.getPlayer(id).getId();
			_type = _dbCon.getPlayer(id).getType();
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
			_id = _dbCon.getHighestId() + 1;
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
