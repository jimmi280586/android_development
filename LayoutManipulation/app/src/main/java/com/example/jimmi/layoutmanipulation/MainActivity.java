package com.example.jimmi.layoutmanipulation;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    private ScrollView scroll;
    private LinearLayout layout;
    private Button button;
    private int count = 0;
    private LinearLayout innerLayout;
    private final LinearLayout.LayoutParams lparams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.WRAP_CONTENT, LinearLayout.LayoutParams.WRAP_CONTENT);


    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        innerLayout = (LinearLayout) findViewById(R.id.LinearLayout01);
        scroll = (ScrollView) findViewById(R.id.scrollView);
        layout = (LinearLayout) findViewById(R.id.linearLayout);
        button = (Button) findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v)
            {
                innerLayout.addView(createNewTextView(count + ""));

                count++;
            }
        });



    }

    private TextView createNewTextView(String text)
    {
        final TextView textView = new TextView(this);
        textView.setLayoutParams(lparams);
        textView.setText("New text: " + text);
        textView.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                innerLayout.removeView(textView);
            }
        });
        return textView;
    }


}
