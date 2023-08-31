package com.example.guesstheceleb;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.guesstheceleb.game.Difficulty;

import java.util.Locale;

public class GameFragment extends Fragment {

    private Difficulty level;
    private StateListener listener;
    public Difficulty getLevel() {return level;}

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (StateListener) context;
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_game, container, false);
        final Spinner spinner = view.findViewById(R.id.difficulty);
        final TextView currentLevel = view.findViewById(R.id.current_level);

        view.findViewById(R.id.play).setOnClickListener((v) -> {
            String selection = spinner.getSelectedItem().toString();
            Log.i("GameFragment", "selection: " + selection);
            level = Difficulty.valueOf(selection.toUpperCase());
            currentLevel.setText(String.format(Locale.getDefault(), "Level: %s", level));
            listener.onUpdate(State.START_GAME);
        });

        return view;
    }
}