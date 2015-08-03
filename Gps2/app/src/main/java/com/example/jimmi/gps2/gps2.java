package com.example.jimmi.gps2;

import android.app.Activity;
import android.content.Context;
import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


public class gps2 extends Activity {

    private TextView text;
    private TextView sellect = null;
    private EditText edit;
    private EditText edit1;
    private EditText edit2;
    private ScrollView scroll;
    private LinearLayout layout;
    private LinearLayout layout1;
    private Button add;
    private Button remove;
    private ArrayList<Destination> list = new ArrayList<Destination>();
    private Destination e = null;
    private final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    final LocationManager lokation = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
    float[] results = new float[1];
    double lat = 0;
    double lon = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gps2);
        text = (TextView)findViewById(R.id.textView);
        edit = (EditText)findViewById(R.id.editText);
        edit1 = (EditText)findViewById(R.id.editText2);
        edit2 = (EditText)findViewById(R.id.editText3);
        scroll = (ScrollView)findViewById(R.id.scrollView);
        add = (Button)findViewById(R.id.button);
        remove = (Button)findViewById(R.id.button2);
        layout = (LinearLayout)findViewById(R.id.layout);
        layout1 = (LinearLayout)findViewById(R.id.layout1);
        lokation.requestLocationUpdates(LocationManager.GPS_PROVIDER, 1000, 10.0f, new LocationListener() {
            @Override
            public void onLocationChanged(Location location)
            {
                Toast.makeText(gps2.this, "onLocationChange", Toast.LENGTH_SHORT).show();
                text.setText(location.getLatitude() + ", " + location.getLongitude());
                location.distanceBetween(lat, lon, location.getLatitude(), location.getLongitude(), results);
                text.setText("distance is " + results[0]);
                lat = location.getLatitude();
                lon = location.getLongitude();

            }

            @Override
            public void onStatusChanged(String provider, int status, Bundle extras) {
                Toast.makeText(gps2.this, "onStatusChange", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProviderEnabled(String provider) {
                Toast.makeText(gps2.this, "onblderEnabled", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onProviderDisabled(String provider) {
                Toast.makeText(gps2.this, "onProviderDisabled", Toast.LENGTH_SHORT).show();

            }
        });

                list_update();

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
             if(edit.getText().equals(null))
             {
                 Toast.makeText(gps2.this, "no input value", Toast.LENGTH_SHORT).show();
             }
                else if(sellect != null)
             {
                 list.remove(e);
             }
                Destination d = new Destination(Double.parseDouble(String.valueOf(edit.getText())),Double.parseDouble(String.valueOf(edit1.getText())),edit2.getText());
                list.add(d);
                list_update();
            }
        });

        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (edit.getText().equals(null)) {
                    Toast.makeText(gps2.this, "no input value", Toast.LENGTH_SHORT).show();
                }
                Destination d = new Destination(Double.parseDouble(String.valueOf(edit.getText())), Double.parseDouble(String.valueOf(edit1.getText())), edit2.getText());
                list.remove(d);
                list_update();
            }
        });


    }

    private void list_update()
    {
        layout1.removeAllViews();
        for (int i=0; i<list.size();i++)
        {
            layout1.addView(createNewTextView(list.get(i).getName()));
        }
    }

    private TextView createNewTextView(String text)
    {
        final TextView textView = new TextView(this);
        final String t = text;
        textView.setLayoutParams(lparams);
        textView.setText(t);
        //sets the size of the text
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 15);
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 0; i < list.size(); i++) {
                    if (list.get(i).getName().equals(t)) {
                        e = list.get(i);

                    }
                }
            }
        });
        return textView;
    }

}
