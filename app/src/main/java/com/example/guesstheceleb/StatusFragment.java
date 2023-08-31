package com.example.guesstheceleb;

import android.content.Context;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

public class StatusFragment extends Fragment {

    private TextView message;
    private TextView score;
    private StateListener listener;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_status, container, false);

        message = view.findViewById(R.id.message);
        score = view.findViewById(R.id.score);

        return view;
    }

    public void setMessage(String text) {
        message.setText(text);
    }

    public void setScore(String text) {
        score.setText(text);
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (StateListener) context;
    }
}
