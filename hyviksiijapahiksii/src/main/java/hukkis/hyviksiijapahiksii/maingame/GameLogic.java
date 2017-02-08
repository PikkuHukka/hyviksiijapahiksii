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

        
        Party player = new Party();
        Party enemy = new Party();
        Party enemy2 = new Party();
        Creature squire1 = new Creature("Archer");
        Creature squire2 = new Creature("Squire");
        Creature squire3 = new Creature("Squire");
        Creature squire4 = new Creature("Squire");
        Creature squire5 = new Creature("Squire");
        Creature squire6 = new Creature("Squire");
        player.addCreature(squire1, 0);
        player.addCreature(squire2, 1);
        player.addCreature(squire3, 2);
        enemy.addCreature(squire4, 0);
  

        Combat taistelu = new Combat(player, enemy, this.rand, this.scan);
        taistelu.combatLoop();
        
        //Combat taistelu2 = new Combat(player, enemy2, this.rand, this.scan);
      //  taistelu2.combatLoop();
         
    }
}
