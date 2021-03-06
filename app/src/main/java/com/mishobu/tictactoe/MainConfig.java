package com.mishobu.tictactoe;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

public class MainConfig extends Activity {
    private RadioGroup Difficulty, Shot;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.config_main);

        Difficulty = (RadioGroup) findViewById(R.id.Difficulty);
        Shot = (RadioGroup) findViewById(R.id.Shot);
        Difficulty.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(RadioGroup group, int checkedId) {
                // find which radio button is selected
                if(checkedId == R.id.Easy) {
                    Shot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedSh) {
                            // find which radio button is selected
                            if (checkedSh == R.id.Player) {
                            } else {
                            }
                        }
                    });
                } else if(checkedId == R.id.Normal) {
                    Shot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedSh) {
                            // find which radio button is selected
                            if (checkedSh == R.id.Player) {
                            } else {
                            }
                        }
                    });
                } else {
                    Shot.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
                        @Override
                        public void onCheckedChanged(RadioGroup group, int checkedSh) {
                            // find which radio button is selected
                            if (checkedSh == R.id.Player) {
                            } else {
                            }
                        }
                    });
                }
            }
        });
    }

        public void startPvE(View v) {
            RadioButton Easy = (RadioButton) findViewById(R.id.Easy);
            RadioButton Normal = (RadioButton) findViewById(R.id.Normal);
            RadioButton Hard = (RadioButton) findViewById(R.id.Hard);
            RadioButton Player = (RadioButton) findViewById(R.id.Player);
            RadioButton AI = (RadioButton) findViewById(R.id.AI);
            int checkedId = Difficulty.getCheckedRadioButtonId();
            int checkedSh = Shot.getCheckedRadioButtonId();
            // find which radioButton is checked by id
            if(checkedId == Easy.getId() && checkedSh == Player.getId()) {
                Intent intent = new Intent(MainConfig.this, Easy.class);
                startActivity(intent);
            } else if(checkedId == Normal.getId() && checkedSh == Player.getId()) {
                Intent intent = new Intent(MainConfig.this, Normal.class);
                startActivity(intent);
            } else if(checkedId == Hard.getId() && checkedSh == Player.getId()){
                Intent intent = new Intent(MainConfig.this, Hard.class);
                startActivity(intent);
            } else if(checkedId == Easy.getId() && checkedSh == AI.getId()) {
                Intent intent = new Intent(MainConfig.this, EasyAI.class);
                startActivity(intent);
            } else if(checkedId == Normal.getId() && checkedSh == AI.getId()){
                Intent intent = new Intent(MainConfig.this, NormalAI.class);
                startActivity(intent);
            } else if(checkedId == Hard.getId() && checkedSh == AI.getId()) {
                /*Toast.makeText(getApplicationContext(), "choice: Hard+AI",
                        Toast.LENGTH_SHORT).show();*/
                Intent intent = new Intent(MainConfig.this, HardAI.class);
                startActivity(intent);
        }
  }
}