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
public interface Unit {

    public boolean takeDamage(int hit);

    public int hp();

    public int attack();

    public int maxhp();

    public int reach(); 
    public int speed();

    public String status();
    @Override
    public String toString();

}
