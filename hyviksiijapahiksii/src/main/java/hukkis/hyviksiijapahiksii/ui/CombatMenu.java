package hukkis.hyviksiijapahiksii.ui;

import hukkis.hyviksiijapahiksii.combat.Combat;
import hukkis.hyviksiijapahiksii.creatures.Unit;
import hukkis.hyviksiijapahiksii.party.Party;
import java.util.List;
import javax.swing.ImageIcon;
import javax.swing.JOptionPane;

/**
 * GUI for Combat.
 *
 * @author oolli
 */
public class CombatMenu extends javax.swing.JFrame {

    private Party enemyParty;
    private Party playerParty;
    private Combat combat;
    private List<Unit> turns;
    private int turn;
    boolean combatEnd;

    /**
     *
     * @param combat
     * @param playerParty
     * @param enemyParty
     */
    public CombatMenu(Combat combat, Party playerParty, Party enemyParty) {
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
        updateHP();
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
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();
        jTextArea1.setEditable(false);
        teamSeparator = new javax.swing.JSeparator();
        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setPreferredSize(new java.awt.Dimension(650, 520));
        setAlwaysOnTop(true);

        enemyImage0.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(0).name() + ".png"));
        enemyImage1.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(1).name() + ".png"));
        enemyImage2.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(2).name() + ".png"));
        enemyImage3.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(3).name() + ".png"));
        enemyImage4.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(4).name() + ".png"));
        enemyImage5.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(5).name() + ".png"));
        playerImage0.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(0).name() + ".png"));
        playerImage1.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(1).name() + ".png"));
        playerImage2.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(2).name() + ".png"));
        playerImage3.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(3).name() + ".png"));
        playerImage4.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(4).name() + ".png"));
        playerImage5.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(5).name() + ".png"));

        nextBattle.addActionListener((java.awt.event.ActionEvent evt) -> {
            combat.newCombat(playerParty, enemyParty);
            while (combat.endCombat() == false) {
                this.turns = combat.determineTurns(playerParty, enemyParty);
                this.turn = 0;
                while (turn <= 11) {
                    if (this.combat.endCombat() == true) {
                        break;
                    }
                    System.out.println("new turn");
                    this.turn();
                }
            }
        }
        );

        jTextArea1.setColumns(15);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

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
                                .addComponent(jScrollPane1)
                                .addComponent(nextBattle, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jScrollPane1)
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

    private void updateHP() {
        if (!"Empty".equals(this.enemyParty.creature(0).status())) {

            enemyHP0.setText(this.enemyParty.creature(0).hp() + "/" + this.enemyParty.creature(0).maxhp());
        }
        if (!"Empty".equals(this.enemyParty.creature(1).status())) {
            enemyHP1.setText(this.enemyParty.creature(1).hp() + "/" + this.enemyParty.creature(1).maxhp());
        }
        if (!"Empty".equals(this.enemyParty.creature(2).status())) {
            enemyHP2.setText(this.enemyParty.creature(2).hp() + "/" + this.enemyParty.creature(2).maxhp());
        }
        if (!"Empty".equals(this.enemyParty.creature(3).status())) {
            enemyHP3.setText(this.enemyParty.creature(3).hp() + "/" + this.enemyParty.creature(3).maxhp());
        }
        if (!"Empty".equals(this.enemyParty.creature(4).status())) {
            enemyHP4.setText(this.enemyParty.creature(4).hp() + "/" + this.enemyParty.creature(4).maxhp());
        }
        if (!"Empty".equals(this.enemyParty.creature(5).status())) {
            enemyHP5.setText(this.enemyParty.creature(5).hp() + "/" + this.enemyParty.creature(5).maxhp());
        }
        if (!"Empty".equals(this.playerParty.creature(0).status())) {
            playerHP0.setText(this.playerParty.creature(0).hp() + "/" + this.playerParty.creature(0).maxhp());
        }
        if (!"Empty".equals(this.playerParty.creature(1).status())) {
            playerHP1.setText(this.playerParty.creature(1).hp() + "/" + this.playerParty.creature(1).maxhp());
        }
        if (!"Empty".equals(this.playerParty.creature(2).status())) {

            playerHP2.setText(this.playerParty.creature(2).hp() + "/" + this.playerParty.creature(2).maxhp());
        }
        if (!"Empty".equals(this.playerParty.creature(3).status())) {
            playerHP3.setText(this.playerParty.creature(3).hp() + "/" + this.playerParty.creature(3).maxhp());
        }
        if (!"Empty".equals(this.playerParty.creature(4).status())) {
            playerHP4.setText(this.playerParty.creature(4).hp() + "/" + this.playerParty.creature(4).maxhp());
        }

        if (!"Empty".equals(this.playerParty.creature(5).status())) {

            playerHP5.setText(this.playerParty.creature(5).hp() + "/" + this.playerParty.creature(5).maxhp());
        }
    }

    /**
     * @param combat
     * @param playerParty
     * @param enemyParty
     */
    public void run(Combat combat, Party playerParty, Party enemyParty) {

        java.awt.EventQueue.invokeLater(() -> {
            new CombatMenu(combat, playerParty, enemyParty).setVisible(true);
        });
    }

    /**
     * Communicates with combat and updates the UI.
     */
    public void turn() {
        if ("alive".equals(this.turns.get(turn).status())) {
            if (this.turns.get(turn).friendly() == false) {
                this.jTextArea1.append("\nEnemy " + this.turns.get(turn).name() + " attacks!");
                this.combat.enemyTurn(this.turns.get(this.turn));
                this.turn++;
            } else {

                Object[] values = {"0", "1", "2", "3", "4", "5", "Flee from combat."};
                int targetWindow = JOptionPane.showOptionDialog(null,
                        "Select target\n Deals " + this.turns.get(turn).attack() + " damage.\nHits " + this.turns.get(turn).reach() + " targets.", this.turns.get(turn).name(),
                        JOptionPane.PLAIN_MESSAGE,
                        JOptionPane.QUESTION_MESSAGE,
                        null,
                        values,
                        values[6]);

                if (targetWindow <= 5 && targetWindow >= 0) {

                    if (this.combat.playerUnitHit(targetWindow, this.turns.get(this.turn)) == true) {

                        this.jTextArea1.append("\nYour " + this.turns.get(this.turn).name() + " attacked the\n enemy " + this.enemyParty.creature(targetWindow).name());
                        turn++;
                    } else {
                        this.jTextArea1.append("\nInvalid target!");
                    }
                } else {
                    this.combat.flee();
                    turn++;
                    this.jTextArea1.append("\nYou fled the battle!");
                }

            }

        } else {
            turn++;
        }

        this.updateHP();
    }

// Variables declaration - do not modify                     
    private javax.swing.JLabel enemyImage0;
    private javax.swing.JLabel enemyImage1;
    private javax.swing.JLabel enemyImage2;
    private javax.swing.JLabel enemyImage3;
    private javax.swing.JLabel enemyImage4;
    private javax.swing.JLabel enemyImage5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
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
