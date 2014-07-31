package com.fiu.manhunt.entities;

import java.util.List;

import com.fiu.manhunt.data.DbWrapper;

/**
 * Class ServerPlayerInformation
 */
public class Player {

	private DbWrapper _dbCon;
	private String _email;
	private float _latitude;
	private float _longitude;
	private int _id = -1;
	private int _type;
	private int _match;
	
	/**
	 * new player
	 */
	public Player(DbWrapper db) {
		_dbCon = db;
		setId();
		_dbCon.addPlayer(this);
	};
	
	/**
	 * if the player exist populate it with db data.
	 * @param _id
	 */
	public Player(String email, DbWrapper db) {
		_dbCon = db;
		List<String> player = _dbCon.getPlayer(email);
		if (player != null) {
			_email = player.get(1);
			_latitude = Float.parseFloat(player.get(2));
			_longitude = Float.parseFloat(player.get(3));
			_id = Integer.parseInt(player.get(0));
			_type = Integer.parseInt(player.get(4));
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
	 * @return int
	 */
	public int getId() {
		return _id;
	}

	/**
	 * Set the value of id
	 * @param id
	 */
	public void setId() {
		if (_id < 0) {
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

	public int get_match() {
		return _match;
	}

	public void set_match(int _match) {
		this._match = _match;
	}

	public void set_email(String email) {
		_email = email;

	}

}
