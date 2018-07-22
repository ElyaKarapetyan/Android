package com.example.elya.myfirstapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private LinearLayout changedScrin;
    private SeekBar redSeek;
    private SeekBar blueSeek;
    private SeekBar greenSeek;
    private TextView redText;
    private TextView blueText;
    private TextView greenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changedScrin = findViewById(R.id.changeColorLayout);
        redSeek = findViewById(R.id.redSeekBar);
        blueSeek = findViewById(R.id.blueSeekBar);
        greenSeek = findViewById(R.id.greenSeekBar);
        redText =  findViewById(R.id.redText);
        blueText = findViewById(R.id.blueText);
        greenText = findViewById(R.id.greenText);
        changeBackground();
        redSeek.setOnSeekBarChangeListener(seekBarChangeListener);
        greenSeek.setOnSeekBarChangeListener(seekBarChangeListener);
        blueSeek.setOnSeekBarChangeListener(seekBarChangeListener);

    }

    private SeekBar.OnSeekBarChangeListener seekBarChangeListener
            = new SeekBar.OnSeekBarChangeListener()
    {

        @Override
        public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
            changeBackground();
        }
        @Override
        public void onStartTrackingTouch(SeekBar seekBar) {
        }

        @Override
        public void onStopTrackingTouch(SeekBar seekBar) {
        }
    };

    private void changeBackground() {
        int redValue = redSeek.getProgress();
        int blueValue = blueSeek.getProgress();
        int greenValue = greenSeek.getProgress();
        changedScrin.setBackgroundColor(Color.rgb(redValue, blueValue, greenValue));
        redText.setText(String.valueOf(redValue));
        blueText.setText(String.valueOf(blueValue));
        greenText.setText(String.valueOf(greenValue));
    }
}
