package com.example.jimmi.shared;

import android.app.Activity;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {

    private Button b;
    private TextView view;
    private EditText text;
    private SharedPreferences pref;
    private String t;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        b = (Button) findViewById(R.id.button);
        text = (EditText) findViewById(R.id.editText);
        view = (TextView) findViewById(R.id.textView);
        pref = getSharedPreferences("myPrefs", 0);

        t = pref.getString("savedValue", null);
        view.setText(t);
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v) {
                String s = text.getText().toString();
                SharedPreferences.Editor e = pref.edit();
                e.putString("savedValue", s);
                e.commit();
                t = pref.getString("savedValue", null);
                view.setText(t);
            }
        });
    }


}
