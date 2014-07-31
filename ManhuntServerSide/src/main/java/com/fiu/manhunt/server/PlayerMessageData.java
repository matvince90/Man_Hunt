package com.fiu.manhunt.server;

/**
 * @author Team 3
 */
public class PlayerMessageData {
	
	// list of data
	public PlayerData[] playerData;
	/**
	 * @author Team 3
	 */
	public class PlayerData {
		private int _playerId;
		private String _email;
		private int _type;
		private long _lat;
		private long _long;
		private int _match;
		
		/**
		 * @return
		 */
		public int get_playerId() {
			return _playerId;
		}
		
		/**
		 * @param _playerId
		 */
		public void set_playerId(int _playerId) {
			this._playerId = _playerId;
		}
		
		/**
		 * @return
		 */
		public String get_email() {
			return _email;
		}
		
		/**
		 * @param _email
		 */
		public void set_email(String _email) {
			this._email = _email;
		}
		
		/**
		 * @return
		 */
		public int get_type() {
			return _type;
		}
		
		/**
		 * @param _type
		 */
		public void set_type(int _type) {
			this._type = _type;
		}
		
		/**
		 * @return
		 */
		public long get_lat() {
			return _lat;
		}
		
		/**
		 * @param _lat
		 */
		public void set_lat(long _lat) {
			this._lat = _lat;
		}
		
		/**
		 * @return
		 */
		public long get_long() {
			return _long;
		}
		
		/**
		 * @param _long
		 */
		public void set_long(long _long) {
			this._long = _long;
		}
		
		/**
		 * @return
		 */
		public int get_match() {
			return _match;
		}
		
		/**
		 * @param _match
		 */
		public void set_match(int _match) {
			this._match = _match;
		}
	
	}
}
