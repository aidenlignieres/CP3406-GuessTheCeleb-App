package com.example.guesstheceleb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

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
    private GameFragment gameFragment;
    private StatusFragment statusFragment;
    private QuestionFragment questionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        gameFragment = (gameFragment) fragmentManager.findFragmentById(R.id.game);
        statusFragment = (statusFragment) fragmentManager.findFragmentById(R.id.status);
        questionFragment = (questionFragment) fragmentManager.findFragmentById(R.id.question);
        isLargeScreen = statusFragment != null;

//        ImageManager imageManager = new ImageManager(this.getAssets(), "celebs");
//        ImageView imageView = findViewById(R.id.image);
//        imageView.setImageBitmap(imageManager.get(0));
        
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