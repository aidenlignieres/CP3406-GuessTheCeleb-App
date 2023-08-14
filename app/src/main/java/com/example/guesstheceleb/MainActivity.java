package com.example.guesstheceleb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ImageManager imageManager = new ImageManager(this.getAssets(), "celebs");
        ImageView imageView = findViewById(R.id.image);
        imageView.setImageBitmap(imageManager.get(0));
        
//        AssetManager manager = getAssets();
//        try {
//            String[] names = manager.list("celebs");
//            Log.d("celebs",Arrays.toString(names));
//
//            ImageView imageView = findViewById(R.id.image);
//
//            InputStream stream = manager.open("celebs/" + names[0]);
//            Bitmap bitmap = BitmapFactory.decodeStream(stream);
//
//            imageView.setImageBitmap(bitmap);
//        } catch (IOException e) {
//            Log.d("TAG","Failed to get names");
//        }
    }
}