package com.mishobu.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
{

    Button NewGameButton;
    Button GameSpace[][];
    int Board[][] = new int[3][3];
    boolean EnabledButtons = false;
    String turn = "X";
    int Winner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewGameButton = (Button) findViewById(R.id.Restart);
        GameSpace = new Button[3][3];
        GameSpace[0][0] = (Button) findViewById(R.id.TL);
        GameSpace[0][1] = (Button) findViewById(R.id.TC);
        GameSpace[0][2] = (Button) findViewById(R.id.TR);
        GameSpace[1][0] = (Button) findViewById(R.id.ML);
        GameSpace[1][1] = (Button) findViewById(R.id.MC);
        GameSpace[1][2] = (Button) findViewById(R.id.MR);
        GameSpace[2][0] = (Button) findViewById(R.id.BL);
        GameSpace[2][1] = (Button) findViewById(R.id.BC);
        GameSpace[2][2] = (Button) findViewById(R.id.BR);


        for (int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                GameSpace[i][j].setClickable(true);
                GameSpace[i][j].setOnClickListener(clickListener);
                Board[i][j]=-1;
            }
    }

    public void RestartGame(View v) {
        EnabledButtons=true;
        turn = "X";
        for (int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                GameSpace[i][j].setClickable(true);
                GameSpace[i][j].setText("");
                Board[i][j]=-1;
            }
        Winner = WhoWins();
        ShowResult();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Button pressedButton = (Button) v;
            switch (pressedButton.getId()){
                case R.id.TL:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[0][0].setText("X");
                        Board[0][0] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][0].setClickable(false);
                    }else if(turn == "O"){
                        GameSpace[0][0].setText("O");
                        Board[0][0] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][0].setClickable(false);
                    }
                    break;
                case R.id.TC:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[0][1].setText("X");
                        Board[0][1] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][1].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[0][1].setText("O");
                        Board[0][1] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][1].setClickable(false);
                    }
                    break;
                case R.id.TR:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[0][2].setText("X");
                        Board[0][2] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][2].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[0][2].setText("O");
                        Board[0][2] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][2].setClickable(false);
                    }
                    break;
                case R.id.ML:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[1][0].setText("X");
                        Board[1][0] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][0].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[1][0].setText("O");
                        Board[1][0] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][0].setClickable(false);
                    }
                    break;
                case R.id.MC:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[1][1].setText("X");
                        Board[1][1] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][1].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[1][1].setText("O");
                        Board[1][1] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][1].setClickable(false);
                    }
                    break;
                case R.id.MR:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[1][2].setText("X");
                        Board[1][2] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][2].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[1][2].setText("O");
                        Board[1][2] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][2].setClickable(false);
                    }
                    break;
                case R.id.BL:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[2][0].setText("X");
                        Board[2][0] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][0].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[2][0].setText("O");
                        Board[2][0] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][0].setClickable(false);
                    }
                    break;
                case R.id.BC:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[2][1].setText("X");
                        Board[2][1] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][1].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[2][1].setText("O");
                        Board[2][1] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][1].setClickable(false);
                    }
                    break;
                case R.id.BR:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[2][2].setText("X");
                        Board[2][2] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][2].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[2][2].setText("O");
                        Board[2][2] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][2].setClickable(false);
                    }
                    break;
            }
        }
    };

    public int WhoWins()
    {
        if (Board[0][0]!=-1 && Board[0][0]==Board[1][1] && Board[0][0]==Board[2][2])
            return Board[0][0];
        if (Board[0][2]!=-1 && Board[0][2]==Board[1][1] && Board[0][2]==Board[2][0])
            return Board[0][2];
        for (int i=0;i<3;i++)
        {
            if(Board[i][0]!=-1 && Board[i][0]==Board[i][1] && Board[i][0]==Board[i][2])
                return Board[i][0];

            if(Board[0][i]!=-1 && Board[0][i]==Board[1][i] && Board[0][i]==Board[2][i])
                return Board[0][i];
        }
        return -1;
    }

    public void ShowResult()
    {
        TextView Resultado = (TextView) findViewById(R.id.Resultado);
        if (Winner==0)
            Resultado.setText("Player O Wins");
        else if (Winner==1)
            Resultado.setText("Player X Wins");
        else if (Winner==-1 && GameOver())
            Resultado.setText("Draw");
        else if (Winner==-1)
            Resultado.setText(" ");
    }

    public boolean FullBoard()
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(Board[i][j]==-1)
                    return false;
        return true;
    }

    public boolean GameOver()
    {
        return FullBoard() || WhoWins()!=-1;
    }
}
