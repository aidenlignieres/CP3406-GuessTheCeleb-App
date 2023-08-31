package com.example.guesstheceleb;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.util.Log;

import com.example.guesstheceleb.game.CelebrityManager;
import com.example.guesstheceleb.game.Difficulty;
import com.example.guesstheceleb.game.Game;
import com.example.guesstheceleb.game.GameBuilder;

import java.util.Locale;

public class MainActivity extends AppCompatActivity implements StateListener{
    private GameFragment gameFragment;
    private StatusFragment statusFragment;
    private QuestionFragment questionFragment;
    private boolean isLargeScreen;
    GameBuilder gameBuilder = new GameBuilder(null);


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        FragmentManager fragmentManager = getSupportFragmentManager();
        gameFragment = (GameFragment) fragmentManager.findFragmentById(R.id.game);
        statusFragment = (StatusFragment) fragmentManager.findFragmentById(R.id.status);
        questionFragment = (QuestionFragment) fragmentManager.findFragmentById(R.id.question);
        isLargeScreen = statusFragment != null;
    }

    @Override
    public void onUpdate(State state) {
        Difficulty level = gameFragment.getLevel();
        String text = String.format(Locale.getDefault(), "state: %s level: %s", state, level);
        Log.i("MainActivity", text);

        if (isLargeScreen) {
            switch (state) {
                case START_GAME:
                    Game game = gameBuilder.create(level);
                    questionFragment.setGame(game);
            }
        }
    }
}