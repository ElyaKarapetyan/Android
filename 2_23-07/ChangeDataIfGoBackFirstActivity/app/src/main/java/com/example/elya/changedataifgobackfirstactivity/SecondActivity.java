package com.example.elya.changedataifgobackfirstactivity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    EditText editText;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        editText = findViewById(R.id.editText);
        Button backBtn = findViewById(R.id.backBtton);
        backBtn.setText("Back");
        editText.setText(getIntent().getStringExtra(MainActivity.KEY));
        backBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent();
                intent.putExtra(MainActivity.KEY, editText.getText().toString());
                setResult(RESULT_OK, intent);
                finish();
            }
        });
    }
}
