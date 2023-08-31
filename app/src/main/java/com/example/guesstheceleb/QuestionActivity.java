package com.example.guesstheceleb;

import android.os.Bundle;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

public class QuestionActivity extends AppCompatActivity implements StateListener {

    private StatusFragment statusFragment;
    private QuestionFragment questionFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_question);

        FragmentManager fragmentManager = getSupportFragmentManager();
        statusFragment = (StatusFragment) fragmentManager.findFragmentById(R.id.status_fragment);
        questionFragment = (QuestionFragment) fragmentManager.findFragmentById(R.id.question_fragment);
    }

    @Override
    public void onUpdate(State state) {
        switch (state) {
            case CONTINUE_GAME:
                statusFragment.setScore(questionFragment.getScore());
                break;

            case GAME_OVER:
                statusFragment.setScore(questionFragment.getScore());
                statusFragment.setMessage("GameOver!");
                break;
        }
    }
}


