/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.maingame;

import hukkis.hyviksiijapahiksii.creatures.Creature;
import hukkis.hyviksiijapahiksii.creatures.Hero;
import hukkis.hyviksiijapahiksii.creatures.Unit;
import hukkis.hyviksiijapahiksii.party.Party;

/**
 * This class is used to create a party for the player.
 * Parties can later be customised.
 *
 * @author oolli
 */
public class PlayerPartyGenerator {

    /**
     * Returns the new wizard party.
     *
     * @param playerParty the party, which the creatures and the hero will be
     * added to.
     * @param heroName gives the party leader name.
     * @return the created party.
     *
     */
    public Party createWizardParty(Party playerParty, String heroName) {
        Hero hero = new Hero(heroName, "Wizard");
        playerParty.addCreature(hero, 5);
        Unit squire1 = new Creature("Squire", true);
        Unit squire2 = new Creature("Squire", true);
        Unit apprentice = new Creature("Archer", true);
        playerParty.addCreature(squire1, 0);
        playerParty.addCreature(squire2, 2);
        playerParty.addCreature(apprentice, 3);
        return playerParty;
    }

    /**
     * Returns the new warrior party.
     *
     * @param playerParty the party, which the creatures and the hero will be
     * added to.
     * @param heroName gives the party leader name.
     * @return the created party.
     */
    public Party createWarriorParty(Party playerParty, String heroName) {
        Hero hero = new Hero(heroName, "Warrior");
        playerParty.addCreature(hero, 0);
        Unit squire1 = new Creature("Squire", true);
        Unit apprentice = new Creature("Apprentice", true);
        Unit archer = new Creature("Archer", true);
        playerParty.addCreature(squire1, 2);
        playerParty.addCreature(apprentice, 5);
        playerParty.addCreature(archer, 3);
        return playerParty;
    }

    /**
     * Returns the new ranger party.
     *
     * @param playerParty the party, which the creatures and the hero will be
     * added to.
     * @param heroName gives the party leader name.
     * @return the created party.
     */
    public Party createRangerParty(Party playerParty, String heroName) {
        Unit squire1 = new Creature("Squire", true);
        Unit squire2 = new Creature("Squire", true);
        Unit archer = new Creature("Apprentice", true);
        playerParty.addCreature(squire1, 0);
        playerParty.addCreature(squire2, 2);
        playerParty.addCreature(archer, 3);
        Hero hero = new Hero(heroName, "Ranger");
        playerParty.addCreature(hero, 5);
        return playerParty;
    }
}
