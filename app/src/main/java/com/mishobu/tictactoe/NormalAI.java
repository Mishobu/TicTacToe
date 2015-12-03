package com.mishobu.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class NormalAI extends Activity {
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
        AIPlays();
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
                        GameSpace[0][0].setText("O");//escribe o sobre el boton
                        Board[0][0] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                    }
                    break;
                case R.id.TC:
                    if(!GameOver()) {
                        GameSpace[0][1].setText("O");//escribe o sobre el boton
                        Board[0][1] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                    }
                    break;
                case R.id.TR:
                    if(!GameOver()) {
                        GameSpace[0][2].setText("O");//escribe o sobre el boton
                        Board[0][2] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                    }
                    break;
                case R.id.ML:
                    if(!GameOver()) {
                        GameSpace[1][0].setText("O");//escribe o sobre el boton
                        Board[1][0] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                    }
                    break;
                case R.id.MC:
                    if(!GameOver()) {
                        GameSpace[1][1].setText("O");//escribe o sobre el boton
                        Board[1][1] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                    }
                    break;
                case R.id.MR:
                    if(!GameOver()) {
                        GameSpace[1][2].setText("O");//escribe o sobre el boton
                        Board[1][2] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                    }
                    break;
                case R.id.BL:
                    if(!GameOver()) {
                        GameSpace[2][0].setText("O");//escribe o sobre el boton
                        Board[2][0] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                    }
                    break;
                case R.id.BC:
                    if(!GameOver()) {
                        GameSpace[2][1].setText("O");//escribe o sobre el boton
                        Board[2][1] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                    }
                    break;
                case R.id.BR:
                    if(!GameOver()) {
                        GameSpace[2][2].setText("O");//escribe o sobre el boton
                        Board[2][2] = 0;
                        AIPlays();
                        Winner = WhoWins();
                        ShowResult();
                    }
                    break;
            }
            /**REVISANDO SI LAS GameSpace DEL JUEGO SON PRESIONADAS*/
        }
    };

    public int WhoWins()//METODO QUE REGRESA -1 SI GANA LA PERSONA 1 SI GANA EL ORDENADOR
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

    public int getWinner()//REGRESA EL VALOR DE LA VARIABLE Winner
    {
        return Winner;
    }

    public void ShowResult()//metodo que muetra el mensaje de Winner perdedor o empate
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

    public boolean FullBoard()//METODO QUE REVISA SITODO EL Board ESTA LLENO
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(Board[i][j]==-1)
                    return false;
        return true;
    }

    public void UpdateBoard()//Actualiza la vista cada vez que la computadora tira
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

    public boolean GameOver()//Meotodo que me  indica si acabo la partida
    {
        return FullBoard() || WhoWins()!=-1;//cuando el Board esta lleno o alguien ha ganado la partida
    }

    public void AIPlays()//tiene que buscar la mejor conbinacion (EL MAXIMO)
    {
        if(!GameOver())//mientras no acabe la partida aplicas el algoritmo
        {
            int f=0,c=0;
            int v=Integer.MIN_VALUE;
            int aux;

            for(int i=0;i<3;i++)
                for(int j=0;j<3;j++)
                    if(Board[i][j]==-1)//si el Board esta vacio
                    {
                        Board[i][j]=1;//tiramos
                        aux=min();//buscamos minimizar
                        if(aux>v)//en caso de tener un mejor valor
                        {
                            v=aux;//actualizamos el valor de v por si encuentra un mejor nodo
                            f=i;//guardamos las posiciones
                            c=j;//guardamos las posiciones
                        }
                        Board[i][j]=-1;//restableces el tiro
                    }
            Board[f][c]=1;  //la mejor posicion es la que tira (inidces f,c (son los que guarda i y j))
            GameSpace[f][c].setClickable(false);
        }
        UpdateBoard();
    }


    /**IMPLEMENTANDO EL ALGORITMO MINMAX*/

    /**ALGOTIRMO MIN MAX:

     Play_O(board)
     If end_game(board) then return eval(boar d)
     For each empty slot in board
     New_board = board
     Mark empty cell with O in new_board
     value = Play_X(new_board)
     If value < min  then value = min
     Return value
     End


     If end_game(board) then return eval(board)
     For each empty slot in board
     New_board = board
     Mark empty cell with X in new_board
     value = Play_O(new_board)
     If value > max  then value = max
     Return value
     end

     */


    public int max()
    {
        if(GameOver())//en caso de haber acabado
            if(WhoWins()!=-1) return -1;//gana maquina
            else return 0;//gana usuario

        int v=Integer.MIN_VALUE;
        int aux;

        for(int i=0; i<3; i++)
            for (int j=0;j<3;j++)
                if(Board[i][j]==-1)//si esta vacio
                {
                    Board[i][j]=1;//tiramos
                    aux=min();//buscamos minimizar
                    if(aux>v)
                        v=aux;//en caso de que auxiliar sea menos al MIN value lo guardamos
                    Board[i][j]=-1;//marcamos como vacia la casilla
                }
        return v;//regresamos el valor maximo del nodo
    }

    public int min()
    {
        // -1 indica que nadie a ganado
        if(GameOver())//en caso de haber acabado
            if(WhoWins()!=-1) return 1;//gana maquina
            else return 0;//gana usuario


        int v=Integer.MAX_VALUE;
        int aux;
        for (int i=0;i<3;i++)
            for (int j=0;j<3;j++)
                if(Board[i][j]==-1)//si esta vacio
                {
                    Board[i][j]=0;//tiramos
                    aux=max();//buscamos maximizar
                    if(aux<v) //en caso de que el valor retornado sea menor que v MAX value
                        v=aux;//actualizamos el valor de v (te manda el valor mas pequeño porque MINIMIZA)
                    Board[i][j]=-1;//marcamos como vacia la posicion(regresa Board posicion original)
                }
        return v;//regresamos el mejor valor
    }
}
