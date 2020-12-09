/**
 * Utilitarian class used to get the bonus armies a player gets at every turn.
 *
 * @author Fareen. L
 * @version 11.23.2020
 *
 * @author Fareen. L
 * @version 12.07.2020
 */
public abstract class BonusArmy {

    /**
     * Returns the amount of bonus armies a player gets if they own a whole continent.
     *
     * @param continentName The name of the continent the player owns.
     * @return The bonus army received for owning the specified continent.
     */
    public static int continentBonus(String continentName) {
        switch (continentName) {
            case "Asia":
                return 7;
            case "Europe":
                return 5;
            case "Africa":
                return 3;
            case "Australia":
                return 2;
            case "NorthAmerica":
                return 5;
            case "SouthAmerica":
                return 2;
        }
        return 0;
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
