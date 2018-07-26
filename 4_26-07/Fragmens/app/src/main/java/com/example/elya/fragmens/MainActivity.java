package com.example.elya.fragmens;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity implements FragmentSendMessage.FragmentAListener {
    private FragmentGetMessage fragmentGetMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentSendMessage fragmentSendMessage = new FragmentSendMessage();
        fragmentGetMessage = new FragmentGetMessage();

        getSupportFragmentManager().beginTransaction()
                .replace(R.id.container_a, fragmentSendMessage)
                .replace(R.id.container_b, fragmentGetMessage)
                .commit();
    }

    @Override
    public void onInputASent(CharSequence input) {
        fragmentGetMessage.updateEditText(input);
    }
}
