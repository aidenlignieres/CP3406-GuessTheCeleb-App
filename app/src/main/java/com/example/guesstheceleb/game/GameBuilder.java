package com.example.guesstheceleb.game;

import android.graphics.Bitmap;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

public class GameBuilder {
    public static Game create(CelebrityManager.Difficulty difficulty, CelebrityManager celebrityManager) {
        int numQuestions = 0;
        switch (difficulty) {
            case EASY:
                numQuestions = 3;
                break;
            case MEDIUM:
                numQuestions = 6;
                break;
            case HARD:
                numQuestions = 12;
                break;
            case EXPERT:
                numQuestions = 24;
                break;
        }

        String[] allCelebrities = celebrityManager.getAllNames();
        List<String> possibleNamesList = new ArrayList<>(allCelebrities.length);
        Collections.addAll(possibleNamesList, allCelebrities);

        Random random = new Random();
        List<String> selectedCelebrities = new ArrayList<>(numQuestions);
        for (int i = 0; i < numQuestions; ++i) {
            int randomIndex = random.nextInt(possibleNamesList.size());
            selectedCelebrities.add(possibleNamesList.remove(randomIndex));
        }

        Question[] questions = new Question[numQuestions];
        for (int i = 0; i < numQuestions; ++i) {
            String correctName = selectedCelebrities.get(i);
            String[] possibleNames = selectedCelebrities.toArray(new String[0]);
            Bitmap correctImage = celebrityManager.getByName(correctName);

            questions[i] = new Question(correctName, correctImage, possibleNames);
        }

        return new Game(questions);
    }
}

