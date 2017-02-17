/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

/**
 * Unit is the interface for all creatures/heroes who are able to engage in
 * combat. Unit can also be an empty slot.
 *
 * @author oolli
 */
public interface Unit {

    /**
     * Unit takes damage according to the hit parameter.
     *
     * @param hit value.
     */
    public void takeDamage(int hit);

    /**
     * This is used to keep track of unit health.
     *
     * @return the unit health
     */
    public int hp();

    /**
     * Used to determine, how much base damage the unit has.
     *
     * @return attack value.
     */
    public int attack();

    /**
     * Used to make sure that creature health can't be more than the maximum
     * health. Also is the start value for health when the creature is created.
     *
     * @return max health.
     */
    public int maxhp();

    /**
     * Returns the reach of the creature. 1 For single target and 6 for all
     * enemies.
     *
     * @return either 1 or 6.
     */
    public int reach();

    /**
     * Returns the speed of the creature. Determines which creatures attack
     * first.
     *
     * @return speed value.
     */
    public int speed();

    /**
     * Unit can be either dead, alive or dead if the slot is empty.
     *
     * @return dead/alive/empty
     */
    public String status();

    @Override
    public String toString();

    /**
     * If the unit is controlled by the player, true If the unit is controlled
     * by computer, false.
     *
     * @return true or false.
     */
    public boolean friendly();

    /**
     * Returns the name of the creature. Unique if hero unit.
     *
     * @return name
     */
    public String name();

}
