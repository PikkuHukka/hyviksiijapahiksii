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
import javax.swing.*;

/**
 *Creates window for the party management.
 * @author oolli
 */
public class PartyMenu extends JPanel {

    private Party playerParty;
    JFrame frame;
    JLabel picture;

    /**
     *Setup for party window.
     */
    public PartyMenu() {
        super(new BorderLayout());

    }

    /**
     * Creates party frame.
     *
     */
    public void createFrame() {

        this.frame = new JFrame("Uusi Ikkuna");
        this.frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        JComponent newContentPane = new PartyMenu();
        newContentPane.setOpaque(true); //content panes must be opaque
        this.frame.setContentPane(newContentPane);

        this.frame.pack();
        this.frame.setVisible(true);
    }

}
