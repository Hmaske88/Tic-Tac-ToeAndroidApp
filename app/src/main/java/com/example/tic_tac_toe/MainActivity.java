package com.example.tic_tac_toe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    boolean gameActive = true;
//    0 --> x
//    1 --> o
//    2 --> NULL
    int activeplayer=0;
    int[] gamestate = {2,2,2,2,2,2,2,2,2};
    int[][] winposition = {{0,1,2},{3,4,5},{6,7,8},
                        {0,3,6},{1,4,7},{2,5,8},
                        {0,4,8},{2,4,6}};

    public void playerTap(View view)
    {
        ImageView img = (ImageView)view;
        int tappedimg = Integer.parseInt(img.getTag().toString());

        if(gamestate[tappedimg]==2 && gameActive==true){
            gamestate[tappedimg]=activeplayer;
            img.setTranslationY(-1000f);
            if (activeplayer==0){
                img.setImageResource(R.drawable.x);
                activeplayer=1;
                TextView status = findViewById(R.id.status);
                status.setText("O's turn - Tap to play");
            }
            else{
                img.setImageResource(R.drawable.o);
                activeplayer=0;
                TextView status = findViewById(R.id.status);
                status.setText("X's turn - Tap to play");
            }
            img.animate().translationYBy(1000f).setDuration(300);
        }

        for (int[] win : winposition)
        {
            if(gamestate[win[0]]==gamestate[win[1]] && gamestate[win[1]]==gamestate[win[2]] && gamestate[win[0]]!=2)
            {
                String winnerStr;
                gameActive=false;
                if(gamestate[win[0]]==0)
                {
                    winnerStr="X win the game";
                }
                else
                {
                    winnerStr="O win the game";
                }
                TextView status = findViewById(R.id.status);
                status.setText(winnerStr);
            }
        }
    }

    public void gameReset(View view)
    {
        gameActive = true;
        activeplayer=0;
        for (int i=0;i<gamestate.length;i++)
        {
            gamestate[i]=2;
        }
        ((ImageView)findViewById(R.id.imageView2)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView3)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView4)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView8)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView9)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView10)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView11)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView12)).setImageResource(0);
        ((ImageView)findViewById(R.id.imageView13)).setImageResource(0);

        TextView status = findViewById(R.id.status);
        status.setText("Tap to play");
    }

    public void restart(View view)
    {
        gameReset(view);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
}