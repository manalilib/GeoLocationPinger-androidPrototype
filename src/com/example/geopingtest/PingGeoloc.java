package com.example.geopingtest;

import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class PingGeoloc extends MainActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// TODO Auto-generated method stub

		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		/* Use the LocationManager class to obtain GPS locations */

		LocationManager mlocManager = (LocationManager)getSystemService(Context.LOCATION_SERVICE);

		LocationListener mlocListener = new MyLocationListener();


		mlocManager.requestLocationUpdates( LocationManager.GPS_PROVIDER, 0, 0, mlocListener);
	}
	
	//My Location Listener Class
	public class MyLocationListener implements LocationListener{

		@Override
		public void onLocationChanged(Location arg0) {
			// TODO Auto-generated method stub
			String MSG = "My Current Location is>>>>>>>>>>" + "Latitude: " + arg0.getLatitude() + "Longitude: " + arg0.getLongitude();
			Toast.makeText(getApplicationContext(),MSG,Toast.LENGTH_SHORT).show();
				
			Log.v(">>>>>>>>>>>>>>>>>>>>>>>>>>>>>>>", MSG);
		}

		@Override
		public void onProviderDisabled(String arg0) {
			// TODO Auto-generated method stub
			Toast.makeText(getApplicationContext(),"GPS Unavailable!",Toast.LENGTH_SHORT ).show();
			
		}

		@Override
		public void onProviderEnabled(String arg0) {
			// TODO Auto-generated method stub
			
			Toast.makeText(getApplicationContext(),"GPS Enabled!",Toast.LENGTH_SHORT ).show();
		}

		@Override
		public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
			// TODO Auto-generated method stub
			
		}
	}
}
