package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;
import android .view.View;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    int activePlayer=0;
    int[] gamestate={2,2,2,2,2,2,2,2,2};
    int[][] winPosition={{0,1,2},{3,4,5},{6,7,8},
                        {0,3,6},{1,4,7},{2,5,8},
                         {0,4,8},{2,4,6}};
//    game rules:
//    0=X;
//    1=O;
//    2=NULL;







    public void playerTap(View view) {

        ImageView img = (ImageView) view;
        int tag = Integer.parseInt(img.getTag().toString());
        TextView status = findViewById(R.id.status);

        if (gamestate[tag] == 2) {
            gamestate[tag] = activePlayer;
            if (activePlayer == 0) {
                img.setImageResource(R.drawable.x);
                img.setTranslationX(-1000f);
                activePlayer = 1;

                status.setText("O's turn to play");
            } else {
                img.setImageResource(R.drawable.o);
                img.setTranslationX(-1000f);
                activePlayer = 0;
                status.setText("X's turn to play");

            }


            img.animate().translationXBy(1000f);
        }

        for (int[] winpos : winPosition) {
                        if (gamestate[winpos[0]] == gamestate[winpos[1]] && gamestate[winpos[1]] == gamestate[winpos[2]]
                    && gamestate[winpos[0]] != 2) {
                String stat;


                if (gamestate[winpos[0]] == 0) {
                    stat = "X has won the game";

                    status.setText(stat);
                } else {
                    stat = "O has won the game";

                    status.setText(stat);
                }
            }
        }







    }

    public void restart(View view) {

        for(int i=0;i<9;i++){
            gamestate[i]=2;
        }
        activePlayer=0;
        ((ImageView)findViewById(R.id.button1)).setImageResource(0);
        ((ImageView)findViewById(R.id.button2)).setImageResource(0);
        ((ImageView)findViewById(R.id.button3)).setImageResource(0);
        ((ImageView)findViewById(R.id.button4)).setImageResource(0);
        ((ImageView)findViewById(R.id.button5)).setImageResource(0);
        ((ImageView)findViewById(R.id.button7)).setImageResource(0);
        ((ImageView)findViewById(R.id.button8)).setImageResource(0);
        ((ImageView)findViewById(R.id.button9)).setImageResource(0);
        ((ImageView)findViewById(R.id.button10)).setImageResource(0);
        TextView display = findViewById(R.id.displayRestart);
        display.setText("The game has restarted");
        TextView status=findViewById(R.id.status);
        status.setText("X's turn to play");



    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}