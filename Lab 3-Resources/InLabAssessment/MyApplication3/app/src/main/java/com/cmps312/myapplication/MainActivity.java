package com.cmps312.myapplication;

import android.opengl.Visibility;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Date;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    int[] diceFaces = {
            R.drawable.ic_dice_six_faces_one,
            R.drawable.ic_dice_six_faces_two,
            R.drawable.ic_dice_six_faces_three,
            R.drawable.ic_dice_six_faces_four,
            R.drawable.ic_dice_six_faces_five,
            R.drawable.ic_dice_six_faces_six,

    };
    ImageView diceFaceImg;

    Random random;
    int turn = 1;

    TextView playerOneScoreTv;
    TextView playerTwoScoreTv;
    TextView turnTv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        diceFaceImg = findViewById(R.id.dice_img);
        playerOneScoreTv = findViewById(R.id.pl1_score);
        playerTwoScoreTv = findViewById(R.id.pl2_score);
        turnTv = findViewById(R.id.turnTv);

        random = new Random(new Date().getTime());

    }

    public void rollDice(View view) {

        int currentPlayer1Score = Integer.parseInt(playerOneScoreTv.getText().toString());
        int currentPlayer2Score = Integer.parseInt(playerTwoScoreTv.getText().toString());


        int rolled = Math.abs(random.nextInt() % 6) + 1;


        Log.d("TAG", "rollDice: " + rolled);
        diceFaceImg.setImageResource(diceFaces[rolled - 1]);


        if (turn == 1) {
            playerOneScoreTv.setText((currentPlayer1Score + rolled) + "");
            turnTv.setText("Turn : Player 2");
            turn = 2;

        } else {
            playerTwoScoreTv.setText((currentPlayer2Score + rolled) + "");
            turnTv.setText("Turn : Player 1");
            turn = 1;
        }

        if (currentPlayer1Score >= 100) {
            turnTv.setText("Player 1 Won the Game");
            view.setVisibility(View.GONE);
        }

        if (currentPlayer2Score >= 100) {
            turnTv.setText("Player 2 Won the Game ");
            view.setVisibility(View.GONE);
        }


    }
}
