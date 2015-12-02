package com.mishobu.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends Activity
{
    //Panel gato_panel,panel_principal;//declarando los paneles del gato y el principal donde sera colocado dicho panel
    Button boton_juego_nuevo;//declarando el boton juego nuevo
    Button celdas[][];//declarando un arreglo de botones
    int tablero[][] = new int[3][3];//tablero que almacenara en que posiciones estan las x y las 0
    boolean botones_habilitados = false;//declarando botonees habilitados como falso
    String turn = "X";// turno
    int Ganador;// ganador es -1 cuando no ha ganado nadei, 0 yo gano y 1 gana la maquina

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        boton_juego_nuevo = (Button) findViewById(R.id.Restart);
        celdas = new Button[3][3];//declarando un arreglo de botones de 3 filas por 3 columnas
        celdas[0][0] = (Button) findViewById(R.id.TL);
        celdas[0][1] = (Button) findViewById(R.id.TC);
        celdas[0][2] = (Button) findViewById(R.id.TR);
        celdas[1][0] = (Button) findViewById(R.id.ML);
        celdas[1][1] = (Button) findViewById(R.id.MC);
        celdas[1][2] = (Button) findViewById(R.id.MR);
        celdas[2][0] = (Button) findViewById(R.id.BL);
        celdas[2][1] = (Button) findViewById(R.id.BC);
        celdas[2][2] = (Button) findViewById(R.id.BR);


        for (int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                celdas[i][j].setClickable(true);
                celdas[i][j].setOnClickListener(clickListener);
                tablero[i][j]=-1;
            }
    }

    public void RestartGame(View v) {
        botones_habilitados=true;
        turn = "X";
        for (int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                celdas[i][j].setClickable(true);
                celdas[i][j].setText("");//borramos el contenido de las celdas
                tablero[i][j]=-1;//inicializando todas las posiciones del tablero a menos uno
            }
        Ganador = QuienGana();
        Mostrar_mensaje();
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View v) {
            Button pressedButton = (Button) v;
            switch (pressedButton.getId()){
                case R.id.TL:
                    if(turn == "X" && !finPartida()) {
                        celdas[0][0].setText("X");//escribe o sobre el boton
                        tablero[0][0] = 1;
                        turn = "O";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[0][0].setClickable(false);
                    }else if(turn == "O"){
                        celdas[0][0].setText("O");//escribe o sobre el boton
                        tablero[0][0] = 0;
                        turn = "X";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[0][0].setClickable(false);
                    }
                    break;
                case R.id.TC:
                    if(turn == "X" && !finPartida()) {
                        celdas[0][1].setText("X");//escribe o sobre el boton
                        tablero[0][1] = 1;
                        turn = "O";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[0][1].setClickable(false);
                    }else if(turn == "O" && !finPartida()){
                        celdas[0][1].setText("O");//escribe o sobre el boton
                        tablero[0][1] = 0;
                        turn = "X";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[0][1].setClickable(false);
                    }
                    break;
                case R.id.TR:
                    if(turn == "X" && !finPartida()) {
                        celdas[0][2].setText("X");//escribe o sobre el boton
                        tablero[0][2] = 1;
                        turn = "O";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[0][2].setClickable(false);
                    }else if(turn == "O" && !finPartida()){
                        celdas[0][2].setText("O");//escribe o sobre el boton
                        tablero[0][2] = 0;
                        turn = "X";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[0][2].setClickable(false);
                    }
                    break;
                case R.id.ML:
                    if(turn == "X" && !finPartida()) {
                        celdas[1][0].setText("X");//escribe o sobre el boton
                        tablero[1][0] = 1;
                        turn = "O";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[1][0].setClickable(false);
                    }else if(turn == "O" && !finPartida()){
                        celdas[1][0].setText("O");//escribe o sobre el boton
                        tablero[1][0] = 0;
                        turn = "X";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[1][0].setClickable(false);
                    }
                    break;
                case R.id.MC:
                    if(turn == "X" && !finPartida()) {
                        celdas[1][1].setText("X");//escribe o sobre el boton
                        tablero[1][1] = 1;
                        turn = "O";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[1][1].setClickable(false);
                    }else if(turn == "O" && !finPartida()){
                        celdas[1][1].setText("O");//escribe o sobre el boton
                        tablero[1][1] = 0;
                        turn = "X";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[1][1].setClickable(false);
                    }
                    break;
                case R.id.MR:
                    if(turn == "X" && !finPartida()) {
                        celdas[1][2].setText("X");//escribe o sobre el boton
                        tablero[1][2] = 1;
                        turn = "O";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[1][2].setClickable(false);
                    }else if(turn == "O" && !finPartida()){
                        celdas[1][2].setText("O");//escribe o sobre el boton
                        tablero[1][2] = 0;
                        turn = "X";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[1][2].setClickable(false);
                    }
                    break;
                case R.id.BL:
                    if(turn == "X" && !finPartida()) {
                        celdas[2][0].setText("X");//escribe o sobre el boton
                        tablero[2][0] = 1;
                        turn = "O";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[2][0].setClickable(false);
                    }else if(turn == "O" && !finPartida()){
                        celdas[2][0].setText("O");//escribe o sobre el boton
                        tablero[2][0] = 0;
                        turn = "X";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[2][0].setClickable(false);
                    }
                    break;
                case R.id.BC:
                    if(turn == "X" && !finPartida()) {
                        celdas[2][1].setText("X");//escribe o sobre el boton
                        tablero[2][1] = 1;
                        turn = "O";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[2][1].setClickable(false);
                    }else if(turn == "O" && !finPartida()){
                        celdas[2][1].setText("O");//escribe o sobre el boton
                        tablero[2][1] = 0;
                        turn = "X";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[2][1].setClickable(false);
                    }
                    break;
                case R.id.BR:
                    if(turn == "X" && !finPartida()) {
                        celdas[2][2].setText("X");//escribe o sobre el boton
                        tablero[2][2] = 1;
                        turn = "O";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[2][2].setClickable(false);
                    }else if(turn == "O" && !finPartida()){
                        celdas[2][2].setText("O");//escribe o sobre el boton
                        tablero[2][2] = 0;
                        turn = "X";
                        //Vista_actualiza();
                        Ganador = QuienGana();
                        Mostrar_mensaje();
                        celdas[2][2].setClickable(false);
                    }
                    break;
            }
            /**REVISANDO SI LAS CELDAS DEL JUEGO SON PRESIONADAS*/
        }
    };

    public int QuienGana()//METODO QUE REGRESA -1 SI GANA LA O 0 Y SI GANA LA X 1
    {
        if (tablero[0][0]!=-1 && tablero[0][0]==tablero[1][1] && tablero[0][0]==tablero[2][2])//viendo quien gana en las diagonales
            return tablero[0][0];
        if (tablero[0][2]!=-1 && tablero[0][2]==tablero[1][1] && tablero[0][2]==tablero[2][0])//viendo quien gana en las diagonales
            return tablero[0][2];
        for (int i=0;i<3;i++)
        {
            if(tablero[i][0]!=-1 && tablero[i][0]==tablero[i][1] && tablero[i][0]==tablero[i][2])//viendo quien gana en las columanas
                return tablero[i][0];

            if(tablero[0][i]!=-1 && tablero[0][i]==tablero[1][i] && tablero[0][i]==tablero[2][i])//viendo quien gana en las filas.
                return tablero[0][i];
        }
        return -1;//indicando que nadie ha ganado
    }

    public void Mostrar_mensaje()//metodo que muetra el mensaje de ganador perdedor o empate
    {
        TextView Resultado = (TextView) findViewById(R.id.Resultado);
        if (Ganador==0)
            Resultado.setText("Jugador O ha Ganado");
        else if (Ganador==1)
            Resultado.setText("Jugador X ha Ganado");
        else if (Ganador==-1 && finPartida())
            Resultado.setText("Empate");
        else if (Ganador==-1)
            Resultado.setText(" ");
    }

    public boolean Tablero_lleno()//METODO QUE REVISA SITODO EL TABLERO ESTA LLENO
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(tablero[i][j]==-1)
                    return false;
        return true;
    }

    public boolean finPartida()//Meotodo que me  indica si acabo la partida
    {
        return Tablero_lleno() || QuienGana()!=-1;//cuando el tablero esta lleno o alguien ha ganado la partida
    }
}
