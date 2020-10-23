import java.util.*;

public class Continent {
    private ArrayList<Country> countries;
    private int continentBonus;
    private String name;

    public Continent(String name,int continentBonus){
        this.name = name;
        this.continentBonus = continentBonus;
        countries = new ArrayList<>();
    }

}
