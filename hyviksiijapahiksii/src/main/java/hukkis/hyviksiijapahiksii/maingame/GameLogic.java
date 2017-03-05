/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.maingame;

import hukkis.hyviksiijapahiksii.combat.Combat;
import hukkis.hyviksiijapahiksii.party.Party;
import hukkis.hyviksiijapahiksii.ui.CombatMenuGUI;
import java.util.*;

/**
 * Basic game logic class.
 *
 * @author oolli
 */
public class GameLogic {

    private final Random rand;
    private PlayerPartyGenerator partyMaker;
    private Party playerParty;
    private Scanner scan;

    /**
     * Just to add a scanner, random generator and a PartyMaker for the logic.
     */
    public GameLogic() {
        this.rand = new Random();
        this.partyMaker = new PlayerPartyGenerator();
        this.scan = new Scanner(System.in);
    }

    /**
     * Starts the combat window.
     *
     */
    public void startCombatMenu() {
        Party enemyParty = new Party(false);

        Combat combat = new Combat(this.rand, this.scan);
        CombatMenuGUI combatMenuFrame = new CombatMenuGUI(combat, playerParty, enemyParty);
        combatMenuFrame.run(combat, playerParty, enemyParty);

    }

    /**
     * Calls the PartyMaker to create a party with 3 creatures and the hero.
     *
     * @param heroName the name for the hero.
     */
    public void createWarriorParty(String heroName) {
        this.playerParty = new Party(true);
        this.playerParty = this.partyMaker.createWarriorParty(playerParty, heroName);
    }

    /**
     * Calls the PartyMaker to create a party with 3 creatures and the hero.
     *
     * @param heroName the name for the hero.
     */
    public void createRangerParty(String heroName) {
        this.playerParty = new Party(true);
        this.playerParty = this.partyMaker.createRangerParty(playerParty, heroName);
    }

    /**
     * Calls the PartyMaker to create a party with 3 creatures and the hero.
     *
     * @param heroName the name for the hero.
     */
    public void createWizardParty(String heroName) {
        this.playerParty = new Party(true);
        this.playerParty = this.partyMaker.createWizardParty(playerParty, heroName);
    }

}
