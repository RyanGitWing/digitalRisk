/**
 * This class models an AIPlayer which is an extension of the Player class
 *
 * @author Vyasan. J
 * @version 11.22.2020
 */

public class AIPlayer extends Player{


    AIPlayer(String name){
        super(name);
    }


    public void aiAttack(Game riskGame){
        int ownedCountriesSize = this.getOwnedCountries().size();
        for(int i = 0; i < ownedCountriesSize; i++){
            int adjCountriesSize = this.getOwnedCountries().get(i).getAdjCountries().size();
            if(this.getOwnedCountries().get(i).getArmyOccupied() >= 3){
                for(int j = 0; j < adjCountriesSize; j++){
                    Country adj = riskGame.getBoardMap().getCountry(this.getOwnedCountries().get(i).getAdjCountries().get(j));
                    if(this.getOwnedCountries().get(i).getArmyOccupied()>adj.getArmyOccupied() && !adj.getRuler().equals(this)){
                        riskGame.attackCMD(this.getOwnedCountries().get(i).getCountryName().toString(),3,adj.getCountryName().toString());
                    }
                }
            }

        }

    }


    @Override
    public boolean isAI(){
        return true;
    }


}
