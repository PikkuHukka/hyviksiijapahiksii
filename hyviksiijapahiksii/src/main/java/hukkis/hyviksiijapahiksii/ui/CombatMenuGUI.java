package hukkis.hyviksiijapahiksii.ui;

import hukkis.hyviksiijapahiksii.combat.Combat;
import hukkis.hyviksiijapahiksii.creatures.Unit;
import hukkis.hyviksiijapahiksii.party.EnemyPartyGenerator;
import hukkis.hyviksiijapahiksii.party.Party;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

/**
 * GUI for Combat.
 *
 * @author oolli
 */
public class CombatMenuGUI extends javax.swing.JFrame {

    private Party enemyParty;
    private Party playerParty;
    private Combat combat;
    private List<Unit> turns;
    private int turn;
    boolean combatEnd;

    /**
     * Combat constructor.
     *
     * @param combat gives the combat to be executed by the GUI.
     * @param playerParty initiates the playerParty.
     * @param enemyParty initiates the enemyParty. Will be replaced later.
     */
    public CombatMenuGUI(Combat combat, Party playerParty, Party enemyParty) {
        this.playerParty = playerParty;
        this.enemyParty = enemyParty;
        this.combat = combat;
        initComponents();
    }

    private void initComponents() {
        setResizable(false);
        enemyImage0 = new javax.swing.JLabel();
        enemyImage1 = new javax.swing.JLabel();
        enemyImage2 = new javax.swing.JLabel();
        enemyImage3 = new javax.swing.JLabel();
        enemyImage4 = new javax.swing.JLabel();
        enemyImage5 = new javax.swing.JLabel();
        playerImage0 = new javax.swing.JLabel();
        playerImage1 = new javax.swing.JLabel();
        playerImage2 = new javax.swing.JLabel();
        playerImage3 = new javax.swing.JLabel();
        playerImage4 = new javax.swing.JLabel();
        playerImage5 = new javax.swing.JLabel();
        enemyHP0 = new javax.swing.JFormattedTextField();
        enemyHP1 = new javax.swing.JFormattedTextField();
        enemyHP2 = new javax.swing.JFormattedTextField();
        enemyHP3 = new javax.swing.JFormattedTextField();
        enemyHP4 = new javax.swing.JFormattedTextField();
        enemyHP5 = new javax.swing.JFormattedTextField();
        playerHP0 = new javax.swing.JFormattedTextField();
        playerHP1 = new javax.swing.JFormattedTextField();
        playerHP2 = new javax.swing.JFormattedTextField();
        playerHP3 = new javax.swing.JFormattedTextField();
        playerHP4 = new javax.swing.JFormattedTextField();
        playerHP5 = new javax.swing.JFormattedTextField();
        updateUI();
        enemyHP0.setEditable(false);
        enemyHP1.setEditable(false);
        enemyHP2.setEditable(false);
        enemyHP3.setEditable(false);
        enemyHP4.setEditable(false);
        enemyHP5.setEditable(false);
        playerHP0.setEditable(false);
        playerHP1.setEditable(false);
        playerHP2.setEditable(false);
        playerHP3.setEditable(false);
        playerHP4.setEditable(false);
        playerHP5.setEditable(false);
        nextBattle = new javax.swing.JButton("New Battle");
        combatLogPanel = new javax.swing.JScrollPane();
        combatLog = new javax.swing.JTextArea(10, 15);
        combatLog.setEditable(false);
        teamSeparator = new javax.swing.JSeparator();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 520));
        setAlwaysOnTop(true);

        ArrayList<JLabel> enemyIcons = new ArrayList();
        enemyIcons.add(this.enemyImage0);
        enemyIcons.add(this.enemyImage1);
        enemyIcons.add(this.enemyImage2);
        enemyIcons.add(this.enemyImage3);
        enemyIcons.add(this.enemyImage4);
        enemyIcons.add(this.enemyImage5);
        for (int i = 0; i <= 5; i++) {
            InputStream is = getClass().getClassLoader().getResourceAsStream("images/" + this.enemyParty.creature(i).getName() + ".png");
            BufferedImage bf;
            try {
                bf = ImageIO.read(is);
                enemyIcons.get(i).setIcon(new ImageIcon(bf));
            } catch (IOException ex) {
                Logger.getLogger(MainMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        ArrayList<JLabel> playerIcons = new ArrayList();
        playerIcons.add(this.playerImage0);
        playerIcons.add(this.playerImage1);
        playerIcons.add(this.playerImage2);
        playerIcons.add(this.playerImage3);
        playerIcons.add(this.playerImage4);
        playerIcons.add(this.playerImage5);
        for (int i = 0; i <= 5; i++) {
            InputStream is = getClass().getClassLoader().getResourceAsStream("images/" + this.playerParty.creature(i).getName() + ".png");
            BufferedImage bf;
            try {
                bf = ImageIO.read(is);
                playerIcons.get(i).setIcon(new ImageIcon(bf));
            } catch (IOException ex) {
                Logger.getLogger(MainMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        nextBattle.addActionListener((java.awt.event.ActionEvent evt) -> {
            EnemyPartyGenerator generator = new EnemyPartyGenerator(new Random());
            this.enemyParty = new Party(false);
            this.enemyParty = generator.createParty();
            combat.newCombat(playerParty, enemyParty);
            combat.notFleeing();
            updateUI();
            while (combat.endCombat() == false) {
                this.turns = combat.determineTurns(playerParty, enemyParty);
                this.turn = 0;
                while (turn <= 11) {
                    if (this.combat.endCombat() == true) {
                        break;
                    }
                    this.turn();
                }
            }
        }
        );

        combatLogPanel.setViewportView(combatLog);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addComponent(enemyHP0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                        .addComponent(enemyHP1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addGroup(layout.createSequentialGroup()
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(enemyHP3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(enemyImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(playerHP0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(playerHP3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(playerImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(playerImage0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 52, Short.MAX_VALUE)
                                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                                .addComponent(enemyImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(enemyHP4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(enemyImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(playerHP1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(playerImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(playerHP4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                                .addComponent(playerImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                        .addGap(53, 53, 53))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(enemyImage0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(enemyImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(enemyHP2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(enemyHP5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(enemyImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(playerHP2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(playerImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(playerHP5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(playerImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addComponent(teamSeparator))
                        .addGap(47, 47, 47)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(combatLogPanel)
                                .addComponent(nextBattle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(combatLogPanel)
                        .addGap(19, 19, 19)
                        .addComponent(nextBattle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addContainerGap())
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(enemyHP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(enemyHP0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(enemyHP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(8, 8, 8)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(enemyImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(enemyImage0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(enemyImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(enemyHP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(enemyHP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(enemyHP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(enemyImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(enemyImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(enemyImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(teamSeparator, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(playerHP0, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerHP1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerHP2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(playerImage2, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerImage1, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerImage0, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(playerHP3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerHP4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerHP5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(playerImage4, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerImage3, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(playerImage5, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)))
        );

        pack();
    }

    private void updateUI() {
        if (!"Empty".equals(this.enemyParty.creature(0).getStatus())) {
            enemyHP0.setText(this.enemyParty.creature(0).getHP() + "/" + this.enemyParty.creature(0).getMaxHP());
        }
        if (!"Empty".equals(this.enemyParty.creature(1).getStatus())) {
            enemyHP1.setText(this.enemyParty.creature(1).getHP() + "/" + this.enemyParty.creature(1).getMaxHP());
        }
        if (!"Empty".equals(this.enemyParty.creature(2).getStatus())) {
            enemyHP2.setText(this.enemyParty.creature(2).getHP() + "/" + this.enemyParty.creature(2).getMaxHP());
        }
        if (!"Empty".equals(this.enemyParty.creature(3).getStatus())) {
            enemyHP3.setText(this.enemyParty.creature(3).getHP() + "/" + this.enemyParty.creature(3).getMaxHP());
        }
        if (!"Empty".equals(this.enemyParty.creature(4).getStatus())) {
            enemyHP4.setText(this.enemyParty.creature(4).getHP() + "/" + this.enemyParty.creature(4).getMaxHP());
        }
        if (!"Empty".equals(this.enemyParty.creature(5).getStatus())) {
            enemyHP5.setText(this.enemyParty.creature(5).getHP() + "/" + this.enemyParty.creature(5).getMaxHP());
        }
        if (!"Empty".equals(this.playerParty.creature(0).getStatus())) {
            playerHP0.setText(this.playerParty.creature(0).getHP() + "/" + this.playerParty.creature(0).getMaxHP());
        }
        if (!"Empty".equals(this.playerParty.creature(1).getStatus())) {
            playerHP1.setText(this.playerParty.creature(1).getHP() + "/" + this.playerParty.creature(1).getMaxHP());
        }
        if (!"Empty".equals(this.playerParty.creature(2).getStatus())) {
            playerHP2.setText(this.playerParty.creature(2).getHP() + "/" + this.playerParty.creature(2).getMaxHP());
        }
        if (!"Empty".equals(this.playerParty.creature(3).getStatus())) {
            playerHP3.setText(this.playerParty.creature(3).getHP() + "/" + this.playerParty.creature(3).getMaxHP());
        }
        if (!"Empty".equals(this.playerParty.creature(4).getStatus())) {
            playerHP4.setText(this.playerParty.creature(4).getHP() + "/" + this.playerParty.creature(4).getMaxHP());
        }

        if (!"Empty".equals(this.playerParty.creature(5).getStatus())) {

            playerHP5.setText(this.playerParty.creature(5).getHP() + "/" + this.playerParty.creature(5).getMaxHP());
        }

        ArrayList<JLabel> icons = new ArrayList();
        icons.add(this.enemyImage0);
        icons.add(this.enemyImage1);
        icons.add(this.enemyImage2);
        icons.add(this.enemyImage3);
        icons.add(this.enemyImage4);
        icons.add(this.enemyImage5);
        for (int i = 0; i <= 5; i++) {
            InputStream is = getClass().getClassLoader().getResourceAsStream("images/" + this.enemyParty.creature(i).getName() + ".png");
            BufferedImage bf;
            try {
                bf = ImageIO.read(is);
                icons.get(i).setIcon(new ImageIcon(bf));
            } catch (IOException ex) {
                Logger.getLogger(MainMenuGUI.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
    }

    /**
     * Runs the combat menu.
     *
     * @param combat Gives the combat class to be executed by the UI.
     * @param playerParty to the constructor.
     * @param enemyParty to the constructor.
     */
    public void run(Combat combat, Party playerParty, Party enemyParty) {

        java.awt.EventQueue.invokeLater(() -> {
            new CombatMenuGUI(combat, playerParty, enemyParty).setVisible(true);
        });
    }

    /**
     * Communicates with combat and updates the UI.
     */
    public void turn() {
        if ("alive".equals(this.turns.get(turn).getStatus())) {
            if (this.turns.get(turn).getFriendly() == false) {
                this.combatLog.append("\nEnemy " + this.turns.get(turn).getName() + " attacks!");
                this.combat.enemyTurn(this.turns.get(this.turn));
                this.turn++;
            } else {

                Object[] values = {"1", "2", "3", "4", "5", "6", "Flee from combat."};
                int targetWindow = JOptionPane.showOptionDialog(null,
                        "Select target\n Deals " + this.turns.get(turn).getAttack() + " damage.\nHits " + this.turns.get(turn).getReach() + " targets.", this.turns.get(turn).getName(),
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        values,
                        values[6]);

                if (targetWindow <= 5 && targetWindow >= 0) {

                    if (this.combat.playerUnitHit(targetWindow, this.turns.get(this.turn)) == true) {

                        this.combatLog.append("\nYour " + this.turns.get(this.turn).getName() + " attacked the\n enemy " + this.enemyParty.creature(targetWindow).getName());
                        turn++;
                    } else {
                        this.combatLog.append("\nInvalid target!");
                    }
                } else {
                    this.combat.flee();
                    turn++;
                    this.combatLog.append("\nYou fled the battle!");
                }

            }

        } else {
            turn++;
        }

        this.updateUI();
    }

// Variables declaration - do not modify                     
    private javax.swing.JLabel enemyImage0;
    private javax.swing.JLabel enemyImage1;
    private javax.swing.JLabel enemyImage2;
    private javax.swing.JLabel enemyImage3;
    private javax.swing.JLabel enemyImage4;
    private javax.swing.JLabel enemyImage5;
    private javax.swing.JScrollPane combatLogPanel;
    private javax.swing.JTextArea combatLog;
    private javax.swing.JLabel playerImage0;
    private javax.swing.JLabel playerImage1;
    private javax.swing.JLabel playerImage2;
    private javax.swing.JLabel playerImage3;
    private javax.swing.JLabel playerImage4;
    private javax.swing.JLabel playerImage5;
    private javax.swing.JFormattedTextField enemyHP0;
    private javax.swing.JFormattedTextField enemyHP1;
    private javax.swing.JFormattedTextField enemyHP2;
    private javax.swing.JFormattedTextField enemyHP3;
    private javax.swing.JFormattedTextField enemyHP4;
    private javax.swing.JFormattedTextField enemyHP5;
    private javax.swing.JFormattedTextField playerHP0;
    private javax.swing.JFormattedTextField playerHP1;
    private javax.swing.JFormattedTextField playerHP2;
    private javax.swing.JFormattedTextField playerHP3;
    private javax.swing.JFormattedTextField playerHP4;
    private javax.swing.JFormattedTextField playerHP5;
    private javax.swing.JButton nextBattle;
    private javax.swing.JSeparator teamSeparator;

    // End of variables declaration                   
}
