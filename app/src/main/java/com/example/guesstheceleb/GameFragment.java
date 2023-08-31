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

    private static final String PARAMETER1 = "param1";
    private static final String PARAMETER2 = "param2";

    private String mParam1;
    private String mParam2;

    private Difficulty level;

    public GameFragment() {
        // Required empty public constructor
    }

    public static GameFragment newInstance(String param1, String param2) {
        GameFragment fragment = new GameFragment();
        Bundle args = new Bundle();
        args.putString(PARAMETER1, param1);
        args.putString(PARAMETER2, param2);
        fragment.setArguments(args);
        return fragment;
    }
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(PARAMETER1);
            mParam2 = getArguments().getString(PARAMETER2);
        }
    }

    private StateListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (StateListener) context;
    }

    public Difficulty getLevel() {return level;}

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