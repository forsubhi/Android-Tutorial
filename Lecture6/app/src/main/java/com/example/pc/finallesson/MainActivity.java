package com.example.pc.finallesson;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.v4.graphics.BitmapCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.Toast;

import java.io.File;

public class MainActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private static final int CAMERA_REQUEST_Full_Sized = 1889;
    ImageView image;
    File photo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        image = (ImageView) findViewById(R.id.image);
        findViewById(R.id.takePhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            }
        });

        findViewById(R.id.takeFullSizedPhoto).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    // place where to store camera taken picture
                    photo = createFile();

                } catch (Exception e) {

                    e.printStackTrace();
                }
                Uri mImageUri = Uri.fromFile(photo);
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                cameraIntent.putExtra(MediaStore.EXTRA_OUTPUT, mImageUri);
                startActivityForResult(cameraIntent, CAMERA_REQUEST_Full_Sized);
            }
        });
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK) {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            image.setImageBitmap(photo);
            int bitmapByteCount = BitmapCompat.getAllocationByteCount(photo);
            Toast.makeText(MainActivity.this, "size=" + bitmapByteCount, Toast.LENGTH_LONG).show();
        } else if (requestCode == CAMERA_REQUEST_Full_Sized && resultCode == Activity.RESULT_OK) {
            Bitmap fullsize = BitmapFactory.decodeFile(photo.getAbsolutePath());//here is the bitmap of image full size
            image.setImageBitmap(fullsize);
            int bitmapByteCount = BitmapCompat.getAllocationByteCount(fullsize);
            Toast.makeText(MainActivity.this, "size=" + bitmapByteCount, Toast.LENGTH_LONG).show();

        }
    }


    private File createFile() throws Exception {
        File externalStorageDirectory = Environment.getExternalStorageDirectory();
        File directory = new File(externalStorageDirectory.getAbsolutePath() + "/images/");
        if (!directory.exists()) {
            directory.mkdirs();
        }
        File file = new File(directory, "test.jpg");
        return file;
    }
}
