/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.combat;

import hukkis.hyviksiijapahiksii.creatures.Unit;
import hukkis.hyviksiijapahiksii.creatures.CompareSpeed;
import hukkis.hyviksiijapahiksii.party.Party;
import java.util.*;

/**
 * Combat logic unit.
 *
 * @author oolli
 */
public class Combat {

    private boolean flee;
    private Party player;

    private final Random rand;
    private Party enemy;
    private final Scanner scan;
    private ArrayList<Unit> turnList;

    /**
     * Starts a new combat with player party and enemy party.
     *
     * @param scan adds scanner to the class.
     * @param rand adds random to the class.
     */
    public Combat(Random rand, Scanner scan) {
        this.flee = false;
        this.rand = rand;
        this.scan = scan;

    }

    /**
     * Starts a new combat with and enemy.
     *
     * @param player party controlled by the player.
     * @param enemy party controlled by the computer.
     *
     */
    public void newCombat(Party player, Party enemy) {
        this.player = player;
        this.enemy = enemy;

    }

    /**
     * Uses unit compare speed class to determine the turns for each creature.
     *
     * @param player party.
     * @param enemy party.
     * @return the new list that contains both sorted by speed.
     */
    public List determineTurns(Party player, Party enemy) {
        this.turnList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            this.turnList.add(player.creature(i));
        }
        for (int i = 0; i <= 5; i++) {
            this.turnList.add(enemy.creature(i));
        }
        CompareSpeed compareTool = new CompareSpeed(this.rand);
        this.turnList.sort(compareTool);
        return this.turnList;

    }

    /**
     * This loop will go on until either the player team, or the enemy team is
     * dead.
     *
     *
     */
    /**
     * Players creature will attack the target unit.
     *
     * @param target in the enemy party, which will be hit.
     * @param unit Gives the turn to an enemy unit.
     * @return if the hit was successful.
     */
    public boolean playerUnitHit(int target, Unit unit) {
        //Jos vastustaja on hengissä niin hyökätään
        boolean turnSuccesful = false;
        if (enemy.creature(target).getStatus().equals("alive")) {
            if (unit.getReach() == 6) { //Deals damage to every enemy.
                for (int i = 0; i <= 5; i++) {
                    int extraDamage = unit.getAttack() + this.rand.nextInt(6);
                    this.enemy.creature(i).takeDamage(extraDamage);

                }
            } else {    //Deals damage only to the target enemy
                int extraDamage = unit.getAttack() + this.rand.nextInt(6);
                this.enemy.creature(target).takeDamage(extraDamage);

            }
            turnSuccesful = true;   //If the target enemy was a valid target, return true;
        }
        return turnSuccesful;
    }

    /**
     * Enemy creature turn.
     *
     * @param unit Gives the turn to an enemy unit.
     */
    public void enemyTurn(Unit unit) {

        if (endCombat() == true) {
            return;
        }

        //Jos vastustaja on hengissä, hän hyökkää
        if ("alive".equals(unit.getStatus())) {

            //Etsitään mahdollinen hyökkäyskohde ( Alkeellinen tekoäly)
            for (int target = 0; target <= 5; target++) {
                //jos vastustajaan voi hyökätä, hyökkää, muuten hyökkää toiseen
                if (player.creature(target).getStatus().equals("alive")) {
                    int extraDamage = unit.getAttack() + this.rand.nextInt(6);
                    this.player.creature(target).takeDamage(extraDamage);
                    if (unit.getReach() == 1) {
                        break;
                    }
                }

            }

        }

    }

    /**
     * Checks if combat needs to be ended.
     *
     * @return true if it does.
     */
    public boolean endCombat() {
        if (this.player.wiped() == true || this.flee == true || this.enemy.wiped() == true) {

            return true;
        }
        return false;

    }

    /**
     * Is called when player chooses to flee the battle. Ends the battle.
     */
    public void flee() {
        this.flee = true;
    }

    /**
     * Can be used to make sure that the flee option is false at the start of
     * the combat.
     */
    public void notFleeing() {
        this.flee = false;
    }
}
