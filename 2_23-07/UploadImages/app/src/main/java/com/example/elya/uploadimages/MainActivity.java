package com.example.elya.uploadimages;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private  ImageView image;
    private Button uploadFromDrawable;
    private Button uploadFromGallery;
    private Button uploadFromUrl;
    private Bitmap bmp;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        image = findViewById(R.id.image);
        image.setImageResource(R.drawable.ic_image);

        uploadFromDrawable = findViewById(R.id.fromDrawableBtn);
        uploadFromGallery = findViewById(R.id.fromGalleryBtn);
        uploadFromUrl = findViewById(R.id.fromUrlBtn);

        uploadFromDrawable.setText("Upload1");
        uploadFromGallery.setText("Upload2");
        uploadFromUrl.setText("Upload3");

        uploadFromDrawable.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                image.setImageResource(R.drawable.ic_smile);
            }
        });

        uploadFromGallery.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openGallery();
            }
        });
    }

    private void openGallery()
    {
        Intent photoPickerIntent = new Intent(Intent.ACTION_GET_CONTENT);
        photoPickerIntent.setType("image/*");
        startActivityForResult(photoPickerIntent, 1);
    }

    @Override
    protected void onActivityResult(int requestCode, int resultcode, Intent intent)
    {
        super.onActivityResult(requestCode, resultcode, intent);

        if (requestCode == 1)
        {
            if (intent != null && resultcode == RESULT_OK)
            {

                Uri selectedImage = intent.getData();

                String[] filePathColumn = {MediaStore.Images.Media.DATA};
                Cursor cursor = getContentResolver().query(selectedImage, filePathColumn, null, null, null);
                cursor.moveToFirst();
                int columnIndex = cursor.getColumnIndex(filePathColumn[0]);
                String filePath = cursor.getString(columnIndex);
                cursor.close();

                if(bmp != null && !bmp.isRecycled())
                {
                    bmp = null;
                }

                bmp = BitmapFactory.decodeFile(filePath);
                image.setBackgroundResource(0);
                image.setImageBitmap(bmp);
            }
            else
            {
                Log.d("Status:", "Photopicker canceled");
            }
        }
    }
}
