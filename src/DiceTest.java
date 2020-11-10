import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for the Dice class.
 *
 * @author Fareen. L
 * @version 11.09.2020
 */
public class DiceTest {

    Dice dice;

    @Before
    public void setUp() throws Exception {
        dice = new Dice();
    }

    @After
    public void tearDown() throws Exception {
        dice = null;
        assertEquals(null, dice);
    }

    @Test
    public void getValue() {
        // act and assert
        assertNotNull(dice.getValue());
    }

    @Test
    public void rollDice() {
        // setup
        dice.rollDice();

        // act and assert
        assertTrue(dice.getValue() > -1 && dice.getValue() < 7);
    }
}