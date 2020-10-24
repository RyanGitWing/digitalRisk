import java.util.*;

public class Continent {
    private List<Country> countries;
    private final ContinentName name;

    public Continent(ContinentName name){
        this.name = name;
        countries = new List<>();
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
