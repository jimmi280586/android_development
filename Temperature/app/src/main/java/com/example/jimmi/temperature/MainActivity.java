package com.example.jimmi.temperature;

import android.app.Activity;
import android.graphics.Color;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;


public class MainActivity extends Activity {

    Button b;
    private static final String TAG = "MyActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        b = (Button)findViewById(R.id.button1);
        b.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
                LinearLayout input = (LinearLayout)findViewById(R.id.ll);
                TextView result = (TextView)findViewById(R.id.result);
                EditText userfield = (EditText)findViewById(R.id.editText1);

                //get the value from user input box and converts into double value
                double inputvalue = Double.parseDouble(String.valueOf(userfield.getText()));
                RadioButton celciusbutton =(RadioButton)findViewById(R.id.celciusbutton);
                RadioButton fahrenheitbutton =(RadioButton)findViewById(R.id.fahrenheitbutton);

                //check which radio button is checked
                if(celciusbutton.isChecked())
                {
                    //change background colour
                    input.setBackgroundColor(Color.YELLOW);
                    //display the converted value
                    result.setText(f2c(inputvalue)+"");
                    //prints what it was calculated to in the toast area.
                    Toast.makeText(getApplicationContext(), "degree Celcius", Toast.LENGTH_LONG).show();
<<<<<<< HEAD

                    Log.d("log", "userinput " + inputvalue + " result of calculation " + f2c(inputvalue));

=======
                    //writes the userinput and the result to the log as a debug log
                    Log.d("log", "userinput " + inputvalue + " result of calculation " + f2c(inputvalue));
                    //sets the fahrenheit button to selected not nesesary.
>>>>>>> f099e2baf67340c32432e157c814eb91a2a7c6f2
                    fahrenheitbutton.setChecked(true);
                }
                else
                {
                    input.setBackgroundColor(Color.GREEN);
                    result.setText(c2f(inputvalue) + "");
                    Toast.makeText(getApplicationContext(), "degree Fahrenhiet", Toast.LENGTH_LONG).show();

                    Log.d("log", "userinput " + inputvalue + " result of calculation " + c2f(inputvalue));
                    celciusbutton.setChecked(true);
                }
            }
        });
    }

    //Celcius to Fahrenhiet method
    private double c2f(double c)
    {
        return (c*9)/5+32;
    }
    //Fahrenhiet to Celcius method
    private double f2c(double f)
    {
        return (f-32)*5/9;
    }


}
