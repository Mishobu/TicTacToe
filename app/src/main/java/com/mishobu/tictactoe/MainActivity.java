package com.mishobu.tictactoe;

import android.app.Activity;
import android.graphics.Color;
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
    TextView Resultado = (TextView) findViewById(R.id.Resultado)// para generar texto del ganador
    int Ganador;// ganador es -1 cuando no ha ganado nadei, 0 yo gano y 1 gana la maquina

    public void init()
    {
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

        /**CREANDO EL AREA DE TEXTO GANADOR*/
        //pos = new Label("");
        //pos.reshape(310,100,200,20);
        //pos.setForeground(Color.white);
    }

    public void RestartGame(View v) {
        for (int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                celdas[i][j].setText("");//borramos el contenido de las celdas
                tablero[i][j]=-1;//inicializando todas las posiciones del tablero a menos uno
                botones_habilitados=true;
            }
        Ganador=-1;
    }

    private void O_juega(){//describiendo los eventos de cada boton
        /**REVISANDO SI LAS CELDAS DEL JUEGO SON PRESIONADAS*/
        if((celdas[0][0].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[0][0].setText("O");//escribe o sobre el boton
            celdas[0][0].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[0][0]=0;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[0][1].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[0][1].setText("O");//escribe o sobre el boton
            celdas[0][1].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[0][1]=0;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[0][2].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[0][2].setText("O");//escribe o sobre el boton
            celdas[0][2].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[0][2]=0;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[1][0].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[1][0].setText("O");//escribe o sobre el boton
            celdas[1][0].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[1][0]=0;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[1][1].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[1][1].setText("O");//escribe o sobre el boton
            celdas[1][1].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[1][1]=0;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[1][2].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[1][2].setText("O");//escribe o sobre el boton
            celdas[1][2].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[1][2]=0;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[2][0].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[2][0].setText("O");//escribe o sobre el boton
            celdas[2][0].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[2][0]=0;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[2][1].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[2][1].setText("O");//escribe o sobre el boton
            celdas[2][1].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[2][1]=0;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[2][2].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[2][2].setText("O");//escribe o sobre el boton
            celdas[2][2].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[2][2]=0;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
    }

    private void X_juega() {
        /**REVISANDO SI LAS CELDAS DEL JUEGO SON PRESIONADAS*/
        if((celdas[0][0].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[0][0].setText("X");//escribe o sobre el boton
            celdas[0][0].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[0][0]=1;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[0][1].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[0][1].setText("X");//escribe o sobre el boton
            celdas[0][1].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[0][1]=1;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[0][2].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[0][2].setText("X");//escribe o sobre el boton
            celdas[0][2].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[0][2]=1;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[1][0].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[1][0].setText("X");//escribe o sobre el boton
            celdas[1][0].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[1][0]=1;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[1][1].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[1][1].setText("X");//escribe o sobre el boton
            celdas[1][1].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[1][1]=1;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[1][2].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[1][2].setText("X");//escribe o sobre el boton
            celdas[1][2].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[1][2]=1;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[2][0].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[2][0].setText("X");//escribe o sobre el boton
            celdas[2][0].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[2][0]=1;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[2][1].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[2][1].setText("X");//escribe o sobre el boton
            celdas[2][1].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[2][1]=1;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
        else if((celdas[2][2].callOnClick()) && (celdas[0][0].getText().equals(""))  &&  (!finPartida()))//si el boton que se presiono fue una celda y esta vacio
        {
            celdas[2][2].setText("X");//escribe o sobre el boton
            celdas[2][2].setBackgroundColor(Color.rgb(0, 206, 209));
            tablero[2][2]=1;
            X_juega();
            Vista_actualiza();
            Ganador=QuienGana();
            Mostrar_mensaje();
        }
    }

    public int QuienGana()//METODO QUE REGRESA -1 SI GANA LA PERSONA 1 SI GANA EL ORDENADOR
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

    public int getGanador()//REGRESA EL VALOR DE LA VARIABLE Ganador
    {
        return Ganador;
    }

    public void Mostrar_mensaje()//metodo que muetra el mensaje de ganador perdedor o empate
    {
        if (Ganador==0)
            Resultado.setText("Jugador O ha Ganado");
        else if (Ganador==1)
            Resultado.setText("Jugador X ha Ganado");
        else if (Ganador==-1 && finPartida())
            Resultado.setText("Empate");
    }

    public boolean Tablero_lleno()//METODO QUE REVISA SI TODO EL TABLERO ESTA LLENO
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
                if(tablero[i][j]==-1)
                    return false;
        return true;
    }

    public void Vista_actualiza()//Actualiza la vista cada vez que la computadora tira
    {
        for(int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                if (tablero[i][j]==1) {
                    celdas[i][j].setText("X");
                    celdas[i][j].setForeground(Color.blue); }
                else if (tablero[i][j]==0){
                    celdas[i][j].setText("O");
                    celdas[i][j].setForeground(Color.red);}
                else celdas[i][j].setText("");
            }
    }

    public boolean finPartida()//Meotodo que me  indica si acabo la partida
    {
        return Tablero_lleno() || QuienGana()!=-1;//cuando el tablero esta lleno o alguien ha ganado la partida
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }


}
