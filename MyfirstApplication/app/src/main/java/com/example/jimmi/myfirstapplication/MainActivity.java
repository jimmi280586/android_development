package com.example.jimmi.myfirstapplication;

import android.app.Activity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {
    Button b;
    EditText et;
    TextView tv;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button);
        et = (EditText)findViewById(R.id.editText);
        tv = (TextView)findViewById(R.id.textView);
        b.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                tv.setText("test");
                String t = et.getText().toString();
                tv.setText(t);
                Toast to = Toast.makeText(getApplicationContext(), "Notification", Toast.LENGTH_LONG);
                to.show();
            }
        });

        }



}
