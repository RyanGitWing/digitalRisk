import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.List;

public class FortifyController implements ActionListener {

    private final Game riskGame;
    private final Board board;

    /**
     * Creates a RiskController object.
     *
     * @param riskGame The game object.
     */
    public FortifyController(Game riskGame) {
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

        String ourC = e.getActionCommand();

            String[] fortC = new String[riskGame.getCurrentPlayer().getOwnedCountries().size() - 1];
            for (int i = 0; i < fortC.length; i++) {
                if (!riskGame.getCurrentPlayer().getOwnedCountries().get(i).getCountryName().toString().equals(ourC)) {
                    fortC[i] = riskGame.getCurrentPlayer().getOwnedCountries().get(i).getCountryName().toString() +
                            " " + riskGame.getCurrentPlayer().getOwnedCountries().get(i).getArmyOccupied();
                }
            }
            String frtC = (String) JOptionPane.showInputDialog(null,
                    "Choose a country to fortify", "List of own Countries",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    fortC, "");

            if (frtC != null) {

                String name = ourC; //todo temp
                String[] armyDeploy = new String[riskGame.getBoardMap().getCountry(CountryName.valueOf(name)).getArmyOccupied() - 1];

                for (int i = 0; i < armyDeploy.length; i++) {
                    armyDeploy[i] = String.valueOf(i + 1);
                }

                String fortifyC = frtC.substring(0, frtC.indexOf(" "));
                String fortifyWC = ourC; //todo temp
                if ((riskGame.pathCheck(fortifyWC, new ArrayList<>(), fortifyC))) {
                    String armyDpl = (String) JOptionPane.showInputDialog(null,
                            "Choose the amount of army to deploy", "Amount of army available to deploy",
                            JOptionPane.INFORMATION_MESSAGE, null,
                            armyDeploy, "");
                    riskGame.getBoardMap().getCountry(CountryName.valueOf(fortifyC)).setArmyOccupied(riskGame.getBoardMap().getCountry(CountryName.valueOf(fortifyC)).getArmyOccupied() + Integer.parseInt(armyDpl));
                    riskGame.getBoardMap().getCountry(CountryName.valueOf(fortifyWC)).setArmyOccupied(riskGame.getBoardMap().getCountry(CountryName.valueOf(fortifyWC)).getArmyOccupied() - Integer.parseInt(armyDpl));
                    riskGame.nextPlayer();
                    riskGame.update();
                } else {
                    String text = "";
                    text += "There was no path between these countries!";
                    JOptionPane.showMessageDialog(null, text, "Alert", JOptionPane.WARNING_MESSAGE);
                }
            }
        }

}
