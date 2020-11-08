import javax.swing.*;
import javax.swing.border.EtchedBorder;
import javax.swing.border.TitledBorder;
import javax.swing.text.DefaultCaret;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RiskView extends JFrame {

    JMenuItem quitGame, saveGame, loadGame;

    JButton atk, stat, nTurn;

    Game riskGame;

    JTextArea worldNews;

    int numPlayers;

    public RiskView() {

        super("Risk Game");

        //The starter frame
        starter();

    }

    /**
     * This method creates the game frame after the user has picked the number
     * of players.
     */
    public void initializeGame() {

        riskGame = new Game(numPlayers);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RiskController riskCtrl = new RiskController();

        riskGame.addRiskView(this);

        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(1500,1000));
        this.pack();
        //Centering the frame to be in the middle of the screen
        this.setLocationRelativeTo(null);

        //Add the menu to the frame
        theMenu();

        //Add the text panel to the frame
        textPanel();

        //Add the commands to the frame
        cmdPanel();

        worldNews.setText(riskGame.getGameStatus());
    }

    private void theMenu(){

        //Making the menu bar
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        //A game menu for menu bar
        JMenu aMenu = new JMenu("File");
        menuBar.add(aMenu);

        //A help menu that display what the player can do
        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);


        //A load game item for menu (for M4)
        loadGame = new JMenuItem("Load Game");
        aMenu.add(loadGame);

        //A save game item for menu (for M4)
        saveGame = new JMenuItem("Save");
        aMenu.add(saveGame);

        //A quit game item for menu
        quitGame = new JMenuItem("Quit");
        aMenu.add(quitGame);

        //exits the game when used
        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    /**
     * This panel holds all the commands the player can use.
     */
    private void cmdPanel() {

        // Dice dice = new Dice();

        JPanel temp = new JPanel();
        temp.setBackground(Color.pink);

        //Create the panel to store the buttons and the Dice
        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(300, 0));
        westPanel.setBackground(Color.CYAN);

        //Make the attack button
        atk = new JButton("Attack");
        atk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                riskGame.attackCMD();
            }
        });

        //Make the status button
        stat = new JButton("Game Status");
        stat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                worldNews.append("\n" + riskGame.getGameStatus());
            }
        });

        //Make the endturn button
        nTurn = new JButton("Endturn");
        nTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                riskGame.nextPlayer();
                worldNews.append("\n" + riskGame.getGameStatus());
            }
        });

        //A box to store the buttons inside
        Box box = Box.createVerticalBox();

        //Adding atk to the box, aligning it, and spacing it from the following button
        box.add(atk);
        box.add(Box.createVerticalStrut(10));
        atk.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Adding status to the box, aligning it, and spacing it from the following button
        box.add(stat);
        box.add(Box.createVerticalStrut(550));
        stat.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Adding endturn to the box, aligning it
        box.add(nTurn);
        nTurn.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        //Adding the box to the panel
        westPanel.add(box);

        this.add(temp, BorderLayout.CENTER);

        //Adding the panel to the west side of the frame
        this.add(westPanel, BorderLayout.WEST);
        this.setVisible(true);

        //playerStatPanel.add(dice ,BorderLayout.SOUTH);



    }

    /**
     * This panel displays the information of the game, like the current state of the game.
     *
     */
    private void textPanel() {

        //Create a panel for the text
        JPanel southPanel = new JPanel();
        //Nice little design layout for the title of the panel
        southPanel.setBorder(new TitledBorder(new EtchedBorder(), "World News"));

        //Make a text area that resides in the panel
        worldNews = new JTextArea(16, 130);
        worldNews.setEditable(false);
        //Make it scrollable
        JScrollPane scroll = new JScrollPane(worldNews);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        //Add the scroll to the panel
        southPanel.add(scroll);

        //Add the panel to the south side of the frame
        this.add(southPanel, BorderLayout.SOUTH);

        //Scroll automatically goes at the bottom of the text
        DefaultCaret caret = (DefaultCaret) worldNews.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

    }

    /**
     * Creates a frame that request the users to select the amount of players
     * playing the game and starts the game once selected
     */
    private void starter() {

        JFrame f = new JFrame();

        f.setTitle("Risk!");

        f.setLayout(new BorderLayout());
        f.setSize(500,100);

        //A panel for the buttons
        JPanel aPanel = new JPanel();
        aPanel.setLayout(new FlowLayout());

        //A label that shows a text requesting the user to do something
        JLabel label = new JLabel("\n Select the number of Players playing.");
        //Align the label to be centered to the frame
        label.setHorizontalAlignment(JLabel.CENTER);
        label.setVerticalAlignment(JLabel.CENTER);

        //Creating the buttons for each number of players

        JButton b2 = new JButton("2 Players");
        b2.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = 2;
                f.dispose();
                initializeGame();
            }
        });

        JButton b3 = new JButton("3 Players");
        b3.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = 3;
                f.dispose();
                initializeGame();
            }
        });

        JButton b4 = new JButton("4 Players");
        b4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = 4;
                f.dispose();
                initializeGame();
            }
        });

        JButton b5 = new JButton("5 Players");
        b5.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = 5;
                f.dispose();
                initializeGame();
            }
        });

        JButton b6 = new JButton("6 Players");
        b6.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                numPlayers = 6;
                f.dispose();
                initializeGame();
            }
        });

        //Adding the buttons to the panel

        aPanel.add(b2);
        aPanel.add(b3);
        aPanel.add(b4);
        aPanel.add(b5);
        aPanel.add(b6);

        //Spacing the panel away from the label
        aPanel.add(Box.createVerticalStrut(50));

        //Adding the label to North and the panel to the Center
        f.add(label, BorderLayout.NORTH);
        f.add(aPanel, BorderLayout.CENTER);

        //Centering the frame to be in the middle of the screen
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        f.setResizable(false);

        /*
        //Takes Users typed input
        String input = JOptionPane.showInputDialog(f, "Welcome to Risk! \n" +
                "Risk is a turn-based world domination game. \n" + "\n Enter a number of players between 2 and 6");

        numPlayers = Integer.parseInt(input);

        if (numPlayers < 2) {
            JOptionPane.showMessageDialog(f, "Not enough players!", "Alert", JOptionPane.WARNING_MESSAGE);
            starter();
            return;
        }

        // If the number of players exceeds 6 request a different number of player
        else if (numPlayers > 6) {
            JOptionPane.showMessageDialog(f, "Too many players!", "Alert", JOptionPane.WARNING_MESSAGE);
            starter();
            return;
        }

        else {

        }

         */
    }

    public static void main(String[] args) {
        new RiskView();
    }
}
