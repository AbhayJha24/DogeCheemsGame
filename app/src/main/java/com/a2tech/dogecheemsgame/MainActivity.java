package com.a2tech.dogecheemsgame;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    /*
    Player Symbols
     0 - Doge
     1 - Cheems
     */

    int activePlayer = 0;

    /*
    State Meanings
     0 - Doge
     1 - Cheems
     2 - Null
    */

    int win = 2;

    int[] gameState = {2, 2, 2, 2, 2, 2, 2, 2, 2};

    int[][] winningPositiions = {{0, 1, 2}, {3, 4, 5}, {6, 7, 8}, {0, 3, 6}, {1, 4, 7}, {2, 5, 8}, {0, 4, 9}, {2, 4, 6}};

    public void winCheck() {

        int count = 0;

        for (int i = 0; i < 8; i++) {
            if (gameState[winningPositiions[i][0]] == 1 && gameState[winningPositiions[i][1]] == 1 && gameState[winningPositiions[i][2]] == 1) {
                win = 1;
                count++;
                break;
            } else if (gameState[winningPositiions[i][0]] == 0 && gameState[winningPositiions[i][1]] == 0 && gameState[winningPositiions[i][2]] == 0) {
                win = 0;
                count++;
                break;
            }
        }
        if (count == 0) {
            if (gameState[0] != 2 && gameState[1] != 2 && gameState[2] != 2 && gameState[3] != 2 && gameState[4] != 2 && gameState[5] != 2 && gameState[6] != 2 && gameState[7] != 2 && gameState[8] != 2) {
                win = 3;
            }
            else{
                win = 2;
            }
        }
    }

    public void onRestartButtonClick(View view){

        Button resBtn = (Button) view;
        resBtn.setVisibility(View.INVISIBLE);
        // Do Something
        ImageView img0 = findViewById(R.id.c0);
        ImageView img1 = findViewById(R.id.c1);
        ImageView img2 = findViewById(R.id.c2);
        ImageView img3 = findViewById(R.id.c3);
        ImageView img4 = findViewById(R.id.c4);
        ImageView img5 = findViewById(R.id.c5);
        ImageView img6 = findViewById(R.id.c6);
        ImageView img7 = findViewById(R.id.c7);
        ImageView img8 = findViewById(R.id.c8);

        img0.setImageResource(android.R.color.transparent);
        img1.setImageResource(android.R.color.transparent);
        img2.setImageResource(android.R.color.transparent);
        img3.setImageResource(android.R.color.transparent);
        img4.setImageResource(android.R.color.transparent);
        img5.setImageResource(android.R.color.transparent);
        img6.setImageResource(android.R.color.transparent);
        img7.setImageResource(android.R.color.transparent);
        img8.setImageResource(android.R.color.transparent);

        for (int i=0; i<9; i++){
            gameState[i] = 2;
        }

        win = 2;
        activePlayer = 0;

        TextView sB = findViewById(R.id.status);
        sB.setText("Hello, welcome to the game - Doge' s Turn is always first");
    }

    public void squareTap(View view) {

        // Find the status bar

        TextView statusBar = findViewById(R.id.status);

        ImageView img = (ImageView) view;
        int tapped = Integer.parseInt(img.getTag().toString());

        //img.setTranslationY(-1000f);

        if (activePlayer == 1) {

            if (win == 2) {
                if (gameState[tapped] == 2) {
                    img.setImageResource(R.drawable.cheems);
                    gameState[tapped] = activePlayer;
                }
            }

            winCheck();
            if (win != 2) {
                switch (win) {
                    case 0:
                        statusBar.setText("Doge Wins");
                        Button restartBtn = findViewById(R.id.restartButton);
                        restartBtn.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        statusBar.setText("Cheems Wins");
                        Button rB1 = findViewById(R.id.restartButton);
                        rB1.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        statusBar.setText("Draw !");
                        Button rB2 = findViewById(R.id.restartButton);
                        rB2.setVisibility(View.VISIBLE);
                        break;
                }
            }

            else {
                if (gameState[tapped] != activePlayer){
                    Toast.makeText(this, "Tap on a Valid Square", Toast.LENGTH_SHORT).show();
                }
                else {
                    statusBar.setText("Doge' s Turn - Tap on the empty squares to play");
                    activePlayer = 0;
                }
            }
        } else {

            if (win == 2) {
                if (gameState[tapped] == 2) {
                    img.setImageResource(R.drawable.swoledoge);
                    gameState[tapped] = activePlayer;
                }
            }

            winCheck();
            if (win != 2) {
                switch (win) {
                    case 0:
                        statusBar.setText("Doge Wins");
                        Button restartBtn = findViewById(R.id.restartButton);
                        restartBtn.setVisibility(View.VISIBLE);
                        break;
                    case 1:
                        statusBar.setText("Cheems Wins");
                        Button rB1 = findViewById(R.id.restartButton);
                        rB1.setVisibility(View.VISIBLE);
                        break;
                    case 3:
                        statusBar.setText("Draw !");
                        Button rB2 = findViewById(R.id.restartButton);
                        rB2.setVisibility(View.VISIBLE);
                        break;
                }
            }

            else {
                if (gameState[tapped] != activePlayer){
                    Toast.makeText(this, "Tap on a Valid Square", Toast.LENGTH_SHORT).show();
                }
                else {
                    statusBar.setText("Cheems' Turn - Tap on the empty squares to play");
                    activePlayer = 1;
                }
            }
        }

        //img.animate().translationY(1000f).setDuration(300);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        TextView statusBar = findViewById(R.id.status);
        Button restartBtn = findViewById(R.id.restartButton);
        restartBtn.setVisibility(View.INVISIBLE);
        statusBar.setText("Hello, welcome to the game - Doge' s Turn is always first");
    }
}