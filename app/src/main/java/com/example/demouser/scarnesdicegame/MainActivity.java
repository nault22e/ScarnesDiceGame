package com.example.demouser.scarnesdicegame;

import android.content.res.Resources;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    Resources res;
    Random rand;

    //UI components
    private ImageView diceView;
    private TextView userScore;
    private TextView userStatus;
    private TextView compScore;
    private Button rollButton;
    private Button holdButton;
    private Button resetButton;


    //Drawable[] dieImages; --> could also randomly choose die from array of drawables instead
    // of using switch cass

    //Can also use setImageResource()




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
        holdButton = findViewById(R.id.hold_button);
        resetButton = findViewById(R.id.reset_button);

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
                //ContextCompat.getDrawable(this, R.drawable.dice1)
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

    private void handlerDemo(){
        resetButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                final Handler h = new Handler();
                Runnable r = new Runnable() {
                    @Override
                    //Can add dice conditions within run method (i.e. if score < 20, run again)
                    public void run() {
                        int result = rand.nextInt(100);
                        userScore.setText(Integer.toString(result));
                        if(result < 50){
                            h.postDelayed(this, 500);
                        }
                    }
                };
                h.postDelayed(r, 500); //Run the run method after half a second
            }
        });

    }
}
