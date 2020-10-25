import java.util.*;

public class ContinentMap
{
    private HashMap <ContinentName, List <Country> > continentMap;

    public ContinentMap ()
    {
        continentMap = new HashMap<>();
    }

    public HashMap <ContinentName, List <Country> > setUpContinent (ContinentName continentName)
    {
        CountryMap countryMap = new CountryMap();
        List <Country> countryList = new LinkedList();
        if (continentName == ContinentName.NorthAmerica)
        {
            countryList.add(countryMap.AdjacentCountryNA(CountryName.WesternCanada));
            countryList.add(countryMap.AdjacentCountryNA(CountryName.CentralAmerica));
            countryList.add(countryMap.AdjacentCountryNA(CountryName.EasternUS));
            countryList.add(countryMap.AdjacentCountryNA(CountryName.Greenland));
            countryList.add(countryMap.AdjacentCountryNA(CountryName.NorthwestTerritories));
            countryList.add(countryMap.AdjacentCountryNA(CountryName.CentralCanada));
            countryList.add(countryMap.AdjacentCountryNA(CountryName.EasternCanada));
            countryList.add(countryMap.AdjacentCountryNA(CountryName.WesternUS));
            countryList.add(countryMap.AdjacentCountryNA(CountryName.Alaska));
            continentMap.put(continentName, countryList);
            return continentMap;
        }
        if (continentName == ContinentName.SouthAmerica)
        {
            countryList.add(countryMap.AdjacentCountrySA(CountryName.Argentina));
            countryList.add(countryMap.AdjacentCountrySA(CountryName.Brazil));
            countryList.add(countryMap.AdjacentCountrySA(CountryName.Peru));
            countryList.add(countryMap.AdjacentCountrySA(CountryName.Venezuela));
            continentMap.put(continentName, countryList);
            return continentMap;
        }
        if (continentName == ContinentName.Europe)
        {
            countryList.add(countryMap.AdjacentCountryEU(CountryName.GreatBritain));
            countryList.add(countryMap.AdjacentCountryEU(CountryName.Iceland));
            countryList.add(countryMap.AdjacentCountryEU(CountryName.NorthernEurope));
            countryList.add(countryMap.AdjacentCountryEU(CountryName.Scandinavia));
            countryList.add(countryMap.AdjacentCountryEU(CountryName.SouthernEurope));
            countryList.add(countryMap.AdjacentCountryEU(CountryName.Ukraine));
            countryList.add(countryMap.AdjacentCountryEU(CountryName.WesternEurope));
            continentMap.put(continentName, countryList);
            return continentMap;
        }
        if (continentName == ContinentName.Africa)
        {
            countryList.add(countryMap.AdjacentCountryAF(CountryName.Congo));
            countryList.add(countryMap.AdjacentCountryAF(CountryName.EastAfrica));
            countryList.add(countryMap.AdjacentCountryAF(CountryName.Egypt));
            countryList.add(countryMap.AdjacentCountryAF(CountryName.Madagascar));
            countryList.add(countryMap.AdjacentCountryAF(CountryName.NorthAfrica));
            countryList.add(countryMap.AdjacentCountryAF(CountryName.SouthAfrica));
            continentMap.put(continentName, countryList);
            return continentMap;
        }
        if (continentName == ContinentName.Asia)
        {
            countryList.add(countryMap.AdjacentCountryAS(CountryName.Afghanistan));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.China));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.India));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.Irkutsk));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.Japan));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.Kamchatka));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.MiddleEast));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.Mongolia));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.Siam));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.Siberia));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.Ural));
            countryList.add(countryMap.AdjacentCountryAS(CountryName.Yakutsk));
            continentMap.put(continentName, countryList);
            return continentMap;
        }
        if (continentName == ContinentName.Australia)
        {
            countryList.add(countryMap.AdjacentCountryAU(CountryName.EasternAustralia));
            countryList.add(countryMap.AdjacentCountryAU(CountryName.Indonesia));
            countryList.add(countryMap.AdjacentCountryAU(CountryName.NewGuinea));
            countryList.add(countryMap.AdjacentCountryAU(CountryName.WesternAustralia));
            continentMap.put(continentName, countryList);
            return continentMap;
        }
        else return null;
    }
}
