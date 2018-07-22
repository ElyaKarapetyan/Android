package com.example.elya.twoactivty;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    ImageView img;
    CheckBox check;
    Button firstButton;
    Button secondButton;
    EditText message;
    Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = (ImageView) findViewById(R.id.imgViewId);
        check = (CheckBox) findViewById(R.id.checkboxId);
        firstButton = (Button) findViewById(R.id.firstButtonId);
        secondButton = (Button) findViewById(R.id.secondButtonId);
        message =  (EditText) findViewById(R.id.messageId);
        saveButton = (Button) findViewById(R.id.saveButtonId);

        firstButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(R.drawable.first);
            }
        });
        secondButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                img.setImageResource(R.drawable.second);
            }
        });
    }
}
