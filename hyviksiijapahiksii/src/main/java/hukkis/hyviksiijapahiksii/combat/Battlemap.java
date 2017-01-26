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
    private Party party2;

    public Battlemap(Party playerParty, Party p2) {
        this.playerParty = playerParty;
        this.party2 = party2;

    }

    public void testi() {

    }

    public boolean endOfBattle() {
        if (party1.wiped() == true) {
            return true;
        }else if (party2.wiped() == true) {
            return true;
        } else {
            return false;
        }
        
    }

}
