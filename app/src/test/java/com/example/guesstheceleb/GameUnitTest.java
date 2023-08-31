package com.example.guesstheceleb;

import org.junit.Test;

import static org.junit.Assert.*;

import com.example.guesstheceleb.game.Game;
import com.example.guesstheceleb.game.Question;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class GameUnitTest {
    @Test
    public void addition_isCorrect() {
        assertEquals(4, 2 + 2);
    }

    @Test
    public void testQuestionCheckMethod() {
        Question question = new Question("bob", null, new String[]{"bob", "jane", "harry"});

        assertTrue(question.check("bob")); // Correct guess
        assertFalse(question.check("jane")); // Incorrect guess
        assertFalse(question.check("harry")); // Incorrect guess
    }

    @Test
    public void testGame() {
        Question[] questions = new Question[3];
        String[] answers = new String[]{"bob", "jane", "harry"};
        for (int i = 0; i < 3; ++i) {
            questions[i] = new Question(answers[i], null, answers);
        }
        Game game = new Game(questions);

        while (!game.isGameOver()) {
            Question question = game.next();
            game.updateScore(question.check("bob"));
        }
        assertEquals("Score: 1/3", game.getScore());
    }
}