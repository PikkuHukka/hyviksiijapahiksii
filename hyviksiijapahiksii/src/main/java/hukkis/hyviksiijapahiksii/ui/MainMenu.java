package hukkis.hyviksiijapahiksii.ui;

import hukkis.hyviksiijapahiksii.maingame.GameLogic;
import java.awt.event.WindowEvent;
import javax.swing.ImageIcon;
import javax.swing.*;

/**
 * Main menu for the game. Used to determine starting hero.
 *
 */
public class MainMenu extends javax.swing.JFrame {

    private GameLogic logic;

    /**
     * Setup for main menu window. Creates pre-made party defined by start
     * class.
     *
     * @param logic
     */
    public MainMenu(GameLogic logic) {
        this.logic = logic;
        initComponents();
    }

    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        warriorButton = new javax.swing.JRadioButton();
        rangerButton = new javax.swing.JRadioButton();
        wizardButton = new javax.swing.JRadioButton();
        classPicture = new javax.swing.JLabel();
        characterSelectionScreenText = new javax.swing.JLabel();
        chooseClassText = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        jTextField = new javax.swing.JTextField();
        chooseCharacterNameText = new javax.swing.JLabel();
        startGameText = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        setAlwaysOnTop(true);

        buttonGroup1.add(warriorButton);
        warriorButton.setSelected(true);
        warriorButton.setText("Warrior");
        warriorButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                warriorButtonActionPerformed(evt);
            }
        });
        buttonGroup1.add(rangerButton);
        rangerButton.setText("Ranger");
        rangerButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rangerButtonActionPerformed(evt);
            }
        });

        buttonGroup1.add(wizardButton);
        wizardButton.setText("Wizard");
        wizardButton.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                wizardButtonActionPerformed(evt);
            }
        });
        classPicture.setIcon(new ImageIcon("src/main/resources/images/Warrior.png"));

        characterSelectionScreenText.setText("Character Selection Sreen");

        chooseClassText.setText("Choose a class");

        jScrollPane1.setViewportView(jTextField);

        chooseCharacterNameText.setText("Character name");

        startGameText.setText("Start game");
        startGameText.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(layout.createSequentialGroup()
                                        .addContainerGap()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addComponent(warriorButton)
                                                .addComponent(wizardButton)
                                                .addComponent(chooseClassText)
                                                .addComponent(startGameText)
                                                .addComponent(rangerButton))
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                        .addComponent(classPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGroup(layout.createSequentialGroup()
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGap(98, 98, 98)
                                                        .addComponent(characterSelectionScreenText))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addContainerGap()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 222, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(chooseCharacterNameText))))
                                        .addGap(0, 232, Short.MAX_VALUE)))
                        .addContainerGap())
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(characterSelectionScreenText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 21, Short.MAX_VALUE)
                        .addComponent(chooseCharacterNameText)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addGroup(layout.createSequentialGroup()
                                        .addComponent(chooseClassText)
                                        .addGap(18, 18, 18)
                                        .addComponent(warriorButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(rangerButton)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(wizardButton)
                                        .addGap(33, 33, 33)
                                        .addComponent(startGameText))
                                .addComponent(classPicture, javax.swing.GroupLayout.PREFERRED_SIZE, 173, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
        );

        pack();
    }

    private void warriorButtonActionPerformed(java.awt.event.ActionEvent evt) {
        classPicture.setIcon(new ImageIcon("src/main/resources/images/Warrior.png"));
    }

    private void rangerButtonActionPerformed(java.awt.event.ActionEvent evt) {
        classPicture.setIcon(new ImageIcon("src/main/resources/images/Ranger.png"));

    }

    private void wizardButtonActionPerformed(java.awt.event.ActionEvent evt) {
        classPicture.setIcon(new ImageIcon("src/main/resources/images/Wizard.png"));

    }

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {

        if (this.warriorButton.isSelected()) {
            logic.createWarriorParty(this.jTextField.getText());

        }
        if (this.rangerButton.isSelected()) {
            logic.createRangerParty(this.jTextField.getText());

        }
        if (this.wizardButton.isSelected()) {
            logic.createWizardParty(this.jTextField.getText());

        }
        logic.startCombatMenu();
        
dispose();
    }

    public void run(GameLogic logic) {

        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainMenu(logic).setVisible(true);
            }
        });
    }

    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel classPicture;
    private javax.swing.JButton startGameText;
    private javax.swing.JLabel characterSelectionScreenText;
    private javax.swing.JLabel chooseClassText;
    private javax.swing.JLabel chooseCharacterNameText;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTextField jTextField;
    private javax.swing.JRadioButton rangerButton;
    private javax.swing.JRadioButton warriorButton;
    private javax.swing.JRadioButton wizardButton;
}
