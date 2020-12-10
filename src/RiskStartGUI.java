import javax.swing.*;

public class RiskStartGUI
{

    public RiskStartGUI()
    {
        String [] numPlayers = new String[7]; // max 6 players
        for (int i = 0; i < numPlayers.length; i++)
        {
            numPlayers[i] = String.valueOf(i);
        }

        String numHuman = (String) JOptionPane.showInputDialog(null,
                "Select the number", "How many human players?",
                JOptionPane.INFORMATION_MESSAGE, null,
                numPlayers, "2");

        int numHumanP = Integer.parseInt(numHuman);
        int numAIMax = numPlayers.length - numHumanP;
        int numAIPlyr = 0;

        if (numHumanP != 6) {
            String[] numAIPlayers = new String[numAIMax];
            for (int i = 0; i < numAIPlayers.length; i++) {
                numAIPlayers[i] = String.valueOf(i);
            }

            String numAI = (String) JOptionPane.showInputDialog(null,
                    "Select the number", "How many AI players?",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    numAIPlayers, "");
            numAIPlyr = Integer.parseInt(numAI);
        }
        String mapType = (String) JOptionPane.showInputDialog(null,
                "Select the Map type", "Default or Custom Map?",
                JOptionPane.INFORMATION_MESSAGE, null,
                new String[]{"Default", "Custom"}, "");

        if (mapType.equals("Default"))
        {
            RiskFrame rf = new RiskFrame(numHumanP, numAIPlyr, "");
        }
        else if (mapType.equals("Custom"))
        {
            String CustomPath = (String) JOptionPane.showInputDialog(null,
                    "Select the Custom Map", "Which Custom Map?",
                    JOptionPane.INFORMATION_MESSAGE, null,
                    new String[]{"{basedir}", ""}, "");
            RiskFrame rf = new RiskFrame(numHumanP, numAIPlyr, CustomPath);
        }


    }

    public static void main(String[] args) {
        new RiskStartGUI();
    }

}

