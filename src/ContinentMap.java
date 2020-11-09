/**
 *  ContinentMap Class

 * @author Vis Kirubakaran
 * @version: 10.25.2020
 *
 * @author Fareen. L
 * @version 11.08.2020
 */

public class ContinentMap
{
    private CountryMap countryMap;
    private Continent continent;

    public ContinentMap ()
    {
        countryMap = new CountryMap();
    }

    /**
     * setUpContinent(continentName) takes an enum input and uses that along with the private variable continent of type
     * Continent and countryMap of type CountryMap. countryMap will be used to call CountryMap's method AdjacentCountry
     * for each Continent Name abbrieviation which will return a Country class object with each call to that AdjCountry
     * method. Each country returned is returned to the proper continent using an if statement, as seen below
     *
     * @param continentName
     * @return continent
     */

    public Continent setUpContinent (ContinentName continentName)
    {
        continent = new Continent(continentName);

        if (continentName == ContinentName.NorthAmerica)
        {
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.CentralAmerica));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.EasternUS));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Greenland));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.NorthwestTerritories));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.CentralCanada));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.EasternCanada));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.WesternUS));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Alaska));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.WesternCanada));
            countryMap = new CountryMap();
            return continent;
        }
        if (continentName == ContinentName.SouthAmerica)
        {
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Argentina));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Brazil));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Peru));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Venezuela));
            countryMap = new CountryMap();
            return continent;
        }
        if (continentName == ContinentName.Europe)
        {
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.GreatBritain));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Iceland));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.NorthernEurope));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Scandinavia));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.SouthernEurope));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Ukraine));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.WesternEurope));
            countryMap = new CountryMap();
            return continent;
        }
        if (continentName == ContinentName.Africa)
        {
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Congo));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.EastAfrica));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Egypt));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Madagascar));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.NorthAfrica));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.SouthAfrica));
            countryMap = new CountryMap();
            return continent;
        }
        if (continentName == ContinentName.Asia)
        {
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Afghanistan));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.China));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.India));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Irkutsk));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Japan));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Kamchatka));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.MiddleEast));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Mongolia));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Siam));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Siberia));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Ural));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Yakutsk));
            countryMap = new CountryMap();
            return continent;
        }
        if (continentName == ContinentName.Australia)
        {
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.EasternAustralia));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.Indonesia));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.NewGuinea));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.SetAdjacentCountries(CountryName.WesternAustralia));
            countryMap = new CountryMap();
            return continent;
        }
        else return null;
    }
}