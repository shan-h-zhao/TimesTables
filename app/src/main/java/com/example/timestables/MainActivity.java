package com.example.timestables;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    int timer;
    ArrayList<Integer> baseNumbers = new ArrayList<Integer>();
    ArrayList<Integer> numbers = new ArrayList<Integer>();
    ListView listView;

    public void generateTimesTable (int timer) {
        numbers.clear();
        for (int j = 0; j <= 8; j++) {
            numbers.add(baseNumbers.get(j) * timer);
        }
        ArrayAdapter<Integer> arrayAdapter = new ArrayAdapter<Integer>(this, android.R.layout.simple_list_item_1, numbers);
        listView.setAdapter(arrayAdapter);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /* number list */

        listView = findViewById(R.id.listView);
        for (int i = 1; i <= 9; i++) {
            baseNumbers.add(i);
        }

        generateTimesTable (1);

        /* seekBar values */

        int step = 1;
        int min = 1;
        int max = 9;

        SeekBar seekBar = findViewById(R.id.seekBar);
        seekBar.setMax((max-min)/step);
        seekBar.setProgress(0);

        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                Log.i("seekBar changed", Integer.toString(i));
                timer = i+1;
                generateTimesTable(timer);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }
}