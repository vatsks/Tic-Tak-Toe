package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.GridLayout;
import android.widget.ImageView;
import android.widget.TextView;


import java.util.Arrays;

public class MainActivity extends AppCompatActivity {


    public void playAgain(View view){

        Button buttonPlayAgain=findViewById(R.id.buttonPlayAgain);
        TextView textViewwinner=findViewById(R.id.textViewwinner);

        textViewwinner.setVisibility(View.VISIBLE);
        buttonPlayAgain.setVisibility(View.VISIBLE);
        GridLayout gridLayout=findViewById(R.id.gridLayout);
        for(int i = 0; i < gridLayout.getChildCount(); i++) {
            ImageView counter = (ImageView) gridLayout.getChildAt(i);
            counter.setImageDrawable(null);
            // do stuff with child view
        }
        activePlayer=0;
        Arrays.fill(gameState, 2);

        //0 circle 1cross 2 empty
        gameActive =true;

    }

    int activePlayer=0;
    int[] gameState = {2 ,2 ,2 ,2 ,2 ,2 ,2, 2,2 };

    int[][] winningPosition ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    //0 circle 1cross 2 empty
    boolean gameActive =true;

public void dropin(View view) {

    ImageView counter;
    counter = (ImageView) view;


    int taggedCounter = Integer.parseInt(counter.getTag().toString());

    if (gameState[taggedCounter]==2 && gameActive) {
        counter.setTranslationY(-1000);
        gameState[taggedCounter] = activePlayer;
        if (activePlayer == 0) {

            activePlayer = 1;
            counter.setImageResource(R.drawable.circle);
        } else {
            activePlayer = 0;

            counter.setImageResource(R.drawable.cross);
        }

        counter.animate().translationYBy(1000).setDuration(400);
        for (int[] winningPositio : winningPosition) {
            if (gameState[winningPositio[0]] == gameState[winningPositio[1]] && gameState[winningPositio[1]] == gameState[winningPositio[2]] && gameState[winningPositio[0]] != 2) {

                //someone has won
                gameActive=false;
                String message;
                if (activePlayer == 0) {
                    message = "cross";
                } else {
                    message = "circle";
                }


                Button buttonPlayAgain=findViewById(R.id.buttonPlayAgain);
                TextView textViewwinner=findViewById(R.id.textViewwinner);
                textViewwinner.setText(message + "has won !!");
                textViewwinner.setVisibility(View.VISIBLE);
                buttonPlayAgain.setVisibility(View.VISIBLE);
            }
        }

    }
}


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}