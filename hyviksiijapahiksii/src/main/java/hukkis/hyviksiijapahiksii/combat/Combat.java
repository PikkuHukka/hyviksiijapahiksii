/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.combat;

import hukkis.hyviksiijapahiksii.creatures.Creature;
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

    private boolean end;
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
        this.end = false;
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
        combatLoop();
        if (enemy.wiped() == true) {
            System.out.println("Battle won!");
        } else {
            System.out.println("Battle lost!");
        }
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
    public void combatLoop() {

        while (this.end == false) {
            List<Unit> list = determineTurns(this.player, this.enemy);

            for (int i = 0; i < 12; i++) {

                if (list.get(i).friendly() == true) {
                    playerTurn(list.get(i));
                } else {
                    enemyTurn(list.get(i));
                }
            }
        }

    }

    /**
     * Players creature has the attack turn.
     *
     * @param unit Gives the turn to an enemy unit.
     */
    public void playerTurn(Unit unit) {
        //Player party hyökkää

        if (endCombat() == true) {
            return;
        }
        boolean turnSuccesful = false;
        while (turnSuccesful == false) {

            //jos hahmo on elossa niin
            if ("alive".equals(unit.status())) {
                System.out.println(unit.name() + " attacking. " + unit.attack() + " attack");
                System.out.println("Which enemy do you want to attack? 0-5");

                int target = scan.nextInt();

                turnSuccesful = playerUnitHit(target, unit, turnSuccesful);
            }

        }

    }

    public boolean playerUnitHit(int target, Unit unit, boolean turnSuccesful) {
        //Jos vastustaja on hengissä niin hyökätään
        if (enemy.creature(target).status().equals("alive")) {
            int extraDamage = unit.attack() + this.rand.nextInt(6);
            System.out.println("Your " + unit.name() + " attacks and deals " + extraDamage);
            this.enemy.creature(target).takeDamage(extraDamage);
            turnSuccesful = true;
            System.out.println("POW!");

        } else {
            System.out.println("No such target.");

        }
        return turnSuccesful;
    }

    /**
     * Enemy creature turn.
     *
     * @param unit Gives the turn to an enemy unit.
     */
    private void enemyTurn(Unit unit) {

        if (endCombat() == true) {
            return;
        }

        //Jos vastustaja on hengissä, hän hyökkää
        if ("alive".equals(unit.status())) {

            //Etsitään mahdollinen hyökkäyskohde ( Alkeellinen tekoäly)
            for (int target = 0; target <= 5; target++) {
                //jos vastustajaan voi hyökätä, hyökkää, muuten hyökkää toiseen
                if (player.creature(target).status().equals("alive")) {
                    int extraDamage = unit.attack() + this.rand.nextInt(6);
                    System.out.println("Enemy " + unit.name() + " attacked and dealt " + extraDamage + " damage");
                    this.player.creature(target).takeDamage(extraDamage);
                    if (unit.reach() == 1) {
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
        if (this.player.wiped() == true) {
            this.end = true;

            return true;
        } else if (this.enemy.wiped() == true) {
            this.end = true;

            return true;
        } else {
            return false;
        }
    }

    public ArrayList<Unit> getList(int i) {
        return this.turnList;
    }

}
