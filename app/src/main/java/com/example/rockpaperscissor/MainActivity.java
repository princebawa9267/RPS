package com.example.rockpaperscissor;

import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.os.VibrationEffect;
import android.os.Vibrator;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_rock,btn_paper,btn_scissor;//Button for Inputs
    TextView computer_score,your_score;// Text displayed
    TextView resultDisplay; //Display result of the match
    ImageView computer_img,your_img; // Image of hand of user and computer
    char result; // Result of match
    char computerOutput; //used for image transformation
    int computerScoreInInteger,yourScoreInInteger; // Score counter for user and computer

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        btn_rock = findViewById(R.id.btn_rock);
        btn_paper = findViewById(R.id.btn_paper);
        btn_scissor = findViewById(R.id.btn_scissor);
        computer_img = findViewById(R.id.computer_img);
        your_img = findViewById(R.id.your_img);
        computer_score = findViewById(R.id.computer_score);
        your_score = findViewById(R.id.your_score);
        resultDisplay = findViewById(R.id.resultDisplay);
        // Text viewed converted into Integer for Score monitoring
        computerScoreInInteger = Integer.parseInt(computer_score.getText().toString());
        yourScoreInInteger = Integer.parseInt(your_score.getText().toString());


        //Animation used for waving hand
        Animation animationLeftHand = AnimationUtils.loadAnimation(this,R.anim.left_hand);
        computer_img.startAnimation(animationLeftHand);
        Animation animationRightHand = AnimationUtils.loadAnimation(this,R.anim.right_hand);
        your_img.startAnimation(animationRightHand);


        btn_rock.setOnClickListener(v -> {
            your_img.setImageResource(R.drawable.rightrock);
            operationAfterButtonClick('R');
            check();
        });
        btn_paper.setOnClickListener(v -> {
            your_img.setImageResource(R.drawable.rightpaper);
            operationAfterButtonClick('P');
            check();
        });
        btn_scissor.setOnClickListener(v -> {
            your_img.setImageResource(R.drawable.rightscissor);
            operationAfterButtonClick('S');
            check();
        });
    }
    void check() // check function is used to update score.
    {
        if(result=='W') // 'W' used for winner of user.
        {
            yourScoreInInteger++;
            resultDisplay.setText("You Won");
            resultDisplay.setTextColor(Color.GREEN);
        } else if (result == 'L')  //'L' used for Lose of user.
        {
            computerScoreInInteger++;
            resultDisplay.setText("You Lose");
            resultDisplay.setTextColor(Color.RED);
            ((Vibrator)getSystemService(VIBRATOR_SERVICE)).vibrate(VibrationEffect.createOneShot(300,100));
        }
        else
        {
            resultDisplay.setText("Draw");
            resultDisplay.setTextColor(Color.BLACK);
        }
        // Updating score of computer and user
        computer_score.setText(Integer.toString(computerScoreInInteger));
        your_score.setText(Integer.toString(yourScoreInInteger));
    }
    void computerImageChange(char computerOutput)
    {
        if(computerOutput == 'R')
        {
            computer_img.setImageResource(R.drawable.leftrock);
        }
        else if (computerOutput == 'S') {
            computer_img.setImageResource(R.drawable.leftscissor);
        }
        else
        {
            computer_img.setImageResource(R.drawable.leftpaper);
        }
    }

    void operationAfterButtonClick(char userInput)
    {
        //Input passed for operation
        RPS_Game game = new RPS_Game(userInput);
        computerOutput = game.computerInput();
        // Output :- You are winner,Looser or match is Draw.
        result = game.matchResult();
        computerImageChange(computerOutput);
        //Result is check and update score based on result.
    }

}