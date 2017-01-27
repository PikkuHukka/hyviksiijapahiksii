/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.combat;

import hukkis.hyviksiijapahiksii.party.Party;
import java.util.*;

/**
 *
 * @author oolli
 */
public class Battlemap {

    private Party playerParty;
    private Party enemyParty;

    public Battlemap(Party playerParty, Party p2) {
        this.playerParty = playerParty;
        this.enemyParty = enemyParty;

    }

    public void testi() {

    }

    public boolean endOfBattle() {
        if (playerParty.wiped() == true) {
            return true;
        } else if (enemyParty.wiped() == true) {
            return true;
        } else {
            return false;
        }

    }

}
