/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.maingame;

import hukkis.hyviksiijapahiksii.combat.Combat;
import hukkis.hyviksiijapahiksii.creatures.Creature;
import hukkis.hyviksiijapahiksii.creatures.Hero;
import hukkis.hyviksiijapahiksii.creatures.Unit;
import hukkis.hyviksiijapahiksii.party.Party;
import hukkis.hyviksiijapahiksii.ui.MainMenu;
import hukkis.hyviksiijapahiksii.ui.PartyMenu;
import java.util.*;

/**
 * Basic game logic class.
 *
 * @author oolli
 */
public class GameLogic {

    private Party playerParty;
    private Random rand;

    /**
     * Just to add the scanner and the random class.
     *
     * @param party brings party from main menu.
     * 
     */
    public GameLogic(Party party) {
        this.rand = new Random();
        this.playerParty = party;
        startPartyMenu();
    }

    /**
     * Start a new game.
     *
     */
    public void startPartyMenu() {

        System.out.println(this.playerParty.creature(0));
        PartyMenu partyMenu = new PartyMenu();
        partyMenu.createFrame();
    }

}
