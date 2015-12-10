package com.mishobu.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Relax extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ImageView Kitties = (ImageView) findViewById(R.id.kittens);

        for (int i=0;i<3;i++)
            for(int j=0;j<3;j++)
            {
                Kitties.setClickable(true);
                Kitties.setOnClickListener(clickListener);
            }
    }

    View.OnClickListener clickListener = new View.OnClickListener() {
        public void onClick(View v) {
            ImageView pressedButton = (ImageView) v;
        }
    };
}
