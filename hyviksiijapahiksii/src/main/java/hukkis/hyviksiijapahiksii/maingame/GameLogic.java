/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.maingame;

import hukkis.hyviksiijapahiksii.combat.Combat;
import hukkis.hyviksiijapahiksii.creatures.Creature;
import hukkis.hyviksiijapahiksii.party.Party;
import java.util.*;

/**
 *
 * @author oolli
 */
public class GameLogic {

    private Scanner scan;
    private Random rand;

    public GameLogic(Scanner scan, Random rand) {
        this.scan = scan;
        this.rand = rand;
    }

    public void pelaaPeli() {

        Party player = new Party(true);
        Party enemy = new Party(false);
        Party enemy2 = new Party(false);
        Creature squire1 = new Creature("Squire", true);
        Creature squire2 = new Creature("Squire", true);
        Creature squire3 = new Creature("Squire", true);
        Creature squire4 = new Creature("Squire", false);
        Creature squire5 = new Creature("Squire", false);
        Creature squire6 = new Creature("Squire", false);
        player.addCreature(squire1, 5);
        //  player.addCreature(squire2, 1);
        // player.addCreature(squire3, 2);
        enemy.addCreature(squire4, 0);
        enemy2.addCreature(squire5, 0);
        enemy2.addCreature(squire6, 1);

        Combat taistelu = new Combat(this.rand, this.scan);
        taistelu.newCombat(player, enemy);
        //    taistelu.newCombat(player,enemy2);

    }
}
