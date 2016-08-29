package com.ada.simpledrawing;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.graphics.Canvas;


public class MainActivity extends Activity {
    boolean flag=false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        LinearLayout ll=(LinearLayout)findViewById(R.id.ll);


        Button blue=(Button)findViewById(R.id.Button1);
        Button green=(Button)findViewById(R.id.Button2);
        Button yellow = (Button) findViewById(R.id.Button3);

        blue.setVisibility(View.VISIBLE);
        green.setVisibility(View.VISIBLE);
        yellow.setVisibility(View.VISIBLE);

        blue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //flag=true;
                Drawing thisView = (Drawing) v;
                thisView.setColor("b");

            }
        });
        green.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //flag=true;
                Drawing thisView = (Drawing) v;
                thisView.setColor("g");

            }
        });
        yellow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //flag=true;
                Drawing thisView = (Drawing) v;
                thisView.setColor("y");

            }
        });

        Drawing dw = (Drawing)findViewById(R.id.drawView1);
        LinearLayout ll_2=(LinearLayout)findViewById(R.id.ll_2);
        ll.addView(ll_2);
        ll.addView(dw);
        dw.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {

                //if(!flag){
                Drawing thisView = (Drawing) v;
                thisView.setPoint((int)event.getX(), (int)event.getY());
                thisView.invalidate();
                //}
                //else{flag=true;}
                return false;
            }
        });
    }



}
