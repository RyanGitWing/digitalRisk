import java.util.*;
public class CountryMap
{
    public Country AdjacentCountryNA (CountryName name)
    {
        Country country = new Country(name);
        List <CountryName> adjCountryList = new LinkedList();
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
        if (name == CountryName.NorthwestTerritories)
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
    public Country AdjacentCountrySA (CountryName name)
    {
        Country country = new Country(name);
        List <CountryName> adjCountryList = new LinkedList();
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
    public Country AdjacentCountryEU (CountryName name)
    {
        Country country = new Country(name);
        List <CountryName> adjCountryList = new LinkedList();
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
            adjCountryList.add(CountryName.Iceland);
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
    public Country AdjacentCountryAF (CountryName name)
    {
        Country country = new Country(name);
        List <CountryName> adjCountryList = new LinkedList();
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
    public Country AdjacentCountryAS (CountryName name)
    {
        Country country = new Country(name);
        List <CountryName> adjCountryList = new LinkedList();
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
            adjCountryList.add(CountryName.MiddleEast);
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
    public Country AdjacentCountryAU (CountryName name)
    {
        Country country = new Country(name);
        List <CountryName> adjCountryList = new LinkedList();
        if (name == CountryName.EasternAustralia)
        {
            adjCountryList.add(CountryName.NewGuinea);
            adjCountryList.add(CountryName.WesternAustralia);
            country.setAdjCountry(name, adjCountryList);
            return country;
        }
        if (name == CountryName.Indonesia)
        {
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
