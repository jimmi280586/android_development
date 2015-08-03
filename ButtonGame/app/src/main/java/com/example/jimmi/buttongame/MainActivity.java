package com.example.jimmi.buttongame;

import android.app.Activity;
import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.AbsoluteLayout;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.RelativeLayout;
import android.widget.TableLayout;
import android.widget.TextView;

import java.util.Random;



public class MainActivity extends Activity {
    Random x = new Random();
    Random y = new Random();
    float randomNum;
    int push = 0;
    int point = 0;
    String mem = "";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TableLayout lp = (TableLayout) findViewById(R.id.layout);
        final Button start = (Button) findViewById(R.id.button);
        final Button a = (Button) findViewById(R.id.button2);
        final Button b = (Button) findViewById(R.id.button3);
        final Button c = (Button) findViewById(R.id.button4);
        final Button d = (Button) findViewById(R.id.button5);
        final TextView score = (TextView)findViewById(R.id.textView);
        final Chronometer whatch = (Chronometer) findViewById(R.id.chronometer);
        RelativeLayout.LayoutParams params = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.MATCH_PARENT, RelativeLayout.LayoutParams.MATCH_PARENT);

        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if(start.getText().equals("start"))
                {
                    start.setText("stop");
                    whatch.start();
                }
                else
                {
                    start.setText("start");
                    whatch.stop();
                    score.setText("" + point);
                    whatch.setBase(SystemClock.elapsedRealtime());
                }
            }
        });

        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (push <= 1) {
                    push++;
                    mem = "a";
                } else {
                    push = 0;
                    if(mem.equals("b"))
                    {
                        a.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        b.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    }
                    else if(mem.equals("c"))
                    {
                        a.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        c.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    }
                    else
                    {
                        a.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        d.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    }
                    mem = "";
                }
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (push <= 1) {
                    push++;
                    mem = "b";
                } else {
                    push = 0;
                    if(mem.equals("a"))
                    {
                        a.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        b.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    }
                    else if(mem.equals("c")) {
                        b.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        c.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    }
                    else {
                        b.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        d.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    }
                    mem = "";
                }
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (push <= 1) {
                    push++;
                    mem = "c";
                } else {
                    push = 0;
                    if (mem.equals("a")) {
                        a.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        c.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    } else if (mem.equals("b")) {
                        b.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        c.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    } else {
                        c.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        d.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    }
                    mem = "";
                }
            }
        });
        a.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (push <= 1) {
                    push++;
                    mem = "d";
                } else {
                    push = 0;
                    if (mem.equals("a")) {
                        a.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        d.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    } else if (mem.equals("b")) {
                        b.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        d.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    } else {
                        c.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        d.setPivotX(randomNum = 0 + (int) (Math.random() * (lp.getHeight() - 20)));
                        whatch.stop();
                        whatch.setBase(SystemClock.elapsedRealtime());
                    }
                    mem = "";
                }
            }
        });


    }


}
