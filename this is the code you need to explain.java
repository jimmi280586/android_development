package com.example.jimmi.testingmp3;

import android.media.MediaPlayer;
import android.net.Uri;

import android.os.Bundle;
import android.text.Html;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.Scroller;
import android.widget.TextView;
import android.widget.SeekBar;
import android.widget.LinearLayout;
import android.app.Activity;
import android.widget.Toast;
import android.os.Handler;
import android.util.TypedValue;


public class MainActivity extends Activity {

    public MediaPlayer mp;
    SeekBar sb;
    TextView now;
    String x="<b>now playing</b>:";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/Fever_Ray-If_I_Had_a_Heart.mp3"));
         mp=MediaPlayer.create(getApplicationContext(), Uri.parse("http://mobi.randomsort.net/wp-content/uploads/2015/07/filetoplay.mp3"));


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        LinearLayout ll;
        ll = (LinearLayout) findViewById(R.id.linearlayout);
        //LinearLayout ll2;
        //ll2=(LinearLayout) findViewById(R.id.linearlayout2);
        LinearLayout ll3;
        ll3=(LinearLayout)findViewById(R.id.linearlayout3);
        now=(TextView)findViewById(R.id.now);
        now.setText(Html.fromHtml(x));
        sb = (SeekBar) findViewById(R.id.seekBar);
        sb.setMax(mp.getDuration());

        Button start = new Button(MainActivity.this);
        Button pause = new Button(MainActivity.this);
        Button stop = new Button(MainActivity.this);


        start.setText("  start  ");
        pause.setText("  pause  ");
        stop.setText("  stop  ");


        ll.addView(start);
        ll.addView(pause);
        ll.addView(stop);

        //textviews to be added on the layout
        TextView t1=new TextView(MainActivity.this);
        TextView t2=new TextView(MainActivity.this);
        TextView t3=new TextView(MainActivity.this);
        TextView t4=new TextView(MainActivity.this);
        TextView t5=new TextView(MainActivity.this);
        TextView t6=new TextView(MainActivity.this);
        TextView t7=new TextView(MainActivity.this);
        TextView t8=new TextView(MainActivity.this);
        TextView t9=new TextView(MainActivity.this);
        TextView t10=new TextView(MainActivity.this);
        TextView t11=new TextView(MainActivity.this);
        TextView t12=new TextView(MainActivity.this);
        TextView t13=new TextView(MainActivity.this);

        String s1="<b>Fever Ray-If I had a heart</b>";
        t1.setText(Html.fromHtml(s1));
        t1.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t1.setMaxLines(1);

        String s2="<b>Icona Pop-I love it</b>";
        t2.setText(Html.fromHtml(s2));
        t2.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t2.setMaxLines(1);

        String s3="<b>Mo-Fire Rides</b>";
        t3.setText(Html.fromHtml(s3));
        t3.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t3.setMaxLines(1);

        String s4="<b>Mo-Maiden</b>";
        t4.setText(Html.fromHtml(s4));
        t4.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t4.setMaxLines(1);

        String s5="<b>Mo-Never Wanna Know</b>";
        t5.setText(Html.fromHtml(s5));
        t5.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t5.setMaxLines(1);

        String s6="<b>Mo-Red In The Grey</b>";
        t6.setText(Html.fromHtml(s6));
        t6.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t6.setMaxLines(1);

        String s7="<b>Mo-Pilgrim</b>";
        t7.setText(Html.fromHtml(s7));
        t7.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t7.setMaxLines(1);

        String s8="<b>Mo-Don't Wanna Dance</b>";
        t8.setText(Html.fromHtml(s8));
        t8.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t8.setMaxLines(1);

        String s9="<b>Mo-Waste Of Time</b>";
        t9.setText(Html.fromHtml(s9));
        t9.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t9.setMaxLines(1);

        String s10="<b>Mo-Lean On</b>";
        t10.setText(Html.fromHtml(s10));
        t10.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t10.setMaxLines(1);

        String s11="<b>BB Brunes-Dis-Moi</b>";
        t11.setText(Html.fromHtml(s11));
        t11.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t11.setMaxLines(1);

