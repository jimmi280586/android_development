package com.example.jimmi.life_cycle;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.RadioButton;
import android.widget.Toast;

public class MainActivity extends Activity {

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toast.makeText(getApplicationContext(),"2. onCreate()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onResume() {
        super.onResume();
        Toast.makeText(getApplicationContext(),"3. onResume()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPause() {
        super.onPause();
        Toast.makeText(getApplicationContext(),"4. onPause()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onStop() {
        super.onStop();
        Toast.makeText(getApplicationContext(),"5. onStop()", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Toast.makeText(getApplicationContext(),"6. onDestroy()", Toast.LENGTH_SHORT).show();
    }

    /*the methods are called in order
     on create
     on resume
     then it waits but if you make the device go to a different app it uses thees two
     on pause
     on stop
     until you start it up again then it uses this
     on resume
     if you flip the screen it uses thees
     on pause
     on stop
     on destroy
     on create
     on resume
     then you are ready again


      */

}
