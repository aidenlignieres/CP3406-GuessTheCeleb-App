package com.example.guesstheceleb.game;

public class Game {
    private Question[] questions;
    private int currentQuestionIndex;
    private int score;

    public Game(Question[] questions) {
        this.questions = questions;
        this.currentQuestionIndex = 0;
        this.score = 0;
    }

    public Question next() {
        if (currentQuestionIndex < questions.length) {
            return questions[currentQuestionIndex++];
        }
        return null;
    }

    public boolean isGameOver() {
        return currentQuestionIndex >= questions.length;
    }

    public void updateScore(boolean isCorrect) {
        if (isCorrect) {
            score++;
        }
    }

    public String getScore() {
        return "Score: " + score + "/" + questions.length;
    }

    public int count() {
        return questions.length;
    }
}
