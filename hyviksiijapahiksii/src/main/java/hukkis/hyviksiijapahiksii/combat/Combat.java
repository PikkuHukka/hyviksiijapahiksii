/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.combat;

import hukkis.hyviksiijapahiksii.party.Party;

/**
 *
 * @author oolli
 */
public class Combat {

    private boolean end;
    private Party player;

    public Combat(Party player) {
        this.end = false;
        this.player = player;
        Party enemyParty = new Party();
        Battlemap map = new Battlemap(playerParty);
        
    }

    public void combatloop() {
        while (this.end == false) {

            if (this.player.wiped() == true) {
                System.out.println("You won!");
                break;
            }// else if(this.enemy.wiped() == true) {
               /// System.out.println("You los");
            //}
        }

    }
}
