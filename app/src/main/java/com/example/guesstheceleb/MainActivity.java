package com.example.guesstheceleb;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.AssetManager;
import android.os.Bundle;
import android.util.Log;

import java.io.IOException;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        AssetManager manager = getAssets();
        try {
            String[] names = manager.list("celebs");
            Log.d("celebs",Arrays.toString(names));
        } catch (IOException e) {
            Log.d("TAG","Failed to get names");
        }
    }
}