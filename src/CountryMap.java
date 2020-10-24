import java.util.*;
public class CountryMap
{
    // in progress

    public Country CountryAdjList (CountryName name)
    {
        Country c = new Country(name);
        List <CountryName> tempCList = new LinkedList();

        if (name == CountryName.Alaska)
        {
            tempCList.add(CountryName.NorthwestTerritories);
            c.setAdjCountry(name, tempCList);
            return c;
        }
        if (name == CountryName.NorthwestTerritories)
        {
            tempCList.add(CountryName.Alaska);
            tempCList.add(CountryName.WesternCanada);
            tempCList.add(CountryName.CentralCanada);
            c.setAdjCountry(name, tempCList);
            return c;
        }
    }
}
