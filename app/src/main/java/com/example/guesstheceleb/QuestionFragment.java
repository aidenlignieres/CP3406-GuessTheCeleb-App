package com.example.guesstheceleb;

import android.content.Context;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.example.guesstheceleb.game.Game;
import com.example.guesstheceleb.game.Question;

public class QuestionFragment extends Fragment {
    private StateListener listener;
    private Game currentGame;

    public QuestionFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_question, container, false);

        // Setup your views, e.g., ImageView, GridView for answer options, etc.

        return view;
    }

    public void setGame(Game game) {
        currentGame = game;
        showNextQuestion(); // Show the first question
    }

    public String getScore() {
        return currentGame.getScore();
    }

    public void showNextQuestion() {
        // Logic to display the next question's image and answer options
        // You might need to use an adapter for your GridView
        Question nextQuestion = currentGame.next();
        if (nextQuestion != null) {
            // Update your UI elements with the new question
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (StateListener) context;
    }
}
