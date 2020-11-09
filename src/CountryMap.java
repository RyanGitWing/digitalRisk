import java.util.*;
/**
 *  The default Country Map Class
 *
 * @author Vis Kirubakaran
 * @version 10.25.2020
 *
 * @author Fareen. L
 * @version 11.08.2020
 */

public class CountryMap
{
    // North America
    private final CountryName[] Alaska = new CountryName[] { CountryName.NorthwestTerritories };
    private final CountryName[] WesternCanada = new CountryName[] {
            CountryName.NorthwestTerritories, CountryName.CentralCanada };
    private final CountryName[] CentralAmerica = new CountryName[] {
            CountryName.EasternUS, CountryName.WesternUS, CountryName.Scandinavia };
    private final CountryName[] EasternUS = new CountryName[] {
            CountryName.CentralAmerica, CountryName.CentralCanada, CountryName.WesternUS };
    private final CountryName[] Greenland = new CountryName[] {
            CountryName.NorthwestTerritories, CountryName.CentralCanada, CountryName.EasternCanada, CountryName.Iceland };
    private final CountryName[] NorthwestTerritories = new CountryName[] {
            CountryName.Alaska, CountryName.WesternCanada, CountryName.Greenland, CountryName.CentralCanada };
    private final CountryName[] CentralCanada = new CountryName[] {
            CountryName.WesternCanada, CountryName.Greenland, CountryName.NorthwestTerritories, CountryName.EasternCanada };
    private final CountryName[] EasternCanada = new CountryName[] {
            CountryName.EasternUS, CountryName.Greenland, CountryName.NorthwestTerritories, CountryName.CentralCanada };
    private final CountryName[] WesternUS = new CountryName[] {
            CountryName.WesternCanada, CountryName.CentralAmerica, CountryName.EasternUS, CountryName.EasternCanada };

    // South America
    private final CountryName[] Argentina = new CountryName[] { CountryName.Brazil, CountryName.Peru };
    private final CountryName[] Brazil  = new CountryName[] {
            CountryName.Argentina, CountryName.Peru, CountryName.Venezuela, CountryName.NorthAfrica };
    private final CountryName[] Peru = new CountryName[] {
            CountryName.Argentina, CountryName.Brazil, CountryName.Venezuela };
    private final CountryName[] Venezuela = new CountryName[] { CountryName.Brazil, CountryName.Peru };

    // Europe
    private final CountryName[] GreatBritain  = new CountryName[] {
            CountryName.Iceland, CountryName.NorthernEurope, CountryName.Scandinavia, CountryName.WesternEurope };
    private final CountryName[] Iceland  = new CountryName[] { CountryName.SouthernEurope, CountryName.Greenland };
    private final CountryName[] NorthernEurope = new CountryName[] {
            CountryName.GreatBritain, CountryName.Scandinavia, CountryName.SouthernEurope, CountryName.Ukraine, CountryName.WesternEurope };
    private final CountryName[] Scandinavia = new CountryName[] {
            CountryName.GreatBritain, CountryName.Iceland, CountryName.NorthernEurope, CountryName.Ukraine };
    private final CountryName[] SouthernEurope = new CountryName[] {
            CountryName.NorthernEurope, CountryName.Ukraine, CountryName.WesternEurope, CountryName.Egypt, CountryName.NorthAfrica, CountryName.MiddleEast };
    private final CountryName[] Ukraine  = new CountryName[] {
            CountryName.NorthernEurope, CountryName.Scandinavia, CountryName.SouthernEurope, CountryName.Afghanistan, CountryName.MiddleEast, CountryName.Ural };
    private final CountryName[] WesternEurope = new CountryName[] {
            CountryName.GreatBritain, CountryName.NorthernEurope, CountryName.SouthernEurope, CountryName.NorthAfrica };

