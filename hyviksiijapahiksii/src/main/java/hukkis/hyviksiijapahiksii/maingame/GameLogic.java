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
import hukkis.hyviksiijapahiksii.party.EnemyPartyGenerator;
import hukkis.hyviksiijapahiksii.party.Party;
import hukkis.hyviksiijapahiksii.ui.MainMenu;
import hukkis.hyviksiijapahiksii.ui.CombatMenu;
import java.util.*;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 * Basic game logic class.
 *
 * @author oolli
 */
public class GameLogic {

    private final Random rand;
    private PartyMaker partyMaker;
    private Party playerParty;
    private Scanner scan;

    /**
     * Just to add the scanner and the random class.
     *
     *
     */
    public GameLogic() {
        this.rand = new Random();
        this.partyMaker = new PartyMaker();
        this.scan = new Scanner(System.in);
    }

    /**
     * Add creatures to the party
     *
     * @param playerParty
     */
    public void startCombatMenu() {
        EnemyPartyGenerator generator = new EnemyPartyGenerator(this.rand);
        Party enemyParty = generator.createParty();
        
        Combat combat = new Combat(this.rand, this.scan);
        CombatMenu combatMenuFrame = new CombatMenu(combat, playerParty, enemyParty);
        combatMenuFrame.run(combat, playerParty, enemyParty);
        
        
     

    }

    public void createWarriorParty(String heroName) {
        this.playerParty = new Party(true);
        this.playerParty = this.partyMaker.createWarriorParty(playerParty, heroName);
    }

    public void createRangerParty(String heroName) {
        this.playerParty = new Party(true);
        this.playerParty = this.partyMaker.createRangerParty(playerParty, heroName);
    }

    public void createWizardParty(String heroName) {
        this.playerParty = new Party(true);
        this.playerParty = this.partyMaker.createWizardParty(playerParty, heroName);
    }
}
