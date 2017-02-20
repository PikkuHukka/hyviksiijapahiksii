package hukkis.hyviksiijapahiksii.ui;

import hukkis.hyviksiijapahiksii.creatures.Hero;
import hukkis.hyviksiijapahiksii.party.Party;
import java.awt.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.imageio.stream.FileImageInputStream;
import javax.swing.*;

/**
 * Creates window for the party management.
 *
 * @author oolli
 */
public class CombatMenu extends JPanel {

    private Party playerParty;
    JFrame frame;
    JLabel picture;
    private Party enemyParty;

    /**
     * Setup for party window.
     * @param playerParty
     * @param enemyParty
     */
    public CombatMenu(Party playerParty, Party enemyParty) {
        this.playerParty = playerParty;
        this.enemyParty = enemyParty;
        JPanel content = new JPanel(new GridLayout(4, 1, 1, 1));
        JPanel playerPanel = new JPanel(new GridLayout(2, 3, 1, 1));
        JPanel enemyPanel = new JPanel(new GridLayout(2, 3, 1, 1));

        for (int i = 0; i <= 5; i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(150, 150));
            try {
                Image img = ImageIO.read(new FileImageInputStream(new File("src/main/java/hukkis/hyviksiijapahiksii/images/"
                        + this.playerParty.creature(i).name()
                        + ".png")));

                button.setIcon(new ImageIcon(img));
                playerPanel.add(button);

            } catch (Exception ex) {
                System.out.println(ex);
            }
        }

        for (int i = 0; i <= 5; i++) {
            JButton button = new JButton();
            button.setPreferredSize(new Dimension(150, 150));

            try {
                Image img = ImageIO.read(new FileImageInputStream(new File("src/main/java/hukkis/hyviksiijapahiksii/images/"
                        + this.enemyParty.creature(i).name()
                        + ".png")));
                button.setIcon(new ImageIcon(img));

                enemyPanel.add(button);
            } catch (Exception ex) {
                System.out.println(ex);
            }
        }
   
     
        content.add(playerPanel);
        content.add(enemyPanel);
        add(content);

    }

    /**
     * Creates combat frame.
     *
     */
    public void createFrame() {

        this.frame = new JFrame("Uusi Ikkuna");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new CombatMenu(this.playerParty, this.enemyParty);
        newContentPane.setOpaque(true);
        this.frame.setContentPane(newContentPane);

        this.frame.pack();
        this.frame.setVisible(true);

    }

    public void combatMenuFrame() {
        javax.swing.SwingUtilities.invokeLater(new Runnable() {
            @Override
            public void run() {

                createFrame();

            }
        });
    }

}
