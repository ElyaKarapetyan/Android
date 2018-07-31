package com.example.student.searchuser;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.ImageView;
import android.widget.MediaController;
import android.widget.VideoView;

import com.squareup.picasso.Picasso;

public class ScrollingActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scrolling);
        Toolbar toolbar = findViewById(R.id.toolbar);

        final int userPosition = getIntent().getIntExtra(MyAdapter.KEY, -1);
        toolbar.setTitle(DataProvider.users.get(userPosition).getName());
        setSupportActionBar(toolbar);

        ImageView imageView = findViewById(R.id.img);
        Picasso.get().load(DataProvider.users.get(userPosition).getImageUrl().get(0)).into(imageView);

//        VideoView videoView = findViewById(R.id.video);
//        MediaController mediaController = new MediaController(this);
//        mediaController.setAnchorView(videoView);
//        videoView.setMediaController(mediaController);
//        videoView.setVideoURI(Uri.parse("https://www.youtube.com/watch?v=V3rFryvsHts&feature=youtu.be"));
//        videoView.start();

        FloatingActionButton fabEmail = findViewById(R.id.fabMail);
        clickMailFlotingBtn(userPosition, fabEmail);

        FloatingActionButton fabPhone = findViewById(R.id.fabPhone);
        clickPhoneFlotingBtn(userPosition, fabPhone);
    }

    private void clickPhoneFlotingBtn(final int userPosition, FloatingActionButton fabPhone) {
        fabPhone.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_DIAL);
                intent.setData(Uri.parse(DataProvider.users.get(userPosition).getPhoneNumber()));
                startActivity(intent);
            }
        });
    }

    private void clickMailFlotingBtn(final int userPosition, FloatingActionButton fabEmail) {
        fabEmail.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.setData(Uri.parse("mailto:"));
                intent.setType("text/plain");
                intent.putExtra(Intent.EXTRA_EMAIL, DataProvider.users.get(userPosition).getEmailAddress());
                startActivity(intent);
            }
        });
    }
}
