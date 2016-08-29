package com.example.jimmi.mediaplayer2;
import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.util.TypedValue;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class Simple extends Activity {

    //all private fields used in this class
    private final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);
    private ScrollView scroll;
    private LinearLayout layout;
    private LinearLayout innerLayout;
    private MediaPlayer mp = null;
    private static String music = "";
    private int buttonsPressedCount = 0;
    private ArrayList<Music> mp3 = new ArrayList<Music>();
    private Button pause = null;
    private Button play = null;
    private Button stop = null;
    private SeekBar bar = null;
    private Handler seekHandler = new Handler();
    private long timeElapsed = 0, finalTime = 0;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple);

        //all functions from layout initialized
        innerLayout = (LinearLayout) findViewById(R.id.linearLayout);
        layout = (LinearLayout) findViewById(R.id.linearLayout1);
        scroll = (ScrollView) findViewById(R.id.scrollView);
        pause = (Button) findViewById(R.id.idpause);
        play = (Button) findViewById(R.id.button);
        stop = (Button) findViewById(R.id.idstop);
        bar = (SeekBar) findViewById(R.id.seekBar);




        //running private method creating songlist
        newList();

        //for loop for creating textviews containing each song name
        for (int i=0; i<mp3.size();i++)
        {
            innerLayout.addView(createNewTextView(mp3.get(i).getName()));
        }

        //function for play button
        play.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                managerOfSound(music);
                finalTime = mp.getDuration();
                bar.setMax((int) finalTime);
                timeElapsed = mp.getCurrentPosition();
                bar.setProgress((int) timeElapsed);
                seekHandler.postDelayed(updateSeekBarTime, 100);
            }
        });

        //function for stop button uses pause and seekto inorder to keep buffer for song
        stop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //stop only works if the media player is running
                if (mp != null)
                {
                    mp.pause();
                    mp.seekTo(0);
                }
            }
        });

        //function for the pause button
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)
            {
                //only work if the media player is running
                if (mp != null)
                {
                    mp.pause();
                    buttonsPressedCount++;
                }
                //sets the pause to be clickable and changes the name to resume
                pause.setClickable(true);
                pause.setText("Resume");

                //runs the resumeplay method
                ResumePlay();
            }
        });
    }

    //handler to change seekBarTime

    private Runnable updateSeekBarTime = new Runnable() {

        public void run() {

            //get current position

            timeElapsed = mp.getCurrentPosition();

            //set seekbar progress

            bar.setProgress((int) timeElapsed);


            //repeat yourself that again in 100 miliseconds

            seekHandler.postDelayed(this, 100);

        }

    };







    private void ResumePlay()
    {
        //check to se if the pause button have been pressed two times
        if(buttonsPressedCount == 2)
        {
            //gets the current position and checks if it´s less then duration of song
            long length = mp.getCurrentPosition();
            long total = mp.getDuration();
            if (length < total)
            {
                //seeks to the cast value of current position and starts playing again
                mp.seekTo((int) length);
                mp.start();
                //returns text on button to pause
                pause.setText("Pause");
            }
            //sets pressed values to 0
            buttonsPressedCount = 0;
        }
    }

    //method for starting the song selected
    protected void managerOfSound(String theText)
    {
        //resets the media player and releases it so you don't have to songs playing
        if(mp != null)
        {
            mp.reset();
            mp.release();
        }
        if (theText.equals("track1"))
            this.mp = MediaPlayer.create(this, R.raw.track1);
        else if (theText.equals("track2"))
            this.mp = MediaPlayer.create(this, R.raw.track2);
        else if (theText.equals("track3"))
            this.mp = MediaPlayer.create(this, R.raw.track3);
        else if (theText.equals("track4"))
            this.mp = MediaPlayer.create(this, R.raw.track4);
        else if (theText.equals("track5"))
            this.mp = MediaPlayer.create(this, R.raw.track5);
        else
            Toast.makeText(getApplicationContext(), "song not available", Toast.LENGTH_LONG).show();

        mp.start();

    }

    //private method for creating the textviews
    private TextView createNewTextView(String text)
    {

        final TextView textView = new TextView(this);
        final String t = text;
        textView.setLayoutParams(lparams);
        textView.setText(t);
        //sets the size of the text
        textView.setTextSize(TypedValue.COMPLEX_UNIT_SP, 30);
        textView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v)
            {
                for (int i = 0; i < mp3.size(); i++)
                {
                    if (mp3.get(i).getName().equals(t))
                    {
                        music = mp3.get(i).getTrack();
                        Toast.makeText(getApplicationContext(), t + " is sellected", Toast.LENGTH_LONG).show();
                        play.performClick();
                    }
                }
            }
        });
        return textView;
    }

    //method for creating the song list hardcoded
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
        mp3.add(a);
        mp3.add(b);
        mp3.add(c);
        mp3.add(d);
        mp3.add(e);
    }
}