package com.example.guessinggame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.util.Random;

public class Result extends AppCompatActivity {

    ImageView imageView2;
    MainActivity obj = new MainActivity();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        imageView2 = (ImageView) findViewById(R.id.imageView2);
        if (obj.numTwo == 0)
            imageView2.setImageResource(R.drawable.download);
        else
            imageView2.setImageResource(R.drawable.won);

    }

    public void Return(View view){
        Intent intent2 = new Intent(this, MainActivity.class);
        if(obj.flag == true){
            Constructor();
            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            Result.this.finish();
            startActivity(intent2);
        }
        else {
            Constructor();
            intent2.addFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_NEW_TASK);
            Result.this.finish();
            startActivity(intent2);
        }
    }

    public void Constructor(){
        obj.rand = new Random();
        obj.number = obj.rand.nextInt(100);
        obj.flag = false;
        obj.numTwo = 10;
    }
}