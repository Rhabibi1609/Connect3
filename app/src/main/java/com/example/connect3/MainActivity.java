package com.example.connect3;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int activePlayer = 0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    boolean gameOn = true;
    public void dropper(View view) {
        ImageView coin = (ImageView) view;
        int[][] winningPositions = {{0, 1, 2}, {0, 3, 6}, {3, 4, 5}, {1, 4, 7}, {6, 7, 8}, {2, 5, 8}, {0, 4, 8}, {2, 4, 6}};
        int coinsee = Integer.parseInt(coin.getTag().toString());
        gamestate[coinsee] = activePlayer;
        coin.setTranslationY(-1500);
        if (gameOn == true) {
            if (activePlayer == 0) {
                coin.setImageResource(R.drawable.red);
                activePlayer = 1;

            } else if (activePlayer == 1) {
                coin.setImageResource(R.drawable.yellow);
                activePlayer = 0;
            }
            coin.animate().translationYBy(1500).rotation(1700).setDuration(600);
            for (int[] winningPosition : winningPositions) {

                if (gamestate[winningPosition[0]] == gamestate[winningPosition[1]] && gamestate[winningPosition[1]] == gamestate[winningPosition[2]] && gamestate[winningPosition[0]] != 2) {
                    String winner;
                    if (activePlayer == 1) {
                        winner = "Red";
                    } else {
                        winner = "Yellow";
                    }
                    Toast.makeText(this, winner + " Has won! ", Toast.LENGTH_SHORT).show();
                    gameOn = false;
                }
            }
        }
        else
        {
            Toast.makeText(this, " Game Over ", Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}