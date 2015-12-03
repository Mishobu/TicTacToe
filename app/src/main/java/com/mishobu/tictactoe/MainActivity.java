package com.mishobu.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
{
    //Panel gato_panel,panel_principal;//declarando los paneles del gato y el principal donde sera colocado dicho panel
    Button NewGameButton;//declarando el boton juego nuevo
    Button GameSpace[][];//declarando un arreglo de botones
    int Board[][] = new int[3][3];//Board que almacenara en que posiciones estan las x y las 0
    boolean EnabledButtons = false;//declarando botonees habilitados como falso
    String turn = "X";// turno
    int Winner;// Winner es -1 cuando no ha ganado nadei, 0 yo gano y 1 gana la maquina

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        NewGameButton = (Button) findViewById(R.id.Restart);
        GameSpace = new Button[3][3];//declarando un arreglo de botones de 3 filas por 3 columnas
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
                GameSpace[i][j].setText("");//borramos el contenido de las GameSpace
                Board[i][j]=-1;//inicializando todas las posiciones del Board a menos uno
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
                        GameSpace[0][0].setText("X");//escribe o sobre el boton
                        Board[0][0] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][0].setClickable(false);
                    }else if(turn == "O"){
                        GameSpace[0][0].setText("O");//escribe o sobre el boton
                        Board[0][0] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][0].setClickable(false);
                    }
                    break;
                case R.id.TC:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[0][1].setText("X");//escribe o sobre el boton
                        Board[0][1] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][1].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[0][1].setText("O");//escribe o sobre el boton
                        Board[0][1] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][1].setClickable(false);
                    }
                    break;
                case R.id.TR:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[0][2].setText("X");//escribe o sobre el boton
                        Board[0][2] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][2].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[0][2].setText("O");//escribe o sobre el boton
                        Board[0][2] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[0][2].setClickable(false);
                    }
                    break;
                case R.id.ML:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[1][0].setText("X");//escribe o sobre el boton
                        Board[1][0] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][0].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[1][0].setText("O");//escribe o sobre el boton
                        Board[1][0] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][0].setClickable(false);
                    }
                    break;
                case R.id.MC:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[1][1].setText("X");//escribe o sobre el boton
                        Board[1][1] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][1].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[1][1].setText("O");//escribe o sobre el boton
                        Board[1][1] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][1].setClickable(false);
                    }
                    break;
                case R.id.MR:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[1][2].setText("X");//escribe o sobre el boton
                        Board[1][2] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][2].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[1][2].setText("O");//escribe o sobre el boton
                        Board[1][2] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[1][2].setClickable(false);
                    }
                    break;
                case R.id.BL:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[2][0].setText("X");//escribe o sobre el boton
                        Board[2][0] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][0].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[2][0].setText("O");//escribe o sobre el boton
                        Board[2][0] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][0].setClickable(false);
                    }
                    break;
                case R.id.BC:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[2][1].setText("X");//escribe o sobre el boton
                        Board[2][1] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][1].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[2][1].setText("O");//escribe o sobre el boton
                        Board[2][1] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][1].setClickable(false);
                    }
                    break;
                case R.id.BR:
                    if(turn == "X" && !GameOver()) {
                        GameSpace[2][2].setText("X");//escribe o sobre el boton
                        Board[2][2] = 1;
                        turn = "O";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][2].setClickable(false);
                    }else if(turn == "O" && !GameOver()){
                        GameSpace[2][2].setText("O");//escribe o sobre el boton
                        Board[2][2] = 0;
                        turn = "X";
                        Winner = WhoWins();
                        ShowResult();
                        GameSpace[2][2].setClickable(false);
                    }
                    break;
            }
            /**REVISANDO SI LAS GameSpace DEL JUEGO SON PRESIONADAS*/
        }
    };

    public int WhoWins()//METODO QUE REGRESA -1 SI GANA LA O 0 Y SI GANA LA X 1
    {
        if (Board[0][0]!=-1 && Board[0][0]==Board[1][1] && Board[0][0]==Board[2][2])//viendo quien gana en las diagonales
            return Board[0][0];
        if (Board[0][2]!=-1 && Board[0][2]==Board[1][1] && Board[0][2]==Board[2][0])//viendo quien gana en las diagonales
            return Board[0][2];
        for (int i=0;i<3;i++)
        {
            if(Board[i][0]!=-1 && Board[i][0]==Board[i][1] && Board[i][0]==Board[i][2])//viendo quien gana en las columanas
                return Board[i][0];

            if(Board[0][i]!=-1 && Board[0][i]==Board[1][i] && Board[0][i]==Board[2][i])//viendo quien gana en las filas.
                return Board[0][i];
        }
        return -1;//indicando que nadie ha ganado
    }

    public void ShowResult()//metodo que muetra el mensaje de Winner perdedor o empate
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

    public boolean FullBoard()//METODO QUE REVISA SITODO EL Board ESTA LLENO
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(Board[i][j]==-1)
                    return false;
        return true;
    }

    public boolean GameOver()//Meotodo que me  indica si acabo la partida
    {
        return FullBoard() || WhoWins()!=-1;//cuando el Board esta lleno o alguien ha ganado la partida
    }
}
