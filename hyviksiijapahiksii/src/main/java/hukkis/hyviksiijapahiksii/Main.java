/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii;

import hukkis.hyviksiijapahiksii.creatures.Creature;
import hukkis.hyviksiijapahiksii.party.Party;
import java.util.*;

/**
 *
 * @author oolli
 */
public class Main {

    public static void main(String[] args) {
        Party playerParty = new Party();
        Creature pete = new Creature("Squire");
        playerParty.addCreature(pete, "frontCenter");
        System.out.println(playerParty.creature("frontCenter").hp());
        playerParty.creature("frontCenter").takeDamage(99);
        System.out.println(playerParty.creature("frontCenter").hp());
        System.out.println(playerParty.wiped());
        System.out.println(playerParty.creature("frontRight"));
    }
}
