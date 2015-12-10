package com.mishobu.tictactoe;

import android.app.Activity;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import java.util.Random;

public class Relax extends Activity {

    private Random rnd = new Random();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.relax_main);

        ImageView sound = (ImageView) findViewById(R.id.kittens);
        sound.setOnClickListener(new View.OnClickListener() {

                                     final int[] btns = new int[]{R.raw.cat1, R.raw.cat2, R.raw.cat3, R.raw.cat4, R.raw.cat5, R.raw.cat6,
                                             R.raw.cat7, R.raw.cat8, R.raw.cat9, R.raw.cat10, R.raw.cat11, R.raw.cat12, R.raw.cat13,
                                             R.raw.cat14, R.raw.cat15, R.raw.cat16, R.raw.cat17,
                                     };


                                     int sndToPlay = rnd.nextInt(btns.length);
                                     final MediaPlayer mp = MediaPlayer.create(Relax.this, btns[sndToPlay]);
                                     @Override
                                     public void onClick(View v) {
                                         mp.start();
                                     }}
        );
    }
}