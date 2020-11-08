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

        starter();

        riskGame = new Game(numPlayers);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        RiskController riskCtrl = new RiskController();

        this.setLayout(new BorderLayout());
        this.setVisible(true);
        this.setResizable(false);
        this.setPreferredSize(new Dimension(1500,1000));
        this.pack();

        theMenu();
        textPanel();
        cmdPanel();

        DefaultCaret caret = (DefaultCaret) worldNews.getCaret();
        caret.setUpdatePolicy(DefaultCaret.ALWAYS_UPDATE);

        worldNews.setText(riskGame.getGameStatus());
        //riskGame.play();


    }

    private void theMenu(){
        //Making the menu bar
        JMenuBar menuBar = new JMenuBar();
        this.setJMenuBar(menuBar);

        //A game menu for menu bar
        JMenu aMenu = new JMenu("File");
        menuBar.add(aMenu);

        JMenu helpMenu = new JMenu("Help");
        menuBar.add(helpMenu);


        //A load game item for menu
        loadGame = new JMenuItem("Load Game");
        aMenu.add(loadGame);

        //A save game item for menu
        saveGame = new JMenuItem("Save");
        aMenu.add(saveGame);

        //A quit game item for menu
        quitGame = new JMenuItem("Quit");
        aMenu.add(quitGame);

        quitGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });

    }

    private void cmdPanel() {

        // Dice dice = new Dice();

        JPanel temp = new JPanel();
        temp.setBackground(Color.pink);

        JPanel westPanel = new JPanel();
        westPanel.setPreferredSize(new Dimension(300, 0));
        westPanel.setBackground(Color.CYAN);

        atk = new JButton("Attack");
        atk.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                riskGame.attackCMD();
            }
        });


        stat = new JButton("Game Status");
        stat.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                worldNews.append("\n" + riskGame.getGameStatus());
            }
        });

        nTurn = new JButton("Endturn");
        nTurn.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                riskGame.nextPlayer();
                worldNews.append("\n" + riskGame.getGameStatus());
            }
        });

        Box box = Box.createVerticalBox();

        box.add(atk);
        box.add(Box.createVerticalStrut(10));
        atk.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        box.add(stat);
        box.add(Box.createVerticalStrut(550));
        stat.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        box.add(nTurn);
        nTurn.setAlignmentX(JComponent.CENTER_ALIGNMENT);

        westPanel.add(box);

        this.add(temp, BorderLayout.CENTER);

        this.add(westPanel, BorderLayout.WEST);
        this.setVisible(true);

        //playerStatPanel.add(dice ,BorderLayout.SOUTH);



    }

    private void textPanel() {

        JPanel southPanel = new JPanel();
        southPanel.setBorder(new TitledBorder(new EtchedBorder(), "World News"));

        worldNews = new JTextArea(15, 130);
        worldNews.setEditable(false);
        JScrollPane scroll = new JScrollPane(worldNews);
        scroll.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);

        southPanel.add(scroll);

        this.add(southPanel, BorderLayout.SOUTH);
    }

    private void starter() {

        JFrame f = new JFrame();

        String input = JOptionPane.showInputDialog(f, "Welcome to Risk! \n" +
                "Risk is a turn-based world domination game. \n" + "\n Enter a number of players between 2 and 6");

        numPlayers = Integer.parseInt(input);
    }

    public static void main(String[] args) {
        new RiskView();
    }
}