    // Africa
    private final CountryName[] Congo = new CountryName[] {
            CountryName.EastAfrica, CountryName.NorthAfrica, CountryName.SouthAfrica };
    private final CountryName[] EastAfrica = new CountryName[] {
            CountryName.Congo, CountryName.Egypt, CountryName.Madagascar, CountryName.MiddleEast };
    private final CountryName[] Egypt = new CountryName[] {
            CountryName.EastAfrica, CountryName.NorthAfrica, CountryName.SouthernEurope, CountryName.MiddleEast };
    private final CountryName[] Madagascar = new CountryName[] { CountryName.EastAfrica, CountryName.SouthAfrica };
    private final CountryName[] NorthAfrica = new CountryName[] {
            CountryName.Congo, CountryName.Egypt, CountryName.Brazil, CountryName.SouthernEurope, CountryName.WesternEurope };
    private final CountryName[] SouthAfrica = new CountryName[] {
            CountryName.Congo, CountryName.EastAfrica, CountryName.Madagascar };

    // Asia
    private final CountryName[] Afghanistan = new CountryName[] {
            CountryName.China, CountryName.India, CountryName.MiddleEast, CountryName.Ural, CountryName.Ukraine };
    private final CountryName[] China = new CountryName[] {
            CountryName.Afghanistan, CountryName.India, CountryName.Mongolia, CountryName.Siam, CountryName.Siberia, CountryName.Ural };
    private final CountryName[] India = new CountryName[] {
            CountryName.Afghanistan, CountryName.China, CountryName.MiddleEast };
    private final CountryName[] Irkutsk = new CountryName[] {
            CountryName.Kamchatka, CountryName.Mongolia, CountryName.Siberia, CountryName.Yakutsk };
    private final CountryName[] Japan = new CountryName[] { CountryName.Kamchatka, CountryName.Mongolia };
    private final CountryName[] Kamchatka = new CountryName[] { CountryName.Irkutsk, CountryName.Japan, CountryName.Yakutsk };
    private final CountryName[] MiddleEast = new CountryName[] {
            CountryName.Afghanistan, CountryName.India, CountryName.EastAfrica, CountryName.Egypt, CountryName.SouthernEurope, CountryName.Ukraine };
    private final CountryName[] Mongolia = new CountryName[] {
            CountryName.China, CountryName.Irkutsk, CountryName.Japan, CountryName.Kamchatka, CountryName.Siberia };
    private final CountryName[] Siam = new CountryName[] {
        CountryName.China, CountryName.India, CountryName.Indonesia };
    private final CountryName[] Siberia = new CountryName[] {
        CountryName.China, CountryName.Irkutsk, CountryName.Mongolia, CountryName.Ural, CountryName.Yakutsk };
    private final CountryName[] Ural = new CountryName[] {
        CountryName.Afghanistan, CountryName.China, CountryName.Siberia, CountryName.Ukraine };
    private final CountryName[] Yakutsk = new CountryName[] {
        CountryName.Irkutsk, CountryName.Kamchatka, CountryName.Siberia };

    // Australia
    private final CountryName[] EasternAustralia =  new CountryName[] { CountryName.NewGuinea, CountryName.WesternAustralia };
    private final CountryName[] Indonesia = new CountryName[] {
        CountryName.NewGuinea, CountryName.WesternAustralia, CountryName.Siam };
    private final CountryName[] NewGuinea = new CountryName[] { CountryName.EasternAustralia, CountryName.Indonesia };
    private final CountryName[] WesternAustralia = new CountryName[] { CountryName.EasternAustralia, CountryName.NewGuinea };

    /**
     * Creates a new country map and sets up an empty list of adjacent countries.
     */
    public CountryMap ()
    {
    }

