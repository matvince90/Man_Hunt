package com.fiu.manhunt;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.location.Criteria;
import android.location.Location;
import android.location.LocationManager;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.fiu.manhunt.util.UserEmailFetcher;
import com.google.android.gms.maps.CameraUpdateFactory;
import com.google.android.gms.maps.GoogleMap;
import com.google.android.gms.maps.SupportMapFragment;
import com.google.android.gms.maps.model.BitmapDescriptorFactory;
import com.google.android.gms.maps.model.LatLng;
import com.google.android.gms.maps.model.MarkerOptions;
import android.os.Handler;
import com.google.gson.Gson;

import org.apache.http.HttpResponse;
import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.entity.UrlEncodedFormEntity;
import org.apache.http.client.methods.HttpPost;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.message.BasicNameValuePair;
import org.apache.http.util.EntityUtils;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import commanager.PlayerMessageData;

public class GameActivity extends FragmentActivity {
    private Handler mHandler = new Handler();
    PlayerMessageData _gameState = null;
    Context _context = this;
    LatLng _latLng;
    private GoogleMap _mMap; // Might be null if Google Play services APK is not available.
    private String _email;
    private PlayerMessageData.PlayerData _lPlayer = null;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        setUpMapIfNeeded();

        //Cloak button logic
        final Button cloakButton = (Button) findViewById(R.id.cloakButton);
        cloakButton.setOnClickListener(new OnClickListener() {

            //When PowerUp is used, PowerUp button will be disabled for 2 minutes
            @Override
            public void onClick(View v) {
                cloakButton.setBackgroundResource(R.drawable.cloak_used);
                new PowerUpAsyncTask().execute("");
            }
        });

        _email = UserEmailFetcher.getEmail(_context);

