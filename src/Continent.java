import java.util.*;

public class Continent {
    ArrayList<Country> countries; // was private and a List todo
    private final ContinentName name;

    public Continent(ContinentName name){
        this.name = name;
        countries = new ArrayList<>(); // was a list todo
    }

    public void addCountry(Country c){
        countries.add(c);
    }

    public ContinentName getName(){
        return name;
    }

    public List<Country> getContinent(){
        return countries;
    }

}