package com.fiu.manhunt.GameInteraction;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;

import com.fiu.manhunt.R;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;

public class GameActivity extends FragmentActivity implements LocationListener {
	Context context = this;
	GoogleMap googlemap; 
	LatLng playerPosition; 
	

	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		
		//Map Activity Instantiation
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_game);
		initMap();
		
		//Cloak button logic
		final Button cloakButton = (Button) findViewById(R.id.cloakButton); 
		cloakButton.setOnClickListener(new OnClickListener() {
			
			//When PowerUp is used, PowerUp button will be disabled for 2 minutes
			@Override
			public void onClick(View v) { 
				new PowerUp().execute(""); 
			}
		});
	}

	private void initMap() { 
		//Initial Map Setup
		googlemap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
		googlemap.setMapType(GoogleMap.MAP_TYPE_NORMAL); 
 
	    // Create a LatLng object for the current location
	    LatLng currentPlayerPosition = getCurrentPlayerPosition();      

	    // Show the current location in Google Map        
	    googlemap.moveCamera(CameraUpdateFactory.newLatLng(currentPlayerPosition));

	    // Zoom in the Google Map
	    googlemap.animateCamera(CameraUpdateFactory.zoomTo(20)); 
	}
	
	public LatLng getCurrentPlayerPosition()
	{
		googlemap.setMyLocationEnabled(true);
		
		// Get LocationManager object from System Service LOCATION_SERVICE
	    LocationManager locationManager = (LocationManager) getSystemService(LOCATION_SERVICE);

	    // Create a criteria object to retrieve provider
	    Criteria criteria = new Criteria();

	    // Get the name of the best provider
	    String provider = locationManager.getBestProvider(criteria, true);

	    // Get Current Location
	    Location myLocation = locationManager.getLastKnownLocation(provider);
  
	    // Get latitude of the current location
	    double latitude = myLocation.getLatitude();

	    // Get longitude of the current location
	    double longitude = myLocation.getLongitude();
		
		return new LatLng(latitude, longitude);
	}
	
	public void redrawMap()
	{
		 
	}

	public float getDistance(LatLng oldPosition, LatLng newPosition){
 
		float[] results = new float[1];
		Location.distanceBetween(oldPosition.latitude, oldPosition.longitude,newPosition.latitude, newPosition.longitude, results);
  
		return results[0];
	}
	
	public void onLocationChanged(Location location) {
	}

	public void onStatusChanged(String provider, int status, Bundle extras) {
	}

	public void onProviderEnabled(String provider) {
	}

	public void onProviderDisabled(String provider) {
		AlertDialog.Builder builder = new AlertDialog.Builder(this);
		builder.setTitle("Phone is in airplane mode");
		builder.setCancelable(false);
		builder.setPositiveButton("Enable GPS",
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						Intent startGps = new Intent(
								android.provider.Settings.ACTION_LOCATION_SOURCE_SETTINGS);
						startActivity(startGps);
					}
				});
		builder.setNegativeButton("Leave GPS off",
				new DialogInterface.OnClickListener() {

					public void onClick(DialogInterface dialog, int which) {
						dialog.cancel();
					}
				});

		AlertDialog alert = builder.create();
		alert.show();
	}

	private void addMarkerToMap(MarkerOptions options) {
		googlemap.addMarker(options);
	}

	@Override
	protected void onPause() { 
		super.onPause();
	}

	@Override
	protected void onResume() { 
		super.onResume();
	} 

	//Activates PowerUp and executes a Cool down on the use of PowerUps
    private class PowerUp extends AsyncTask<String, Void, String> {
 
        Button cloakButton = (Button) findViewById(R.id.cloakButton);
        
        protected void onPreExecute() {    
            cloakButton.setEnabled(false); 
        }
        
        @Override
        protected String doInBackground(String... params) {
        	 
                try 
                { 
                    Thread.sleep(120000); 
                }
                catch (InterruptedException e) 
                {
                    Thread.interrupted();
                } 
                
            return "Executed";
        }

        protected void onPostExecute(String result) {
            cloakButton.setEnabled(true);  
        } 
    } 
    
    
}


 

