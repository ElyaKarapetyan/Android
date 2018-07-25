package com.example.elya.urlexample;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.util.Log;
import android.util.Patterns;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button button = findViewById(R.id.button);
        TextView firstMessage = findViewById(R.id.message1);
        TextView secondMessage = findViewById(R.id.message2);

        firstMessage.setText("Enter url (e.g. https://www.google.com OR www.google.com)");
        secondMessage.setText("If you enter the invalid url, will open the google page");

        button.setOnClickListener(
                new View.OnClickListener()
                {
                    public void onClick(View view)
                    {
                        EditText url = findViewById(R.id.text);
                        String urlStr = String.valueOf(url.getText());
                        if (!urlStr.startsWith("http://") && !urlStr.startsWith("https://")) {
                            urlStr = "http://" + urlStr;
                        }
                        if (Patterns.WEB_URL.matcher(urlStr).matches()) {
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlStr));
                            startActivity(browserIntent);
                        } else {
                            urlStr = "https://www.google.com";
                            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(urlStr));
                            startActivity(browserIntent);
                        }

                    }
                });
    }
}
