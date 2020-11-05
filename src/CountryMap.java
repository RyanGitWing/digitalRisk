import java.util.*;
/**
 *  CountryMap Class
 *
 *  Methods:
 *
 *  AdjacentCountryNA (name)
 *  AdjacentCountrySA (name)
 *  AdjacentCountryEU (name)
 *  AdjacentCountryAF (name)
 *  AdjacentCountryAS (name)
 *  AdjacentCountryAU (name)
 *
 * @author Vis Kirubakaran
 * @version 10.25.2020
 */

public class CountryMap
{
    private List <CountryName> adjCountryList;
    private Country country;

    public CountryMap ()
    {
        adjCountryList = new ArrayList<>();
    }

    /**
     * AdjacentCountryNA (name) takes enum input and uses private variable country of type Country, adjCountryList which is
     * a list of CountryName enums. This method will use setAdjCountry method provided in Country to set country's
     * adjCountries by using given enum input, and the adjCountryList. This will be done for all countries in
     * North America
     *
     * @param name
     * @return Country
     */

    public Country AdjacentCountryNA (CountryName name)
    {
        this.country = new Country(name);
        if (name == CountryName.Alaska)
        {
            adjCountryList.add(CountryName.NorthwestTerritories);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.WesternCanada)
        {
            adjCountryList.add(CountryName.NorthwestTerritories);
            adjCountryList.add(CountryName.CentralCanada);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.CentralAmerica)
        {
            adjCountryList.add(CountryName.EasternUS);
            adjCountryList.add(CountryName.WesternUS);
            adjCountryList.add(CountryName.Scandinavia);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.EasternUS)
        {
            adjCountryList.add(CountryName.CentralAmerica);
            adjCountryList.add(CountryName.CentralCanada);
            adjCountryList.add(CountryName.WesternUS);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Greenland)
        {
            adjCountryList.add(CountryName.NorthwestTerritories);
            adjCountryList.add(CountryName.CentralCanada);
            adjCountryList.add(CountryName.EasternCanada);
            adjCountryList.add(CountryName.Iceland);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.NorthwestTerritories)
        {
            adjCountryList.add(CountryName.Alaska);
            adjCountryList.add(CountryName.WesternCanada);
            adjCountryList.add(CountryName.Greenland);
            adjCountryList.add(CountryName.CentralCanada);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.CentralCanada)
        {
            adjCountryList.add(CountryName.WesternCanada);
            adjCountryList.add(CountryName.Greenland);
            adjCountryList.add(CountryName.NorthwestTerritories);
            adjCountryList.add(CountryName.EasternCanada);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.EasternCanada)
        {
            adjCountryList.add(CountryName.EasternUS);
            adjCountryList.add(CountryName.Greenland);
            adjCountryList.add(CountryName.NorthwestTerritories);
            adjCountryList.add(CountryName.CentralCanada);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.WesternUS)
        {
            adjCountryList.add(CountryName.WesternCanada);
            adjCountryList.add(CountryName.CentralAmerica);
            adjCountryList.add(CountryName.EasternUS);
            adjCountryList.add(CountryName.EasternCanada);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        else return null;
    }

    /**
     * AdjacentCountrySA (name) takes enum input and uses private variable country of type Country, adjCountryList which is
     * a list of CountryName enums. This method will use setAdjCountry method provided in Country to set country's
     * adjCountries by using given enum input, and the adjCountryList. This will be done for all countries in
     * South America
     *
     * @param name
     * @return Country
     */

    public Country AdjacentCountrySA (CountryName name)
    {
        this.country = new Country(name);
        if (name == CountryName.Argentina)
        {
            adjCountryList.add(CountryName.Brazil);
            adjCountryList.add(CountryName.Peru);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Brazil)
        {
            adjCountryList.add(CountryName.Argentina);
            adjCountryList.add(CountryName.Peru);
            adjCountryList.add(CountryName.Venezuela);
            adjCountryList.add(CountryName.NorthAfrica);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Peru)
        {
            adjCountryList.add(CountryName.Argentina);
            adjCountryList.add(CountryName.Brazil);
            adjCountryList.add(CountryName.Venezuela);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Venezuela)
        {
            adjCountryList.add(CountryName.Brazil);
            adjCountryList.add(CountryName.Peru);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        else return null;
    }

    /**
     * AdjacentCountryEU (name) takes enum input and uses private variable country of type Country, adjCountryList which is
     * a list of CountryName enums. This method will use setAdjCountry method provided in Country to set country's
     * adjCountries by using given enum input, and the adjCountryList. This will be done for all countries in
     * Europe
     *
     * @param name
     * @return Country
     */

    public Country AdjacentCountryEU (CountryName name)
    {
        this.country = new Country(name);
        if (name == CountryName.GreatBritain)
        {
            adjCountryList.add(CountryName.Iceland);
            adjCountryList.add(CountryName.NorthernEurope);
            adjCountryList.add(CountryName.Scandinavia);
            adjCountryList.add(CountryName.WesternEurope);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Iceland)
        {
            adjCountryList.add(CountryName.SouthernEurope);
            adjCountryList.add(CountryName.Greenland);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.NorthernEurope)
        {
            adjCountryList.add(CountryName.GreatBritain);
            adjCountryList.add(CountryName.Scandinavia);
            adjCountryList.add(CountryName.SouthernEurope);
            adjCountryList.add(CountryName.Ukraine);
            adjCountryList.add(CountryName.WesternEurope);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Scandinavia)
        {
            adjCountryList.add(CountryName.GreatBritain);
            adjCountryList.add(CountryName.Iceland);
            adjCountryList.add(CountryName.NorthernEurope);
            adjCountryList.add(CountryName.Ukraine);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.SouthernEurope)
        {
            adjCountryList.add(CountryName.NorthernEurope);
            adjCountryList.add(CountryName.Ukraine);
            adjCountryList.add(CountryName.WesternEurope);
            adjCountryList.add(CountryName.Egypt);
            adjCountryList.add(CountryName.NorthAfrica);
            adjCountryList.add(CountryName.MiddleEast);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Ukraine)
        {
            adjCountryList.add(CountryName.NorthernEurope);
            adjCountryList.add(CountryName.Scandinavia);
            adjCountryList.add(CountryName.SouthernEurope);
            adjCountryList.add(CountryName.Afghanistan);
            adjCountryList.add(CountryName.MiddleEast);
            adjCountryList.add(CountryName.Ural);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.WesternEurope)
        {
            adjCountryList.add(CountryName.GreatBritain);
            adjCountryList.add(CountryName.NorthernEurope);
            adjCountryList.add(CountryName.SouthernEurope);
            adjCountryList.add(CountryName.NorthAfrica);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        else return null;
    }

    /**
     * AdjacentCountryAF (name) takes enum input and uses private variable country of type Country, adjCountryList which is
     * a list of CountryName enums. This method will use setAdjCountry method provided in Country to set country's
     * adjCountries by using given enum input, and the adjCountryList. This will be doen for all countries in
     * Africa
     *
     * @param name
     * @return Country
     */

    public Country AdjacentCountryAF (CountryName name)
    {
        this.country = new Country(name);
        if (name == CountryName.Congo)
        {
            adjCountryList.add(CountryName.EastAfrica);
            adjCountryList.add(CountryName.NorthAfrica);
            adjCountryList.add(CountryName.SouthAfrica);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.EastAfrica)
        {
            adjCountryList.add(CountryName.Congo);
            adjCountryList.add(CountryName.Egypt);
            adjCountryList.add(CountryName.Madagascar);
            adjCountryList.add(CountryName.MiddleEast);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Egypt)
        {
            adjCountryList.add(CountryName.EastAfrica);
            adjCountryList.add(CountryName.NorthAfrica);
            adjCountryList.add(CountryName.SouthernEurope);
            adjCountryList.add(CountryName.MiddleEast);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Madagascar)
        {
            adjCountryList.add(CountryName.EastAfrica);
            adjCountryList.add(CountryName.SouthAfrica);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.NorthAfrica)
        {
            adjCountryList.add(CountryName.Congo);
            adjCountryList.add(CountryName.Egypt);
            adjCountryList.add(CountryName.Brazil);
            adjCountryList.add(CountryName.SouthernEurope);
            adjCountryList.add(CountryName.WesternEurope);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.SouthAfrica)
        {
            adjCountryList.add(CountryName.Congo);
            adjCountryList.add(CountryName.EastAfrica);
            adjCountryList.add(CountryName.Madagascar);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        else return null;
    }

    /**
     * AdjacentCountryAS (name) takes enum input and uses private variable country of type Country, adjCountryList which is
     * a list of CountryName enums. This method will use setAdjCountry method provided in Country to set country's
     * adjCountries by using given enum input, and the adjCountryList. This will be doen for all countries in
     * Asia
     *
     * @param name
     * @return Country
     */

    public Country AdjacentCountryAS (CountryName name)
    {
        this.country = new Country(name);
        if (name == CountryName.Afghanistan)
        {
            adjCountryList.add(CountryName.China);
            adjCountryList.add(CountryName.India);
            adjCountryList.add(CountryName.MiddleEast);
            adjCountryList.add(CountryName.Ural);
            adjCountryList.add(CountryName.Ukraine);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.China)
        {
            adjCountryList.add(CountryName.Afghanistan);
            adjCountryList.add(CountryName.India);
            adjCountryList.add(CountryName.Mongolia);
            adjCountryList.add(CountryName.Siam);
            adjCountryList.add(CountryName.Siberia);
            adjCountryList.add(CountryName.Ural);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.India)
        {
            adjCountryList.add(CountryName.Afghanistan);
            adjCountryList.add(CountryName.China);
            adjCountryList.add(CountryName.MiddleEast);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Irkutsk)
        {
            adjCountryList.add(CountryName.Kamchatka);
            adjCountryList.add(CountryName.Mongolia);
            adjCountryList.add(CountryName.Siberia);
            adjCountryList.add(CountryName.Yakutsk);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Japan)
        {
            adjCountryList.add(CountryName.Kamchatka);
            adjCountryList.add(CountryName.Mongolia);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Kamchatka)
        {
            adjCountryList.add(CountryName.Irkutsk);
            adjCountryList.add(CountryName.Japan);
            adjCountryList.add(CountryName.Yakutsk);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.MiddleEast)
        {
            adjCountryList.add(CountryName.Afghanistan);
            adjCountryList.add(CountryName.India);
            adjCountryList.add(CountryName.EastAfrica);
            adjCountryList.add(CountryName.Egypt);
            adjCountryList.add(CountryName.SouthernEurope);
            adjCountryList.add(CountryName.Ukraine);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Mongolia)
        {
            adjCountryList.add(CountryName.China);
            adjCountryList.add(CountryName.Irkutsk);
            adjCountryList.add(CountryName.Japan);
            adjCountryList.add(CountryName.Kamchatka);
            adjCountryList.add(CountryName.Siberia);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Siam)
        {
            adjCountryList.add(CountryName.China);
            adjCountryList.add(CountryName.India);
            adjCountryList.add(CountryName.Indonesia);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Siberia)
        {
            adjCountryList.add(CountryName.China);
            adjCountryList.add(CountryName.Irkutsk);
            adjCountryList.add(CountryName.Mongolia);
            adjCountryList.add(CountryName.Ural);
            adjCountryList.add(CountryName.Yakutsk);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Ural)
        {
            adjCountryList.add(CountryName.Afghanistan);
            adjCountryList.add(CountryName.China);
            adjCountryList.add(CountryName.Siberia);
            adjCountryList.add(CountryName.Ukraine);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Yakutsk)
        {
            adjCountryList.add(CountryName.Irkutsk);
            adjCountryList.add(CountryName.Kamchatka);
            adjCountryList.add(CountryName.Siberia);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        else return null;
    }

    /**
     * AdjacentCountryAU (name) takes enum input and uses private variable country of type Country, adjCountryList which is
     * a list of CountryName enums. This method will use setAdjCountry method provided in Country to set country's
     * adjCountries by using given enum input, and the adjCountryList.
     * @param name
     * @return Country
     */

    public Country AdjacentCountryAU (CountryName name)
    {
        this.country = new Country(name);
        if (name == CountryName.EasternAustralia)
        {
            adjCountryList.add(CountryName.NewGuinea);
            adjCountryList.add(CountryName.WesternAustralia);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Indonesia)
        {
            adjCountryList.add(CountryName.NewGuinea);
            adjCountryList.add(CountryName.WesternAustralia);
            adjCountryList.add(CountryName.Siam);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.NewGuinea)
        {
            adjCountryList.add(CountryName.EasternAustralia);
            adjCountryList.add(CountryName.Indonesia);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.WesternAustralia)
        {
            adjCountryList.add(CountryName.EasternAustralia);
            adjCountryList.add(CountryName.NewGuinea);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        else return null;
    }
}