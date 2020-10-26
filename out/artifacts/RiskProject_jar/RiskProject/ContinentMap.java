/**
 *  ContinentMap Class
 *
 *  Methods:
 *  setUpContinent(continentName)
 *
 *
 * @author Vis Kirubakaran
 * @version: 10.25.2020
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
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.CentralAmerica));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.EasternUS));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.Greenland));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.NorthwestTerritories));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.CentralCanada));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.EasternCanada));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.WesternUS));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.Alaska));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.WesternCanada));
            countryMap = new CountryMap();
            return continent;
        }
        if (continentName == ContinentName.SouthAmerica)
        {
            continent.addCountry(countryMap.AdjacentCountrySA(CountryName.Argentina));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountrySA(CountryName.Brazil));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountrySA(CountryName.Peru));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountrySA(CountryName.Venezuela));
            countryMap = new CountryMap();
            return continent;
        }
        if (continentName == ContinentName.Europe)
        {
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.GreatBritain));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.Iceland));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.NorthernEurope));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.Scandinavia));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.SouthernEurope));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.Ukraine));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.WesternEurope));
            countryMap = new CountryMap();
            return continent;
        }
        if (continentName == ContinentName.Africa)
        {
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.Congo));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.EastAfrica));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.Egypt));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.Madagascar));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.NorthAfrica));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.SouthAfrica));
            countryMap = new CountryMap();
            return continent;
        }
        if (continentName == ContinentName.Asia)
        {
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Afghanistan));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.China));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.India));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Irkutsk));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Japan));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Kamchatka));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.MiddleEast));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Mongolia));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Siam));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Siberia));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Ural));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Yakutsk));
            countryMap = new CountryMap();
            return continent;
        }
        if (continentName == ContinentName.Australia)
        {
            continent.addCountry(countryMap.AdjacentCountryAU(CountryName.EasternAustralia));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAU(CountryName.Indonesia));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAU(CountryName.NewGuinea));
            countryMap = new CountryMap();
            continent.addCountry(countryMap.AdjacentCountryAU(CountryName.WesternAustralia));
            countryMap = new CountryMap();
            return continent;
        }
        else return null;
    }
}