package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    EditText signedText;
    TextView score;
    Random rand = new Random();
    int number = rand.nextInt(100);
    static boolean flag = false;
    static int numTwo = 10;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        signedText = (EditText) findViewById(R.id.signedText);
        score = (TextView) findViewById(R.id.score);


    }

    public void Update(View view){

        String temp = signedText.getText().toString();
        if (temp.isEmpty())
            Toast.makeText(this, "Please Guess First!", Toast.LENGTH_SHORT).show();
        else {

            int guess = Integer.parseInt(signedText.getText().toString());

            Intent intent = new Intent(this, Result.class);
            if (numTwo == 0) {
                startActivity(intent);
                Toast.makeText(this, "Oops :(", Toast.LENGTH_SHORT).show();
            } else {
                if (guess < number)
                    Toast.makeText(this, "Guess is less than the Number", Toast.LENGTH_SHORT).show();
                else if (guess > number)
                    Toast.makeText(this, "Guess is greater than the Number", Toast.LENGTH_SHORT).show();
                else {
                    Toast.makeText(this, "Correct :)", Toast.LENGTH_SHORT).show();
                    flag = true;
                    startActivity(intent);
                }

                if (flag == false) {
                    numTwo--;
                    score.setText(Integer.toString(numTwo));
                }
            }
        }

    }


}