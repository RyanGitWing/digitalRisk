import org.junit.Assert;
import org.junit.Test;

/**
 * Tests for Player class.
 *
 * @author Fareen Lavji
 * @version 11.08.2020
 */
public class PlayerTest {

    @Test
    public void getArmyCount() {
        Player player = new Player("Player");
        Assert.assertEquals(0, player.getArmyCount());
    }

    @Test
    public void setArmyCount() {
        Player player = new Player("Player");
        player.setArmyCount(5);
        Assert.assertEquals(5, player.getArmyCount());
    }

    @Test
    public void getName() {
        Player player = new Player("Player");
        Assert.assertEquals("Player", player.getName());
    }

    @Test
    public void getPlayerTurn() {
        Player player = new Player("Player");
        Assert.assertEquals(null, player.getPlayerTurn());
    }

    @Test
    public void getOwnedCountries() {
        Player player = new Player("Player");
        Assert.assertEquals(0, player.getOwnedCountries().size());
    }

    @org.junit.Test
    public void addNewCountry() {
        Player player = new Player("Player");
        player.addNewCountry(new Country(CountryName.SouthernEurope));
        player.addNewCountry(new Country(CountryName.China));
        Assert.assertEquals(2, player.getOwnedCountries().size());
    }
}