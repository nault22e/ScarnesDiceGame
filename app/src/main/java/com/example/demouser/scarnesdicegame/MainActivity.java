package com.example.demouser.scarnesdicegame;

import android.content.res.Resources;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Resources res;
    ImageView diceView;
    TextView userScore;
    TextView userStatus;
    TextView compScore;
    Button rollButton;
    Button holdButton;
    Button resetButton;

    Random rand;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rand = new Random();

        res = getResources();
        diceView = findViewById(R.id.imageView);
        userScore = findViewById(R.id.user_score);
        userStatus =  findViewById(R.id.user_status);
        compScore = findViewById(R.id.computer_score);
        rollButton = findViewById(R.id.roll_button);

        rollButton.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View v) {
                rollDie();
            }
        });

    }

    private int rollDie(){
        int result = rand.nextInt(6)+1;
        switch (result){
            case 1:
                diceView.setImageDrawable(res.getDrawable(R.drawable.dice1));
                break;
            case 2:
                diceView.setImageDrawable(res.getDrawable(R.drawable.dice2));
                break;
            case 3:
                diceView.setImageDrawable(res.getDrawable(R.drawable.dice3));
                break;
            case 4:
                diceView.setImageDrawable(res.getDrawable(R.drawable.dice4));
                break;
            case 5:
                diceView.setImageDrawable(res.getDrawable(R.drawable.dice5));
                break;
            case 6:
                diceView.setImageDrawable(res.getDrawable(R.drawable.dice6));
                break;
        }
        return result;
    }
}
