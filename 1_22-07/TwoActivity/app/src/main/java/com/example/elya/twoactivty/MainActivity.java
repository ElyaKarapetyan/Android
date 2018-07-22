package com.example.elya.twoactivty;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView img;
    private CheckBox check;
    private Button firstButton;
    private Button secondButton;
    private EditText message;
    private Button saveButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        img = findViewById(R.id.imgViewId);
        check = findViewById(R.id.checkboxId);
        firstButton = findViewById(R.id.firstButtonId);
        secondButton = findViewById(R.id.secondButtonId);
        saveButton = findViewById(R.id.saveButtonId);

        check.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (check.isChecked()) {
                    img.setVisibility(View.VISIBLE);
                } else {
                    img.setVisibility(View.INVISIBLE);
                }
            }
        });
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
        saveButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendMessage(view);
            }
        });
    }

    public void sendMessage(View view) {
        Intent intent = new Intent(this, DisplayMessageActivity.class);
        message = findViewById(R.id.messageId);
        String messageTxt = message.getText().toString();
        intent.putExtra("com.example.elya.twoactivty",messageTxt);
        startActivity(intent);
    }
}
