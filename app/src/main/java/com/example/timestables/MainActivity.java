package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int timer;
    ArrayList<Integer> numbers = new ArrayList<Integer>();




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* seekBar values */

        int step = 1;
        int min = 1;
        int max = 9;

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax((max-min)/step);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("seekBar changed", Integer.toString(i));
                timer = i;
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

        /* number list */

        for (int i = 1; i <= 9; i++) {
            numbers.add(i);

        }


    }
}