package com.example.jimmi.awsome_brick_game;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Display;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;

import static com.example.jimmi.awsome_brick_game.GameActivity.*;

/**
 * Created by jimmi on 10-08-2015.
 */
public class StartActivity extends Activity
{
    @Override
    public void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu_main);
       final Bundle f = savedInstanceState;

        final Context context = this;

        RelativeLayout layout = (RelativeLayout)findViewById(R.id.MenuLayout);
        Button b = (Button)findViewById(R.id.resumeGame);
        Button b1 = (Button)findViewById(R.id.newGame);
        Button b2 = (Button)findViewById(R.id.exit);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(StartActivity.this, GameActivity.class);

                startActivity(intent);


            }
        });
    }
}
