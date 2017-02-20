package hukkis.hyviksiijapahiksii.ui;

import hukkis.hyviksiijapahiksii.creatures.Creature;
import hukkis.hyviksiijapahiksii.creatures.Hero;
import hukkis.hyviksiijapahiksii.creatures.Unit;
import hukkis.hyviksiijapahiksii.maingame.GameLogic;
import hukkis.hyviksiijapahiksii.party.Party;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.*;
import javax.swing.*;

/**
 * Main menu for the game. Used to determine starting hero.
 *
 */
public class MainMenu extends JPanel
        implements ActionListener {

    static String warriorString = "Warrior";
    static String wizardString = "Wizard";
    static String archerString = "Ranger";
    private JFrame frame;
    private JLabel picture;

    /**
     * Setup for main menu window. Creates pre-made party defined by start
     * class.
     */
    public MainMenu() {
        super(new BorderLayout());
        try {
            JTextField heroName = new JTextField();

            JRadioButton warriorButton = new JRadioButton(warriorString);
            warriorButton.setActionCommand(warriorString);
            warriorButton.setSelected(true);

            JRadioButton wizardButton = new JRadioButton(wizardString);
            wizardButton.setActionCommand(wizardString);

            JRadioButton rangerButton = new JRadioButton(archerString);
            rangerButton.setActionCommand(archerString);

            JButton startGame = new JButton("New Game");
            startGame.addActionListener((ActionEvent e) -> {
                Party playerParty = new Party(true);
                GameLogic logic = new GameLogic();
                if (rangerButton.isSelected()) {
                    Hero hero = new Hero(heroName.getText(), "Ranger");
                    playerParty.addCreature(hero, 5);
                    Unit squire1 = new Creature("Squire", true);
                    Unit squire2 = new Creature("Squire", true);
                    Unit apprentice = new Creature("Apprentice", true);
                    playerParty.addCreature(squire1, 0);
                    playerParty.addCreature(squire2, 2);
                    playerParty.addCreature(apprentice, 3);

                } else if (warriorButton.isSelected()) {
                    Hero hero = new Hero(heroName.getText(), "Warrior");
                    playerParty.addCreature(hero, 0);
                    Unit squire1 = new Creature("Squire", true);
                    Unit apprentice = new Creature("Apprentice", true);
                    Unit archer = new Creature("Archer", true);
                    playerParty.addCreature(squire1, 2);
                    playerParty.addCreature(apprentice, 5);
                    playerParty.addCreature(archer, 3);

                } else if (wizardButton.isSelected()) {
                    Unit squire1 = new Creature("Squire", true);
                    Unit squire2 = new Creature("Squire", true);
                    Unit archer = new Creature("Archer", true);
                    playerParty.addCreature(squire1, 0);
                    playerParty.addCreature(squire2, 2);
                    playerParty.addCreature(archer, 3);

                    Hero hero = new Hero(heroName.getText(), "Wizard");
                    playerParty.addCreature(hero, 5);
                }
                logic.startPartyMenu(playerParty);

            });

            ButtonGroup group = new ButtonGroup();
            group.add(warriorButton);
            group.add(wizardButton);
            group.add(rangerButton);

            warriorButton.addActionListener(this);
            wizardButton.addActionListener(this);
            rangerButton.addActionListener(this);

            BufferedImage myPicture = ImageIO.read(new File("src/main/java/hukkis/hyviksiijapahiksii/images/Warrior.png"));
            picture = new JLabel(new ImageIcon(myPicture));

            picture.setPreferredSize(new Dimension(300, 300));

            JPanel radioPanel = new JPanel(new GridLayout(0, 1));
            radioPanel.add(warriorButton);
            radioPanel.add(wizardButton);
            radioPanel.add(rangerButton);

            add(heroName, BorderLayout.NORTH);
            add(radioPanel, BorderLayout.LINE_START);
            add(picture, BorderLayout.CENTER);
            add(startGame, BorderLayout.SOUTH);
            setBorder(BorderFactory.createEmptyBorder(20, 20, 20, 20));
        } catch (IOException ex) {
            Logger.getLogger(MainMenu.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    /**
     * Changes the picture when another class is clicked.
     *
     * @param e Class selected.
     */
    @Override
    public void actionPerformed(ActionEvent e) {

        picture.setIcon(new ImageIcon("src/main/java/hukkis/hyviksiijapahiksii/images/"
                + e.getActionCommand()
                + ".png"));
    }

    /**
     * Creates the frame and the pane for it.
     */
    public void createFrame() {

        this.frame = new JFrame("Hyviksii ja Pahiksii");
        this.frame.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JComponent newContentPane = new MainMenu();
        newContentPane.setOpaque(true);
        this.frame.setContentPane(newContentPane);

        this.frame.pack();
        this.frame.setVisible(true);
    }

    /**
     * Main user interface.
     *
     *
     */
    public void mainMenuFrame() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                createFrame();

            }
        });
    }
}
