package com.example.jimmi.mediaplayer;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import java.lang.reflect.Array;
import java.util.ArrayList;

public class Simple extends Activity {

    private final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    private ScrollView scroll;
    private LinearLayout layout;
    private Button button;
    private int count = 0;
    private LinearLayout innerLayout;
    MediaPlayer mp = null;
    public String music = "";
    int buttonsPressedCount = 0;
    ArrayList<Music> mp3 = new ArrayList<Music>();

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);
        innerLayout = (LinearLayout) findViewById(R.id.linearLayout);
        scroll = (ScrollView) findViewById(R.id.scrollView);
        final Button pause = (Button) findViewById(R.id.idpause);
        final Button play = (Button) findViewById(R.id.idplay);
        final Button stop = (Button) findViewById(R.id.idstop);

        newList();

        for (int i=1; i<mp3.size();i++)
        {
            innerLayout.addView(createNewTextView(mp3.get(i).getName()));
        }


        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                if ((mp != null))
                {
                    if(!(music.equals("")))
                    {
                        pause.performClick();
                    }
                }
                else
                     managerOfSound(music);
            }
        });


        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null)
                {
                    mp.pause();
                    mp.seekTo(0);
                    pause.performClick();
                }
            }
        });


        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (mp != null)
                {
                    mp.pause();
                    buttonsPressedCount++;

                }
                pause.setClickable(true);

                ResumePlay();
            }
        });
    }

    private void ResumePlay()
    {
        if (buttonsPressedCount == 2)
        {
            long length = mp.getCurrentPosition();
            long total = mp.getDuration();
            if(length < total)
            {
                mp.seekTo((int) length);
                mp.start();
            }
            buttonsPressedCount = 0;
        }
    }

    protected void managerOfSound(String theText)
    {
        if (theText.equals("track1"))
            mp = MediaPlayer.create(this, R.raw.track1);
        if (theText.equals("track2"))
            mp = MediaPlayer.create(this, R.raw.track2);
        if (theText.equals("track3"))
            mp = MediaPlayer.create(this, R.raw.track3);
        if (theText.equals("track4"))
            mp = MediaPlayer.create(this, R.raw.track4);
        if (theText.equals("track5"))
            mp = MediaPlayer.create(this, R.raw.track5);
        mp.start();

    }

    private TextView createNewTextView(String text)
    {
        final String t = text;
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText(text);
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP,30);
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                for (int i = 1; i < mp3.size(); i++) {
                    if (mp3.get(i).getName().equals(t)) {
                        music = mp3.get(i).getTrack();
                    }
                }

            }
        });
        return textView;
    }
    private void newList()
    {
        Music a = new Music("immortal", "track1");
        Music b = new Music("highway_to_hell", "track2");
        Music c = new Music("blow_my_whistle", "track3");
        Music d = new Music("hooked_on_a_feeling", "track4");
        Music e = new Music("surfin_usa", "track5");

        mp3.add(a);
        mp3.add(b);
        mp3.add(c);
        mp3.add(d);
        mp3.add(e);
    }
}