        String s12="<b>Syrano-Dans ma bulle</b>";
        t12.setText(Html.fromHtml(s12));
        t12.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t12.setMaxLines(1);

        String s13="<b>Noir Desir-Le vent nous portera</b>";
        t13.setText(Html.fromHtml(s13));
        t13.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25);
        t13.setMaxLines(1);

        //adds the textviews to the layout
        ll3.addView(t1);
        ll3.addView(t2);
        ll3.addView(t3);
        ll3.addView(t4);
        ll3.addView(t5);
        ll3.addView(t6);
        ll3.addView(t7);
        ll3.addView(t8);
        ll3.addView(t9);
        ll3.addView(t10);
        ll3.addView(t11);
        ll3.addView(t12);
        ll3.addView(t13);

        //on click listener for the textviews they are basicly the same just the names and the location of the song is diffrent
        t1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/Fever_Ray-If_I_Had_a_Heart.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Fever Ray-If I had a heart";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Fever Ray-If I had a heart\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/Icona Pop - I Love It.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Icona Pop-If I Love It";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Icona Pop-I Love It\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/01_Fire_Rides.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Mo-Fire Rides";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Mo-Fire Rides\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/02_Maiden.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Mo-Maiden";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Mo-Maiden\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/03_Never_Wanna_Know.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Mo-Never Wanna Know";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Mo-Never Wanna Know\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/04_Red_In_The_Grey.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Mo-Red In The Grey";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Mo-Red In The Grey\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/05_Pilgrim.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Mo-Pilgrim";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Mo-Pilgrim\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/06_Dont_Wanna_Dance.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Mo-Don't Wanna Dance";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Mo-Don't Wanna Dance\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/07_Waste_Of_Time_1.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Mo-Waste Of Time";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Mo-Waste Of Time\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t10.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/Mo - Lean On.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Mo-Lean On";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Mo-Lean On\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/BB Brunes - Dis-Moi.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> BB Brunes- Dis-Moi";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"BB Brunes- Dis-Moi\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/syrano-dans_ma_bulle.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Syrano-Dans ma bulle";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Syrano-Dans ma bulle\" playing", Toast.LENGTH_SHORT).show();
            }
        });

        t13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.stop();
                mp = MediaPlayer.create(getApplicationContext(), Uri.parse("file:///sdcard/Download/noir desir le vent nous portera.mp3"));
                sb.setMax(mp.getDuration());
                mp.start();
                seekbar_update();
                x="<b>now playing:</b> Noir Desir-Le vent nous portera";
                now.setText(Html.fromHtml(x));
                Toast.makeText(MainActivity.this, "\"Noir Desir-Le vent nous portera\" playing", Toast.LENGTH_SHORT).show();
            }
        });


        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.start();
                seekbar_update(); //updates the seekbar using the update method
                Toast.makeText(MainActivity.this, "music started", Toast.LENGTH_SHORT).show();
            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mp.pause();
                Toast.makeText(MainActivity.this, "music paused", Toast.LENGTH_SHORT).show();


            }
        });

        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //because using mp.stop() makes the music stop playing without possibility to restart it
                mp.pause();
                mp.seekTo(0);

                Toast.makeText(MainActivity.this, "music stopped", Toast.LENGTH_SHORT).show();
            }
        });
        track();
    }

    public void track()
    {
        sb.setOnSeekBarChangeListener(

                new SeekBar.OnSeekBarChangeListener() {

                    public void onProgressChanged(SeekBar sb, int progress, boolean fromUser) {
                        if(fromUser){

                            mp.seekTo(progress);
                            mp.start();Toast.makeText(MainActivity.this,"music skipped",Toast.LENGTH_SHORT).show();;
                        }

                    }

                    public void onStartTrackingTouch(SeekBar sb) {
                    }

                    public void onStopTrackingTouch(SeekBar sb) {

                    }
                }



        );}
    public void seekbar_update()
    {
        if(mp.isPlaying())
        {
            sb.setProgress(mp.getCurrentPosition());
            Runnable r=new Runnable()
            {
                @Override
                public void run()
                {
                    seekbar_update();
                }

            };
            new Handler().postDelayed(r,1);
        }


    }
}
