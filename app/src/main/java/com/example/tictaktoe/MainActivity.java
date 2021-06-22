package com.example.tictaktoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int activePlayer=0;
    int[] gameState = {2 ,2 ,2 ,2 ,2 ,2 ,2, 2,2 };

    int[][] winningPosition ={{0,1,2},{3,4,5},{6,7,8},{0,3,6},{1,4,7},{2,5,8},{0,4,8},{2,4,6}};

    //0 circle 1cross 2 empty

public void dropin(View view) {

    ImageView counter;
    counter = (ImageView) view;
    counter.setTranslationY(-1000);

    int taggedCounter = Integer.parseInt(counter.getTag().toString());
    gameState[taggedCounter]=activePlayer;
    if (activePlayer == 0) {

       activePlayer=1;
        counter.setImageResource(R.drawable.circle);
    } else {
        activePlayer = 0;

        counter.setImageResource(R.drawable.cross);
    }

    counter.animate().translationYBy(1000).setDuration(400);
    for(int[] winningPositio : winningPosition){
        if (gameState[winningPositio[0]]==gameState[winningPositio[1]]&&gameState[winningPositio[1]]==gameState[winningPositio[2]]&&gameState[winningPositio[0]]!=2){
              String message;
            if(activePlayer==0){
                message="cross";
            }
            else
            {
                message="circle";
            }

            Toast.makeText(this,message+" has won",Toast.LENGTH_LONG).show();
        }
    }


}
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}