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

public class MainActivity extends AppCompatActivity implements StateListener{
    private GameFragment gameFragment;
    private StatusFragment statusFragment;
    private QuestionFragment questionFragment;
    private boolean isLargeScreen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        gameFragment = (gameFragment) fragmentManager.findFragmentById(R.id.game);
        statusFragment = (statusFragment) fragmentManager.findFragmentById(R.id.status);
        questionFragment = (questionFragment) fragmentManager.findFragmentById(R.id.question);
        isLargeScreen = statusFragment != null;
    }

    @Override
    public void onUpdate(State state) {
        Log.i("MainActivity", "state:" + state);
    }
}