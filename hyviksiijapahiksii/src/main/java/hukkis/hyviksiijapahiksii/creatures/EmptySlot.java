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
public class EmptySlot implements Unit {
    public EmptySlot(){
        
    }

    @Override
    public boolean takeDamage(int hit) {
        System.out.println("Empty slot.");
        return false;
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
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String status() {
        return "Empty";
    }

    @Override
    public String toString() {
        return "Empty";
    }

}
