/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

/**
 *
 * @author oolli
 */
public class EmptySlot implements Unit, Comparable<Unit> {

    public EmptySlot() {

    }

    @Override
    //Empty slot ei voi ottaa damagea
    public void takeDamage(int hit) {
        System.out.println("Empty slot.");

    }

    public String name() {
        return "Empty";
    }

    @Override
    public int hp() {
        return -1;
    }

    @Override
    public int attack() {
        return -1;
    }

    @Override
    public int maxhp() {
        return -1;
    }

    @Override
    public int reach() {
        return -1;
    }

    @Override
    public int speed() {
        return -1;
    }

    @Override
    public String status() {
        return "Empty";
    }

    @Override
    public String toString() {
        return "Empty";
    }

    @Override
    public int compareTo(Unit t) {
        return -100;
    }

    @Override
    public boolean friendly() {
        return false;
    }

}
