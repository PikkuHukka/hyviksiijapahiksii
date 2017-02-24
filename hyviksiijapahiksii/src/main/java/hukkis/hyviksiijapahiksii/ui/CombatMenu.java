package hukkis.hyviksiijapahiksii.ui;

import hukkis.hyviksiijapahiksii.combat.Combat;
import hukkis.hyviksiijapahiksii.creatures.Unit;
import hukkis.hyviksiijapahiksii.party.Party;
import java.util.List;
import javax.swing.ImageIcon;

public class CombatMenu extends javax.swing.JFrame {

    private Party enemyParty;
    private Party playerParty;
    private Combat combat;
    private List<Unit> turns;

    public CombatMenu(Combat combat, Party playerParty, Party enemyParty) {
        this.playerParty = playerParty;
        this.enemyParty = enemyParty;
        this.combat = combat;
        initComponents();
    }

    private void initComponents() {

        enemyButton0 = new javax.swing.JButton();
        enemyButton3 = new javax.swing.JButton();
        playerButton0 = new javax.swing.JButton();
        playerButton3 = new javax.swing.JButton();
        enemyButton1 = new javax.swing.JButton();
        enemyButton2 = new javax.swing.JButton();
        enemyButton4 = new javax.swing.JButton();
        enemyButton5 = new javax.swing.JButton();
        playerButton1 = new javax.swing.JButton();
        playerButton2 = new javax.swing.JButton();
        playerButton4 = new javax.swing.JButton();
        playerButton5 = new javax.swing.JButton();
        nextBattle = new javax.swing.JButton("New Battle");
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextArea1 = new javax.swing.JTextArea();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        enemyButton0.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(0).name() + ".png"));
        
        enemyButton1.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(1).name() + ".png"));

        enemyButton2.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(2).name() + ".png"));

        enemyButton3.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(3).name() + ".png"));

        enemyButton4.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(4).name() + ".png"));

        enemyButton5.setIcon(new ImageIcon("src/main/resources/images/" + this.enemyParty.creature(5).name() + ".png"));

        playerButton0.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(0).name() + ".png"));

        playerButton1.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(1).name() + ".png"));

        playerButton2.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(2).name() + ".png"));

        playerButton3.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(3).name() + ".png"));

        playerButton4.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(4).name() + ".png"));

        playerButton5.setIcon(new ImageIcon("src/main/resources/images/" + this.playerParty.creature(5).name() + ".png"));

        nextBattle.addActionListener((java.awt.event.ActionEvent evt) -> {
            combat.newCombat(playerParty, enemyParty);
            
        });

        jTextArea1.setColumns(15);
        jTextArea1.setRows(5);
        jScrollPane1.setViewportView(jTextArea1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(playerButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(playerButton0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(enemyButton3, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(enemyButton0, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(enemyButton1, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(enemyButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(playerButton1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(playerButton4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(enemyButton2, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                .addComponent(enemyButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(playerButton2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(playerButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 200, Short.MAX_VALUE)
                                .addComponent(nextBattle, javax.swing.GroupLayout.DEFAULT_SIZE, 159, Short.MAX_VALUE)
                        )));
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                                .addComponent(enemyButton2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addComponent(enemyButton1, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(enemyButton0, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addComponent(enemyButton4, javax.swing.GroupLayout.DEFAULT_SIZE, 100, Short.MAX_VALUE)
                                                .addComponent(enemyButton3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(enemyButton5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, 37, Short.MAX_VALUE)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(playerButton0, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(playerButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addComponent(playerButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGap(18, 18, 18)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(playerButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(playerButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(playerButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 164, Short.MAX_VALUE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(nextBattle, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addContainerGap())
                        )));

        pack();
    }// </editor-fold>                           

    private void playerButton3ActionPerformed(java.awt.event.ActionEvent evt) {
        // TODO add your handling code here:
    }

    /**
     * @param args the command line arguments
     */
    public void run(Combat combat, Party playerParty, Party enemyParty) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new CombatMenu(combat, playerParty, enemyParty).setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify                     
    private javax.swing.JButton enemyButton0;
    private javax.swing.JButton enemyButton1;
    private javax.swing.JButton enemyButton2;
    private javax.swing.JButton enemyButton3;
    private javax.swing.JButton enemyButton4;
    private javax.swing.JButton enemyButton5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextArea jTextArea1;
    private javax.swing.JButton playerButton0;
    private javax.swing.JButton playerButton1;
    private javax.swing.JButton playerButton2;
    private javax.swing.JButton playerButton3;
    private javax.swing.JButton playerButton4;
    private javax.swing.JButton playerButton5;
    private javax.swing.JButton nextBattle;
    // End of variables declaration                   
}
