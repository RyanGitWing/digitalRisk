import java.util.HashMap;

/**
 * Utilitarian class used to get the bonus armies a player gets at every turn.
 *
 * @author Fareen. L
 * @version 11.23.2020
 *
 * @author Fareen. L
 * @version 12.08.2020
 */
public abstract class BonusArmy {

    private static HashMap<String, Integer> bonuses;

    public static void setupBonus(HashMap<String, Integer> bonuses) {
        BonusArmy.bonuses = bonuses;
    }

    /**
     * Returns the amount of bonus armies a player gets if they own a whole continent.
     *
     * @param continentName The name of the continent the player owns.
     * @return The bonus army received for owning the specified continent.
     */
    public static int continentBonus(String continentName) {
        return bonuses.get(continentName);
    }

    /**
     * Calculates general bonus allotted to each player per turn.
     *
     * @param countryCount The total number of countries a player owns.
     * @return The bonus armies a player receives per turn.
     */
    public static int generalBonus(int countryCount) {
        int bonus = countryCount / 3;
        if (bonus > 3) { return bonus; }
        return 3;
    }
}
