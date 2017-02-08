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
    private ArrayList<Unit> turns;
    private Random rand;
    private Party enemy;
    private Scanner scan;

    public Combat(Party player, Party enemy, Random rand, Scanner scan) {
        this.end = false;
        this.player = player;
        this.rand = rand;
        this.enemy = enemy;
        this.scan = scan;

    }

    //Tehdään myöhemmin kun combat toimii muuten
    public void determineTurns(Party player, Party enemy) {
        ArrayList list = new ArrayList<>();
        for (int i = 0; i < 6; i++) {
            list.add(player.creature(i));
        }
        for (int i = 0; i < 6; i++) {
            list.add(enemy.creature(i));
        }
        System.out.println(list);
        CompareSpeed vertailija = new CompareSpeed(this.rand);
        list.sort(vertailija);
        System.out.println(list);

        //return list;
    }

    public Party combatLoop() {
        determineTurns(this.player, this.enemy);
        // while (end == false) {

        //Player party hyökkää
        //     playerTurn();
        //Enemy party hyökkää
        // if (end == false) {
        //       enemyTurn();
        //}
        //}
        return this.player;

    }

    public void playerTurn() {
        //Player party hyökkää

        for (int i = 0; i < 5; i++) {

            System.out.println("Your team: ");
            this.player.printTeam();
            System.out.println("Enemy team: ");
            this.enemy.printTeam();
            System.out.println("");

            if (endCombat() == true) {
                return;
            }
            //jos hahmo on elossa niin
            if ("alive".equals(this.player.creature(i).status())) {
                System.out.println(i + " is attacking. " + player.creature(i).attack() + " attack");
                System.out.println("Which enemy do you want to attack? 0-5");

                int target = scan.nextInt();

                //Jos vastustaja on hengissä niin hyökätään
                if (enemy.creature(target).status().equals("alive")) {
                    this.enemy.creature(target).takeDamage(this.player.creature(i).attack());
                    System.out.println("POW!");

                } else {
                    System.out.println("No such target.");
                    i--;
                }

            }

        }
    }

    //Tekoäly hyökkää
    private void enemyTurn() {

        for (int i = 0; i < 5; i++) { //Jos hahmo on elossa niin

            if (endCombat() == true) {
                return;
            }
            //Jos vastustaja on hengissä, hän hyökkää
            if ("alive".equals(this.enemy.creature(i).status())) {

                //Etsitään mahdollinen hyökkäyskohde ( Alkeellinen tekoäly)
                for (int target = 0; target < 5; target++) {
                    //jos vastustajaan voi hyökätä, hyökkää, muuten hyökkää toiseen
                    if (player.creature(target).status().equals("alive")) {

                        System.out.println(enemy.creature(i).toString() + " attacks and deals " + this.enemy.creature(i).attack() + " damage");
                        this.player.creature(target).takeDamage(this.enemy.creature(i).attack());

                        break;
                    }

                }

            }

        }
    }

    public boolean endCombat() {
        if (this.player.wiped() == true) {
            this.end = true;
            System.out.println("Battle lost!");
            return true;
        } else if (this.enemy.wiped() == true) {
            this.end = true;
            System.out.println("Battle won!");
            return true;
        } else {
            return false;
        }
    }

}
