package hukkis.hyviksiijapahiksii.ui;

import hukkis.hyviksiijapahiksii.creatures.Hero;
import hukkis.hyviksiijapahiksii.maingame.GameLogic;
import hukkis.hyviksiijapahiksii.party.Party;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.*;
import java.util.*;
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

    /** Setup for main menu window.
     *
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
            startGame.addActionListener(new ActionListener() {

                @Override
                public void actionPerformed(ActionEvent e) {
                    
                    Party playerParty = new Party(true);

                    if (rangerButton.isSelected()) {
                        Hero hero = new Hero(heroName.getText(), "Ranger");
                        playerParty.addCreature(hero, 0);
                    }
                    if (warriorButton.isSelected()) {
                        Hero hero = new Hero(heroName.getText(), "Warrior");
                        playerParty.addCreature(hero, 0);

                    }
                    if (wizardButton.isSelected()) {

                        Hero hero = new Hero(heroName.getText(), "Wizard");
                        playerParty.addCreature(hero, 0);

                    }

                    GameLogic gameLogic = new GameLogic(playerParty);
                }

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
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new MainMenu();
        newContentPane.setOpaque(true); //content panes must be opaque
        this.frame.setContentPane(newContentPane);

        this.frame.pack();
        this.frame.setVisible(true);
    }

    /** Can be used to close the main menu.
     *
     */
    public void closeMainMenu() {
        this.frame.setVisible(false);
        this.frame.dispose();
    }

    /**
     * Main user interface.
     */
    public void mainMenuFrame() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            public void run() {

                createFrame();

            }
        });
    }
}
