/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.party;

import hukkis.hyviksiijapahiksii.creatures.EmptySlot;
import hukkis.hyviksiijapahiksii.creatures.Unit;

/**
 * Party contains 6 slots for different units. Can be managed outside combat and
 * used to battle during combat
 *
 * @author oolli
 */
public class Party {

    private final Unit[] party;
    private final boolean player;

    /**
     * Creates a new party.
     *
     * @param player if the party is controlled by player true, else false
     */
    public Party(boolean player) {
        this.player = player;
        this.party = new Unit[6];
        for (int i = 0; i <= 5; i++) {
            this.party[i] = new EmptySlot();
        }

    }

    /**
     * Add a new creature to the party.
     *
     * @param unit the unit that will be added to a party
     * @param slot the slot, this new unit will be added to
     */
    public void addCreature(Unit unit, int slot) {
        if (slot <= 5) {
            this.party[slot] = unit;
        }
    }

    /**
     * Remove the unit from a specific slot.
     *
     * @param slot remove a the creature from this slot
     */
    public void removeCreature(int slot) {
        if (slot <= 5) {
            this.party[slot] = new EmptySlot();

        }
    }

    /**
     * Returns the unit from a specific slot.
     *
     * @param slot which slot?
     * @return return the unit
     */
    public Unit creature(int slot) {

        return this.party[slot];

    }

    /**
     * If all unit slots in the party are either dead or wiped, return true.
     *
     * @return returns true if party is wiped, false if there's still creature
     * alive
     */
    public boolean wiped() {

        for (int i = 0; i <= 5; i++) {
            if (party[i].getStatus().equals("alive")) {
                return false;
            }

        }
        return true;

    }

    /**
     * Returns the party alignment, whether it is controlled by player or the
     * AI.
     *
     * @return boolean true or false
     */
    public boolean player() {
        return this.player;
    }
}
