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
 *
 * @author oolli
 */
public class Combat {

    private boolean end;
    private Party player;

    private Random rand;
    private Party enemy;
    private Scanner scan;
    private ArrayList<Unit> turns;

    public Combat(Random rand, Scanner scan) {
        this.end = false;
        this.rand = rand;
        this.scan = scan;

    }

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
//Parametrejä ei tarvitsisi, mutta ne helpottavat testaamista

    public List determineTurns(Party player, Party enemy) {
        List turnList = new ArrayList<>();
        for (int i = 0; i <= 5; i++) {
            turnList.add(player.creature(i));
        }
        for (int i = 0; i <= 5; i++) {
            turnList.add(enemy.creature(i));
        }
        CompareSpeed compareTool = new CompareSpeed(this.rand);
        turnList.sort(compareTool);
        return turnList;

    }

    public void combatLoop() {

        while (this.end == false) {
            List<Unit> list = determineTurns(this.player, this.enemy);
            System.out.println(list);
            System.out.println("");
            this.player.printTeam();
            System.out.println("");
            this.enemy.printTeam();

            for (int i = 0; i < 12; i++) {

                if (list.get(i).friendly() == true) {
                    playerTurn(list.get(i));
                } else {
                    enemyTurn(list.get(i));
                }
            }
        }

    }

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
            }

        }

    }

//Tekoäly hyökkää
    private void enemyTurn(Unit unit) {

        if (endCombat() == true) {
            return;
        }

        //Jos vastustaja on hengissä, hän hyökkää
        if ("alive".equals(unit.status())) {

            //Etsitään mahdollinen hyökkäyskohde ( Alkeellinen tekoäly)
            for (int target = 0; target <= 5; target++) {
                System.out.println("hei");
                //jos vastustajaan voi hyökätä, hyökkää, muuten hyökkää toiseen
                if (player.creature(target).status().equals("alive")) {
                    int extraDamage = unit.attack() + this.rand.nextInt(6);
                    System.out.println("Enemy " + unit.name() + " attacked and dealt " + extraDamage + " damage");
                    this.player.creature(target).takeDamage(extraDamage);

                }

            }

        }

    }

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

}