        mHandler.post(new Runnable() {
            public void run() {
                callForUpdate();
                mHandler.postDelayed(this, 60 * 1000);
            }
        });
    }

    @Override
    protected void onResume() {
        super.onResume();
        setUpMapIfNeeded();
    }

    private float getDistance(LatLng oldPosition, LatLng newPosition) {

        float[] results = new float[1];
        Location.distanceBetween(oldPosition.latitude, oldPosition.longitude, newPosition.latitude, newPosition.longitude, results);

        return results[0];
    }

    /**
     * Sets up the map if it is possible to do so (i.e., the Google Play services APK is correctly
     * installed) and the map has not already been instantiated.. This will ensure that we only ever
     * call {@link #setUpMap()} once when {@link #mMap} is not null.
     * <p/>
     * If it isn't installed {@link SupportMapFragment} (and
     * {@link com.google.android.gms.maps.MapView MapView}) will show a prompt for the user to
     * install/update the Google Play services APK on their device.
     * <p/>
     * A user can return to this FragmentActivity after following the prompt and correctly
     * installing/updating/enabling the Google Play services. Since the FragmentActivity may not
     * have been completely destroyed during this process (it is likely that it would only be
     * stopped or paused), {@link #onCreate(Bundle)} may not be called again so we should call this
     * method in {@link #onResume()} to guarantee that it will be called.
     */
    private void setUpMapIfNeeded() {
        // Do a null check to confirm that we have not already instantiated the map.
        if (_mMap == null) {
            // Try to obtain the map from the SupportMapFragment.
            _mMap = ((SupportMapFragment) getSupportFragmentManager().findFragmentById(R.id.map)).getMap();
            // Check if we were successful in obtaining the map.
            if (_mMap != null) {
                setUpMap();
            }
        }
    }

    /**
     * This is where we can add markers or lines, add listeners or move the camera. In this case, we
     * just add a marker near Africa.
     * <p/>
     * This should only be called once and when we are sure that {@link #mMap} is not null.
     */
    private void setUpMap() {
        _mMap.setMapType(GoogleMap.MAP_TYPE_NORMAL);

        getCurrentPlayerPosition();

        // Show the current location in Google Map
        _mMap.moveCamera(CameraUpdateFactory.newLatLng(_latLng));

        // Zoom in the Google Map
        _mMap.animateCamera(CameraUpdateFactory.zoomTo(20));
    }

    /**
     * Get this players location
     *
     * @return
     */
    private void getCurrentPlayerPosition() {
        _mMap.setMyLocationEnabled(true);

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

        _latLng = new LatLng(latitude, longitude);
    }

    protected void plotMarkers() {
        if (_gameState == null)
            return;
        for (PlayerMessageData.PlayerData p : _gameState.playerData) {
            LatLng ll = new LatLng(p.get_lat(), p.get_long());
            if (p.get_type() > 0) {
                _mMap.addMarker(new MarkerOptions()
                        .position(ll)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_GREEN)));
                if(getDistance(ll, _latLng) < 5 && _lPlayer.get_type() < 1)
                    _lPlayer.set_type(1);
            } else {
                _mMap.addMarker(new MarkerOptions()
                        .position(ll)
                        .icon(BitmapDescriptorFactory.defaultMarker(BitmapDescriptorFactory.HUE_RED)));
            }
        }
    }

    // Events

    /**
     * If the provider is not avaliable show an alert
     *
     * @param provider
     */
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
                }
        );
        builder.setNegativeButton("Leave GPS off",
                new DialogInterface.OnClickListener() {

                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                }
        );

        AlertDialog alert = builder.create();
        alert.show();
    }

    private void callForUpdate() {
        new GetUpdateAsyncTask().execute("");
    }

    //Activates PowerUp and executes a Cool down on the use of PowerUps
    private class PowerUpAsyncTask extends android.os.AsyncTask<String, Void, String> {

        Button cloakButton = (Button) findViewById(R.id.cloakButton);

        protected void onPreExecute() {
            cloakButton.setEnabled(false);
        }

        @Override
        protected String doInBackground(String... params) {
            try {
                Thread.sleep(120000);
            } catch (InterruptedException e) {
                Thread.interrupted();
            }

            return "Executed";
        }

        protected void onPostExecute(String result) {
            cloakButton.setEnabled(true);
            cloakButton.setBackgroundResource(R.drawable.cloak);
        }
    }

    private class GetUpdateAsyncTask extends AsyncTask<String, Void, String> {

        PlayerMessageData.PlayerData _player;
        PlayerMessageData _pmd = null;
        String _result;

        protected void onPreExecute() {
            getCurrentPlayerPosition();
            double t = _latLng.longitude;
            double l = _latLng.latitude;
            PlayerMessageData pmd = new PlayerMessageData();
            if(_lPlayer == null) {
                _lPlayer = pmd.new PlayerData();
                _lPlayer.set_type((Math.random()<0.5)?0:1);
                _lPlayer.set_email(_email);
            }
            if (_latLng.longitude < 0)
                t = t * -1;
            if (_latLng.latitude < 0)
                l = l * -1;
            _lPlayer.set_lat((float) l);
            _lPlayer.set_long((float) t);

            _player = _lPlayer;
        }

        @Override
        protected String doInBackground(String... params) {
            postData();
            return null;
        }

        protected void onPostExecute(String result) {
            if (_pmd != null)
                _gameState = _pmd;
            plotMarkers();
        }

        private void postData() {
            // Create a new HttpClient and Post Header

            HttpClient httpclient = new DefaultHttpClient();
            HttpPost httppost = new HttpPost("http://manhunt.justin3o9.com/ManhuntServerSide/rest/manhunt");
            httppost.setHeader("Content-Type", "application/x-www-form-urlencoded;charset=UTF-8");

            try {
                // parse input into json and add to value key pair
                Gson gson = new Gson();

                List<NameValuePair> nameValuePairs = new ArrayList<NameValuePair>(2);
                nameValuePairs.add(new BasicNameValuePair("player", gson.toJson(_player)));

                // encode the input for http transport
                httppost.setEntity(new UrlEncodedFormEntity(nameValuePairs));

                // Execute HTTP Post Request
                HttpResponse response = httpclient.execute(httppost);

                // store string result
                _result = EntityUtils.toString(response.getEntity());

                _pmd = gson.fromJson(_result, PlayerMessageData.class);

            } catch (ClientProtocolException e) {
            } catch (IOException e) {
            } catch (Exception e) {
            }
        }
    }
}
