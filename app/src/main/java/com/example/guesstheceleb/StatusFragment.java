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

    private static final String PARAMETER1 = "param1";
    private static final String PARAMETER2 = "param2";

    private String mParam1;
    private String mParam2;

    private TextView message;
    private TextView score;

    public StatusFragment() {
        // Required empty public constructor
    }

    public static StatusFragment newInstance(String param1, String param2) {
        StatusFragment fragment = new StatusFragment();
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

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
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
        message.setText(text);
    }

    private StateListener listener;

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        listener = (StateListener) context;
    }
}