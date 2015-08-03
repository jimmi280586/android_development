package com.example.jimmi.gps1;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;


public class gps1 extends Activity {

    TextView text, text1;
    double lat = 0;
    double lon = 0;
    float[] results = new float[1];
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps1);
        final LocationManager lokation = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        text = (TextView) findViewById(R.id.text);
        text1 = (TextView) findViewById(R.id.text1);
        lokation.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10.0f, new LocationListener() {
            @Override
            public void onLocationChanged(Location location) {

                Toast.makeText(gps1.this, "onLocationChange", Toast.LENGTH_SHORT).show();
                text.setText(location.getLatitude() + ", " + location.getLongitude());
                location.distanceBetween(lat, lon, location.getLatitude(), location.getLongitude(), results);
                text1.setText("distance is " + results[0]);
                lat = location.getLatitude();
                lon = location.getLongitude();

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Toast.makeText(gps1.this, "onStatusChange", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProviderEnabled(String provider) {
                Toast.makeText(gps1.this, "onblderEnabled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProviderDisabled(String provider) {
                Toast.makeText(gps1.this, "onProviderDisabled", Toast.LENGTH_SHORT).show();

            }
        });
    }


}
