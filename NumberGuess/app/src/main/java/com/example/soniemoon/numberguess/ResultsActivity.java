package com.example.soniemoon.numberguess;

/**
 * Created by SonieMoon on 10/13/2017.
 */

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

    public class ResultsActivity extends AppCompatActivity
    {
        TextView displayGuess;
        Button againButton;

        @Override
        protected void onCreate(Bundle savedInstanceState)
        {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_results);

            locateViews();

            bindFunctionality();

            if (getIntent().hasExtra(GuessingActivity.intentString))
            {
                String guesses = getIntent().getStringExtra(GuessingActivity.intentString);

                //Toast.makeText(getApplicationContext(), guesses, Toast.LENGTH_SHORT).show();
            }
        }

        private void locateViews()
        {
            displayGuess = (TextView) findViewById((R.id.displayGuess));
            againButton = (Button) findViewById(R.id.againButton);
        }

        private void bindFunctionality()
        {
            displayGuess.setText(getIntent().getStringExtra(GuessingActivity.intentString));

            againButton.setOnClickListener(new View.OnClickListener()
            {
                @Override
                public void onClick(View view)
                {
                    Intent intent = new Intent(getApplicationContext(), LandingActivity.class);
                    startActivity(intent);
                    finish();
                }
            });
        }

    }
