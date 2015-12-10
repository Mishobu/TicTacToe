package com.mishobu.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Random;

public class NormalAI extends Activity {

    Button NewGameButton;
    Button GameSpace[][];
    int Board[][] = new int[3][3];
    int First[] = new int[3];
    int Second[] = new int[3];
    Random A = new Random();
    Random B = new Random();
    int Shots=0;
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
        AIPlays();
    }

    public void RestartGame(View v) {
        EnabledButtons=true;
        turn = "X";
        Shots = 0;
        for (int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                GameSpace[i][j].setClickable(true);
                GameSpace[i][j].setText("");
                Board[i][j]=-1;
            }
        AIPlays();
        Winner = WhoWins();
        ShowResult();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Button pressedButton = (Button) v;
            switch (pressedButton.getId()){
                case R.id.TL:
                    if(!GameOver()) {
                        GameSpace[0][0].setText("O");
                        Board[0][0] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                        Shots=Shots+1;
                    }
                    break;
                case R.id.TC:
                    if(!GameOver()) {
                        GameSpace[0][1].setText("O");
                        Board[0][1] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                        Shots=Shots+1;
                    }
                    break;
                case R.id.TR:
                    if(!GameOver()) {
                        GameSpace[0][2].setText("O");
                        Board[0][2] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                        Shots=Shots+1;
                    }
                    break;
                case R.id.ML:
                    if(!GameOver()) {
                        GameSpace[1][0].setText("O");
                        Board[1][0] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                        Shots=Shots+1;
                    }
                    break;
                case R.id.MC:
                    if(!GameOver()) {
                        GameSpace[1][1].setText("O");
                        Board[1][1] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                        Shots=Shots+1;
                    }
                    break;
                case R.id.MR:
                    if(!GameOver()) {
                        GameSpace[1][2].setText("O");
                        Board[1][2] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                        Shots=Shots+1;
                    }
                    break;
                case R.id.BL:
                    if(!GameOver()) {
                        GameSpace[2][0].setText("O");
                        Board[2][0] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                        Shots=Shots+1;
                    }
                    break;
                case R.id.BC:
                    if(!GameOver()) {
                        GameSpace[2][1].setText("O");
                        Board[2][1] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                        Shots=Shots+1;
                    }
                    break;
                case R.id.BR:
                    if(!GameOver()) {
                        GameSpace[2][2].setText("O");
                        Board[2][2] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                        Shots=Shots+1;
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
            Resultado.setText("Player Wins");
        else if (Winner==1)
            Resultado.setText("AI Wins");
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

    public void UpdateBoard()
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                if (Board[i][j]==1) {
                    GameSpace[i][j].setText("X");}
                else if (Board[i][j]==0){
                    GameSpace[i][j].setText("O");}
                else GameSpace[i][j].setText("");
            }
    }

    public boolean GameOver()
    {
        return FullBoard() || WhoWins()!=-1;
    }

    public void AIPlays()
    {
        if(!GameOver())
        {
            int randomA = A.nextInt(First.length);
            int randomB = B.nextInt(Second.length);
            int a=0,b=0,f=0,c=0;
            int v=Integer.MIN_VALUE;
            int aux;
            boolean Empty = true;
            if(Shots<=5) {
                for (int i = 0; i < 3; i++)
                    for (int j = 0; j < 3; j++) {
                        if (Board[i][j] == -1)
                        {
                            Board[i][j] = 1;
                            aux = min();
                            if (aux > v)
                            {
                                v = aux;
                                f = i;
                                c = j;
                                for (a = 0; a < 3; a++)
                                    for (b = 0; b < 3; b++) {
                                        First[a] = i;
                                        Second[b] = j;
                                    }
                            }
                            Board[i][j] = -1;
                        } else if (Board[i][j] == 1 || Board[i][j] == 0) {
                            Empty = false;
                        }
                    }
                if(Empty){
                    Board[randomA][randomB]=1;
                    GameSpace[randomA][randomB].setClickable(false);
                    Shots=Shots+1;
                }else if(!Empty){
                    Board[f][c]=1;
                    GameSpace[f][c].setClickable(false);
                    Shots=Shots+1;
                }
            }else{
                boolean RandomShot = false;
                int x,y;
                do{
                    x = (int)(Math.random()*3);
                    y = (int)(Math.random()*3);
                    if(Board[x][y]==-1)
                    {
                        Board[x][y]=1;
                        RandomShot=true;
                        GameSpace[x][y].setClickable(false);
                    }
                }while(!RandomShot);
            }
        }
        UpdateBoard();
    }

    public int max()
    {
        if(GameOver())
            if(WhoWins()!=-1) return -1;
            else return 0;

        int v=Integer.MIN_VALUE;
        int aux;

        for(int i=0; i<3; i++)
            for (int j=0;j<3;j++)
                if(Board[i][j]==-1)
                {
                    Board[i][j]=1;
                    aux=min();
                    if(aux>v)
                        v=aux;
                    Board[i][j]=-1;
                }
        return v;
    }

    public int min()
    {

        if(GameOver())
            if(WhoWins()!=-1) return 1;
            else return 0;


        int v=Integer.MAX_VALUE;
        int aux;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                if(Board[i][j]==-1)
                {
                    Board[i][j]=0;
                    aux=max();
                    if(aux<v)
                        v=aux;
                    Board[i][j]=-1;
                }
        return v;
    }
}
