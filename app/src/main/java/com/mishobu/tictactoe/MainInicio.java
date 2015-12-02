package com.mishobu.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainInicio extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.inicio_main);
    }

    public void goConfig(View view) {
        Intent intent = new Intent(MainInicio.this, MainConfig.class);
        startActivity(intent);
    }

    public void startPvP(View view) {
        Intent intent = new Intent(MainInicio.this, MainActivity.class);
        startActivity(intent);
    }
}