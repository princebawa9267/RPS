package com.example.rockpaperscissor;

import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn_rock,btn_paper,btn_scissor;//Button for Inputs
    TextView computer_score,your_score;// Text displayed
    ImageView computer_img,your_img; // Image of hand of user and computer
    char result; // Result of match
    int computerScore,yourScore; // Score counter for user and computer
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
        // Text viewed converted into Interger for Score monitoring
        computerScore = Integer.parseInt(computer_score.getText().toString());
        yourScore = Integer.parseInt(your_score.getText().toString());

        //Animation used for waving hand
        Animation animationLeftHand = AnimationUtils.loadAnimation(this,R.anim.left_hand);
        computer_img.startAnimation(animationLeftHand);
        Animation animationRightHand = AnimationUtils.loadAnimation(this,R.anim.right_hand);
        your_img.startAnimation(animationRightHand);


        btn_rock.setOnClickListener(v -> {
            RPS_Game game = new RPS_Game('R'); //Input passed for operation
            result = game.takeInput();  // Output :- You are winner,Looser or match is Draw.
            check(); //Result is check and updation of score based on result.

            //Updating the score of the computer and user.
            computer_score.setText(computerScore);
            your_score.setText(yourScore);
        });
        btn_paper.setOnClickListener(v -> {
            RPS_Game game = new RPS_Game('P');
            result = game.takeInput();
            check();
            computer_score.setText(computerScore);
            your_score.setText(yourScore);
        });
        btn_scissor.setOnClickListener(v -> {
            RPS_Game game = new RPS_Game('S');
            result = game.takeInput();
            check();
            computer_score.setText(computerScore);
            your_score.setText(yourScore);
        });
    }
    void check() // check function is used to update score.
    {
        if(result=='W') // 'W' used for winner of user.
        {
            yourScore++;
        } else if (result == 'L')  //'L' used for Lose of user.
        {
            computerScore++;
        }
    }

}