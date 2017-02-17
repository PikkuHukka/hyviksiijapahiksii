/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

/**
 * Empty slot used as a replacer for missing creatures in a party.
 *
 * @author oolli
 */
public class EmptySlot implements Unit, Comparable<Unit> {

    /**
     * Empty slot has an empty constructor because all the values are final.
     *
     */
    public EmptySlot() {

    }

    @Override
    /**
     * This method is not used under normal circumstances.
     *
     * @param hit damage taken.
     */
    public void takeDamage(int hit) {
        System.out.println("Empty slot.");

    }

    @Override
    /**
     * Returns empty.
     *
     * @return empty because empty slot has no name.
     */
    public String name() {
        return "Empty";
    }

    /**
     * Returns -1.
     *
     * @return -1 , but this will not be called in normal circumstances.
     */
    @Override
    public int hp() {
        return -1;
    }

    /**
     * Returns -1.
     *
     * @return -1 , but this will not be called in normal circumstances.
     */
    @Override
    public int attack() {
        return -1;
    }

    /**
     * Returns -1.
     *
     * @return -1 , but this will not be called in normal circumstances.
     */
    @Override
    public int maxhp() {
        return -1;
    }

    /**
     * Returns -1.
     *
     * @return -1 , but this will not be called in normal circumstances.
     */
    @Override
    public int reach() {
        return -1;
    }

    /**
     * Returns -1.
     *
     * @return -1 , but this will not be called in normal circumstances.
     */
    @Override
    public int speed() {
        return -1;
    }

    /**
     * Returns empty status.
     *
     * @return "Empty" , this allows the party class to see that this is an
     * empty slot.
     *
     */
    @Override
    public String status() {
        return "Empty";
    }

    /**
     * Returns empty toString.
     *
     *
     * @return "Empty".
     */
    @Override
    public String toString() {
        return "Empty";
    }

    /**
     * Returns -100.
     *
     * @param t unit speed, but empty slot value is -100.
     * @return -100 , empty slots will always be the last.
     */
    @Override
    public int compareTo(Unit t) {
        return -100;
    }

    /**
     * Returns -100.
     *
     * @return Empty slots are considered unfriendly to make combat code easier.
     */
    @Override
    public boolean friendly() {
        return false;
    }

}
