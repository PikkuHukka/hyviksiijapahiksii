/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii;

import java.util.*;

/**
 *
 * @author oolli
 */
public class Main {

    public static void main(String[] args) {

        Creature uusi = new Creature("Squire");
        System.out.println(uusi);
        uusi.takeDamage(50);

        System.out.println(uusi);
        uusi.takeDamage(-10);
        System.out.println(uusi);
        uusi.takeDamage(60);

        System.out.println(uusi);
    }
}
