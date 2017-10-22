package com.example.soniemoon.numberguess;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import android.content.Intent;


public class GuessingActivity extends AppCompatActivity {

    public static String intentString = "inputData";

    int upperLimit = 20;
    int lowerLimit = 1;
    int guessCounter;

    int targetNumber = (int)(Math.random() * upperLimit) + lowerLimit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_guessing);

        Button numberCheck = (Button) findViewById(R.id.numberCheck);
        numberCheck.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View view) {
                EditText inputData = (EditText) findViewById(R.id.inputNumber);
                String inputString = inputData.getText().toString();

                if(inputString.isEmpty())
                {
                    Toast.makeText(GuessingActivity.this, "You must enter a number!", Toast.LENGTH_SHORT).show();
                }
                else
                {
                    int inputNumberInt = Integer.parseInt(inputString);

                    if(targetNumber > inputNumberInt)
                    {
                        guessCounter++;
                        Toast.makeText(GuessingActivity.this, "Your guess is too low! ",
                                Toast.LENGTH_SHORT).show();
                    }
                    else if(targetNumber < inputNumberInt)
                    {
                        guessCounter++;
                        Toast.makeText(GuessingActivity.this, "Your guess is too high! ",
                                Toast.LENGTH_SHORT).show();
                    }
                    else
                    {
                        guessCounter++;
                        Toast.makeText(GuessingActivity.this,
                               "You got it in " + guessCounter + "!",
                                Toast.LENGTH_SHORT).show();
                        Intent intent = new Intent(getApplicationContext(), ResultsActivity.class);
                        intent.putExtra(intentString, String.valueOf(guessCounter));
                        startActivity(intent);
                        //finish();
                    }
                }
            }
        });
    }

}
