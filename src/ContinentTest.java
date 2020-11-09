import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Tests for Continent class.
 *
 * @author Fareen. L
 * @version 11.09.2020
 */
public class ContinentTest {

    Continent continent;

    @Before
    public void setUp() throws Exception {
        continent = new Continent(ContinentName.Africa);
    }

    @After
    public void tearDown() throws Exception {
        continent = null;
        assertNull(continent);
    }

    @Test
    public void getName() {
        // act and assert
        assertEquals(ContinentName.Africa, continent.getName());
    }

    @Test
    public void getContinentEmpty() {
        // act and assert
        assertEquals(0, continent.getCountries().size());
    }

    @Test
    public void addCountry() {
        // setup
        continent.addCountry(new Country(CountryName.SouthernEurope));

        // act and assert
        assertEquals(1, continent.getCountries().size());
        assertEquals(CountryName.SouthernEurope, continent.getCountries().get(0).getCountryName());
    }
}