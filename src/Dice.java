import java.util.Random;
/**
 * @author Ryan Nguyen
 * @version 10.25.2020
 *
 * @author Fareen. L
 * @version 11.08.2020
 */
public class Dice {

    private int value;

    /**
     * Creates a dice object.
     */
    public Dice() {
        Random num = new Random();
        this.value = num.nextInt(6) + 1;
    }

    /**
     * Get the value of the dice.
     *
     * @return The value of the dice.
     */
    public int getValue() { return this.value; }

    /**
     * Rolls the dice
     */
    public void rollDice() {
        Random num = new Random();
        this.value = num.nextInt(6) + 1;
    }
}
