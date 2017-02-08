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

    @Override
    public int hp() {
        return -1;
    }

    @Override
    public int attack() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int maxhp() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int reach() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public int speed() {
        return - 100;
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

}
