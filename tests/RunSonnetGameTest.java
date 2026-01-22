import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class RunSonnetGameTest {
    private RunSonnetGame game;

    @BeforeEach
    void setUp() {
        game = new RunSonnetGame();
    }

    @Test
    void convertStringToArray() {
        String testString = "I got rejected";
        String[] result = game.convertStringToArray(testString);

        assertEquals(3, result.length);
        assertEquals("I", result[0]);
        assertEquals("got", result[1]);
        assertEquals("rejected", result[2]);
    }

    @Test
    void getRandomIndex() {
        int initialIndex = game.getCurrentIndex();
        game.randomize();
        int newIndex = game.getCurrentIndex();

        assertNotEquals(initialIndex, newIndex);
        assertTrue(newIndex >= 0);
    }

    @Test
    void makeSonnetSubstring() {
        game.getRandomIndex();
        int index = game.getCurrentIndex();

        game.makeSonnetSubstring();
        String[] subString = game.getSonnetSubstring();

        assertNotNull(subString);
        assertEquals(index, subString.length);
    }

    @Test
    void randomize() {
        game.randomize();
        String[] subString = game.getSonnetSubstring();

        assertNotNull(subString);

        int currentIndex = game.getCurrentIndex();
        assertTrue(currentIndex >= 0);

        assertEquals(currentIndex, subString.length);
    }

    @Test
    void getSonnetSubstring() {
        game.makeSonnetSubstring();
        assertNotNull(game.getSonnetSubstring());
    }
}