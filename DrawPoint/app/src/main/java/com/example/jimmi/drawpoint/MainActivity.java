package com.example.jimmi.drawpoint;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;


public class MainActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Bound dw = (Bound)findViewById(R.id.drawView1);
        dw.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                Bound thisView = (Bound) v;
                //thisView.setPoint((int)event.getX(), (int)event.getY());
                //thisView.invalidate();
                return false;
            }
        });
    }
}
