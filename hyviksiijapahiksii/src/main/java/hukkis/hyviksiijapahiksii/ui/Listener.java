/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.ui;

import hukkis.hyviksiijapahiksii.combat.Combat;
import hukkis.hyviksiijapahiksii.creatures.Unit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;

/**
 *
 * @author oolli
 */
public class Listener implements ActionListener {

    private JButton p0;
    private JButton p1;
    private JButton p2;
    private JButton p3;
    private JButton p4;
    private JButton p5;
    private JButton p6;
    private JButton e0;
    private JButton e1;
    private JButton e2;
    private JButton e3;
    private JButton e4;
    private JButton e5;
    private JButton e6;
    private Combat combat;

    public Listener(Combat combat, JButton p0, JButton p1, JButton p2, JButton p3, JButton p4, JButton p5,
            JButton e0, JButton e1, JButton e2, JButton e3, JButton e4, JButton e5) {
        this.combat = combat;
        this.e0 = e0;
        this.e1 = e1;
        this.e2 = e2;
        this.e3 = e3;
        this.e4 = e4;
        this.e5 = e5;
        this.p0 = p0;
        this.p1 = p1;
        this.p2 = p2;
        this.p3 = p3;
        this.p4 = p4;
        this.p5 = p5;

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

}
