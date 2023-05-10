package com.example.connectthree;

import androidx.appcompat.app.AppCompatActivity;

import android.util.Log;
import android.widget.GridLayout;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Arrays;


public class MainActivity extends AppCompatActivity {



    boolean gameOver = false;
    boolean pirateTurn = true;

    // 0 = Empty, 1 = pirates, 2 = dragons
    int[] gameState = {0, 0, 0, 0, 0, 0, 0, 0, 0};

    int[][] winStates = {{0, 1, 2}, {0, 3, 6}, {0, 4, 8}, {1, 4, 7}, {2, 5, 8}, {2, 4, 6}, {3, 4, 5}, {6, 7, 8} };
    public void placePiece(View view) {

        ImageView counter = (ImageView) view;
        int tappedCounter = Integer.parseInt(counter.getTag().toString());
        if(gameState[tappedCounter] == 0 && gameOver == false) {
            counter.setY(-1500);

            if (pirateTurn) {
                gameState[tappedCounter] = 1;
                counter.setImageResource(R.drawable.skull);
                pirateTurn = false;
            } else {
                gameState[tappedCounter] = 2;
                counter.setImageResource(R.drawable.dragon_token);
                pirateTurn = true;
            }


            counter.animate().translationY(0).setDuration(300);
            checkIfWinStateTrue(view);
        }
    }

    public void checkIfWinStateTrue (View view) {
        for(int[] winState: winStates) {
            if(gameState[winState[0]] == gameState[winState[1]] && gameState[winState[1]] == gameState[winState[2]] && gameState[winState[1]] != 0) {
                gameOver = true;
                String winner = "";
                if (pirateTurn == true) {
                     winner = "Dragons";

                } else {
                     winner = "Pirates";

                }
                Button playAgainBtn = (Button) findViewById(R.id.button);
                TextView playAgainTxt = (TextView) findViewById(R.id.textView);
                playAgainTxt.setText("The " + winner + " have won!");
                playAgainBtn.setVisibility(View.VISIBLE);
                playAgainTxt.setVisibility(View.VISIBLE);




        }

    }}

    public void restartGame (View view) {
        gameOver = false;
        pirateTurn = true;
        int i = 0;
        while(i < 9) {
            gameState[i] = 0;
            i++;
        }
        Button playAgainBtn = (Button) findViewById(R.id.button);
        TextView playAgainTxt = (TextView) findViewById(R.id.textView);
        playAgainBtn.setVisibility(View.INVISIBLE);
        playAgainTxt.setVisibility(View.INVISIBLE);
        hideTokens();
    }

    public void hideTokens() {
        ImageView tpLeft = findViewById(R.id.tpLeft);
        tpLeft.setImageResource(0);
        ImageView tpCenter = findViewById(R.id.tpCenter);
        tpCenter.setImageResource(0);
        ImageView tpRight = findViewById(R.id.tpRight);
        tpRight.setImageResource(0);
        ImageView ctLeft = findViewById(R.id.ctLeft);
        ctLeft.setImageResource(0);
        ImageView ctCenter = findViewById(R.id.ctCenter);
        ctCenter.setImageResource(0);
        ImageView ctRight = findViewById(R.id.ctRight);
        ctRight.setImageResource(0);
        ImageView btLeft = findViewById(R.id.btLeft);
        btLeft.setImageResource(0);
        ImageView btCenter = findViewById(R.id.btCenter);
        btCenter.setImageResource(0);
        ImageView btRight = findViewById(R.id.btRight);
        btRight.setImageResource(0);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}