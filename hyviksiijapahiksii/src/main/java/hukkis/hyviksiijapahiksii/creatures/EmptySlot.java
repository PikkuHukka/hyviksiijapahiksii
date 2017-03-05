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

    }

    @Override
    /**
     * Returns empty.
     *
     * @return empty because empty slot has no name.
     */
    public String getName() {
        return "Empty";
    }

    /**
     * Returns -1.
     *
     * @return -1 , but this will not be called in normal circumstances.
     */
    @Override
    public int getHP() {
        return -1;
    }

    /**
     * Returns -1.
     *
     * @return -1 , but this will not be called in normal circumstances.
     */
    @Override
    public int getAttack() {
        return -1;
    }

    /**
     * Returns -1.
     *
     * @return -1 , but this will not be called in normal circumstances.
     */
    @Override
    public int getMaxHP() {
        return -1;
    }

    /**
     * Returns -1.
     *
     * @return -1 , but this will not be called in normal circumstances.
     */
    @Override
    public int getReach() {
        return -1;
    }

    /**
     * Returns -1.
     *
     * @return -1 , but this will not be called in normal circumstances.
     */
    @Override
    public int getSpeed() {
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
    public String getStatus() {
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
    public boolean getFriendly() {
        return false;
    }

    /**
     * Empty slots won't be healed.
     *
     * @param heal amount of healing taken.
     * @return always returns false, because empty slots can't be healed. false.
     */
    @Override
    public boolean heal(int heal) {
        return false;

    }

}
