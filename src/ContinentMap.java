/**
 *  ContinentMap Class
 *
 *  Methods:
 *  setUpContinent(continentName)
 *
 *
 * Author: Vis Kirubakaran
 * Version: 10.25.2020
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
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.EasternUS));
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.Greenland));
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.NorthwestTerritories));
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.CentralCanada));
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.EasternCanada));
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.WesternUS));
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.Alaska));
            continent.addCountry(countryMap.AdjacentCountryNA(CountryName.WesternCanada));
            return continent;
        }
        if (continentName == ContinentName.SouthAmerica)
        {
            continent.addCountry(countryMap.AdjacentCountrySA(CountryName.Argentina));
            continent.addCountry(countryMap.AdjacentCountrySA(CountryName.Brazil));
            continent.addCountry(countryMap.AdjacentCountrySA(CountryName.Peru));
            continent.addCountry(countryMap.AdjacentCountrySA(CountryName.Venezuela));
            return continent;
        }
        if (continentName == ContinentName.Europe)
        {
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.GreatBritain));
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.Iceland));
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.NorthernEurope));
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.Scandinavia));
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.SouthernEurope));
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.Ukraine));
            continent.addCountry(countryMap.AdjacentCountryEU(CountryName.WesternEurope));
            return continent;
        }
        if (continentName == ContinentName.Africa)
        {
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.Congo));
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.EastAfrica));
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.Egypt));
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.Madagascar));
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.NorthAfrica));
            continent.addCountry(countryMap.AdjacentCountryAF(CountryName.SouthAfrica));
            return continent;
        }
        if (continentName == ContinentName.Asia)
        {
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Afghanistan));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.China));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.India));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Irkutsk));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Japan));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Kamchatka));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.MiddleEast));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Mongolia));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Siam));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Siberia));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Ural));
            continent.addCountry(countryMap.AdjacentCountryAS(CountryName.Yakutsk));
            return continent;
        }
        if (continentName == ContinentName.Australia)
        {
            continent.addCountry(countryMap.AdjacentCountryAU(CountryName.EasternAustralia));
            continent.addCountry(countryMap.AdjacentCountryAU(CountryName.Indonesia));
            continent.addCountry(countryMap.AdjacentCountryAU(CountryName.NewGuinea));
            continent.addCountry(countryMap.AdjacentCountryAU(CountryName.WesternAustralia));
            return continent;
        }
        else return null;
    }

}
