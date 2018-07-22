package com.example.elya.myfirstapplication;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.LinearLayout;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout changedScrin;
    SeekBar redSeek;
    SeekBar blueSeek;
    SeekBar greenSeek;
    TextView redText;
    TextView blueText;
    TextView greenText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        changedScrin = (LinearLayout) findViewById(R.id.changeColorLayout);
        redSeek = (SeekBar) findViewById(R.id.redSeekBar);
        blueSeek = (SeekBar) findViewById(R.id.blueSeekBar);
        greenSeek = (SeekBar) findViewById(R.id.greenSeekBar);
        redText = (TextView) findViewById(R.id.redText);
        blueText = (TextView) findViewById(R.id.blueText);
        greenText = (TextView) findViewById(R.id.greenText);
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
