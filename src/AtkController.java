import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;
/**
 * The Risk Atk Controller.
 *
 * @author Ryan. N
 * @version 12.08.2020
 *
 * @author Vis. K
 * @version 12.09.2020
 */

public class AtkController implements ActionListener {

    private final Game riskGame;
    private final Board board;

    /**
     * Creates a AtkController object.
     *
     * @param riskGame The game object.
     */
    public AtkController(Game riskGame) {
        this.riskGame = riskGame;
        board = riskGame.getBoardMap();
    }

    /**
     * Handles user interaction with WorldMapGUI and the phase of attacking countries.
     *
     * @param e The event.
     */
    @Override
    public void actionPerformed(ActionEvent e) {
        String atkC = e.getActionCommand();
        String defC;
        String armyC;
        int armyCount;

        Country country = board.getCountry(atkC);
        List<String> countryAdjList = country.getAdjCountries();

        if (!riskGame.getCurrentPlayer().equals(country.getRuler())) {
            String text = "";
            text += "You don't own this country. " + "\n" + "The current ruler is: " + country.getRuler().getName() + "\n" + "The current army is: " + country.getArmyOccupied();
            JOptionPane.showMessageDialog(null, text, "Alert", JOptionPane.WARNING_MESSAGE);
        }
        else
        {
            List<Country> adjEnemy = new ArrayList<>();

            for (String countryName : countryAdjList) {
                Country boardCountry = board.getCountry(countryName);
                if (!boardCountry.getRuler().equals(riskGame.getCurrentPlayer())) adjEnemy.add(boardCountry);
            }

            if (adjEnemy.size() != 0) {
                String[] adjEnemyArr = new String[adjEnemy.size()];
                for (int i = 0; i < adjEnemy.size(); i++) {
                    adjEnemyArr[i] = adjEnemy.get(i).getCountryName();
                }
                defC = (String) JOptionPane.showInputDialog(null,
                        "Choose a country to attack", "List of Enemy Adj Countries",
                        JOptionPane.INFORMATION_MESSAGE, null,
                        adjEnemyArr, "");

                if (defC != null) {
                    int size = country.getArmyOccupied();

                    if (size > 3) {
                        size = 3;
                    }

                    String[] armyNum = new String[size];

                    for (int i = 0; i < armyNum.length; i++) {
                        armyNum[i] = String.valueOf(i + 1);
                    }

                    if (armyNum.length > 1) {
                        armyC = (String) JOptionPane.showInputDialog(null,
                                "Choose the amount of army to deploy", "Amount of army available to deploy",
                                JOptionPane.INFORMATION_MESSAGE, null,
                                armyNum, "");

                        if (armyC != null) {
                            armyCount = Integer.parseInt(armyC);

                            if (armyCount > 0) {

                                riskGame.attackCMD(atkC, armyCount, defC);
                                riskGame.update();
                                JOptionPane.showMessageDialog(null, riskGame.getAtkOutput(), "Alert", JOptionPane.WARNING_MESSAGE);
                                if (riskGame.turnOutcome()) {

                                    String[] occArmy = new String[country.getArmyOccupied() - 1];

                                    for (int i = 0; i < occArmy.length; i++) {
                                        occArmy[i] = String.valueOf(i + 1);
                                    }

                                    String armyD = (String) JOptionPane.showInputDialog(null,
                                            "How many troops would you like to allocate to the new Country?", "Amount of army to move",
                                            JOptionPane.INFORMATION_MESSAGE, null,
                                            occArmy, "");

                                    riskGame.getBoardMap().getCountry(defC).setArmyOccupied(Integer.parseInt(armyD));
                                    riskGame.getBoardMap().getCountry(atkC).setArmyOccupied(country.getArmyOccupied() - Integer.parseInt(armyD));
                                    riskGame.update();
                                }
                                int cont = JOptionPane.showConfirmDialog(null, "Would you like to continue to attack?",
                                        "Attack Phase", JOptionPane.YES_NO_OPTION);
                                if (cont == JOptionPane.NO_OPTION)
                                {
                                    riskGame.setState(Game.State.Fortify);
                                    riskGame.update();
                                }
                            }
                        }
                    }
                }
            }
            else JOptionPane.showMessageDialog(null, "You own all nearby countries." + "\n" + countryAdjList, "Alert!", JOptionPane.WARNING_MESSAGE);
        }
    }
}