    /**
     * Sets up a country with corresponding adjacent countries.
     *
     * @param name The name of the country
     * @return The setup country.
     */
    public Country SetAdjacentCountries (CountryName name)
    {
        boolean exists = false;

        // check to see if CountryName is valid
        for (CountryName c : CountryName.values()) {
            if (c.name().equals(name)) {
                exists = true;
                break;
            }
        }

        if (! exists) return null;

        Country country = new Country(name);

        // North America
        if (name == CountryName.Alaska) country.setAdjCountry(Arrays.asList(Alaska));
        if (name == CountryName.WesternCanada) country.setAdjCountry(Arrays.asList(WesternCanada));
        if (name == CountryName.CentralAmerica) country.setAdjCountry(Arrays.asList(CentralAmerica));
        if (name == CountryName.EasternUS) country.setAdjCountry(Arrays.asList(EasternUS));
        if (name == CountryName.Greenland) country.setAdjCountry(Arrays.asList(Greenland));
        if (name == CountryName.NorthwestTerritories) country.setAdjCountry(Arrays.asList(NorthwestTerritories));
        if (name == CountryName.CentralCanada) country.setAdjCountry(Arrays.asList(CentralCanada));
        if (name == CountryName.EasternCanada) country.setAdjCountry(Arrays.asList(EasternCanada));
        if (name == CountryName.WesternUS) country.setAdjCountry(Arrays.asList(WesternUS));

        // SouthAmerica
        if (name == CountryName.Argentina) country.setAdjCountry(Arrays.asList(Argentina));
        if (name == CountryName.Brazil) country.setAdjCountry(Arrays.asList(Brazil));
        if (name == CountryName.Peru) country.setAdjCountry(Arrays.asList(Peru));
        if (name == CountryName.Venezuela) country.setAdjCountry(Arrays.asList(Venezuela));

        // Europe
        if (name == CountryName.GreatBritain) country.setAdjCountry(Arrays.asList(GreatBritain));
        if (name == CountryName.Iceland) country.setAdjCountry(Arrays.asList(Iceland));
        if (name == CountryName.NorthernEurope) country.setAdjCountry(Arrays.asList(NorthernEurope));
        if (name == CountryName.Scandinavia) country.setAdjCountry(Arrays.asList(Scandinavia));
        if (name == CountryName.SouthernEurope) country.setAdjCountry(Arrays.asList(SouthernEurope));
        if (name == CountryName.Ukraine) country.setAdjCountry(Arrays.asList(Ukraine));
        if (name == CountryName.WesternEurope) country.setAdjCountry(Arrays.asList(WesternEurope));

        // Africa
        if (name == CountryName.Congo) country.setAdjCountry(Arrays.asList(Congo));
        if (name == CountryName.EastAfrica) country.setAdjCountry(Arrays.asList(EastAfrica));
        if (name == CountryName.Egypt) country.setAdjCountry(Arrays.asList(Egypt));
        if (name == CountryName.Madagascar) country.setAdjCountry(Arrays.asList(Madagascar));
        if (name == CountryName.NorthAfrica) country.setAdjCountry(Arrays.asList(NorthAfrica));
        if (name == CountryName.SouthAfrica) country.setAdjCountry(Arrays.asList(SouthAfrica));

        // Asia
        if (name == CountryName.Afghanistan) country.setAdjCountry(Arrays.asList(Afghanistan));
        if (name == CountryName.China) country.setAdjCountry(Arrays.asList(China));
        if (name == CountryName.India) country.setAdjCountry(Arrays.asList(India));
        if (name == CountryName.Irkutsk) country.setAdjCountry(Arrays.asList(Irkutsk));
        if (name == CountryName.Japan) country.setAdjCountry(Arrays.asList(Japan));
        if (name == CountryName.Kamchatka) country.setAdjCountry(Arrays.asList(Kamchatka));
        if (name == CountryName.MiddleEast) country.setAdjCountry(Arrays.asList(MiddleEast));
        if (name == CountryName.Mongolia) country.setAdjCountry(Arrays.asList(Mongolia));
        if (name == CountryName.Siam) country.setAdjCountry(Arrays.asList(Siam));
        if (name == CountryName.Siberia) country.setAdjCountry(Arrays.asList(Siberia));
        if (name == CountryName.Ural) country.setAdjCountry(Arrays.asList(Ural));
        if (name == CountryName.Yakutsk) country.setAdjCountry(Arrays.asList(Yakutsk));

        // Australia
        if (name == CountryName.EasternAustralia) country.setAdjCountry(Arrays.asList(EasternAustralia));
        if (name == CountryName.Indonesia) country.setAdjCountry(Arrays.asList(Indonesia));
        if (name == CountryName.NewGuinea) country.setAdjCountry(Arrays.asList(NewGuinea));
        if (name == CountryName.WesternAustralia) country.setAdjCountry(Arrays.asList(WesternAustralia));

        return country;
    }
}