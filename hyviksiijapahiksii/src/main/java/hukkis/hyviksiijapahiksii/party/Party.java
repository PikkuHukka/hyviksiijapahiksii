/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.party;

import hukkis.hyviksiijapahiksii.creatures.Creature;
import hukkis.hyviksiijapahiksii.creatures.EmptySlot;
import hukkis.hyviksiijapahiksii.creatures.Unit;

/**
 *
 * @author oolli
 */
public class Party {

    private Unit[] party;
    private boolean player;

    public Party(boolean player) {
        this.player = player;
        this.party = new Unit[6];
        for (int i = 0; i < 6; i++) {
            this.party[i] = new EmptySlot();
        }

    }

    //Lisää creaturen slottiin
    public void addCreature(Unit unit, int slot) {
        if (slot <= 5) {
            this.party[slot] = unit;
        }
    }

//Poistaa creaturen slotista x
    public void removeCreature(int slot) {
        if (slot <= 5) {
            this.party[slot] = new EmptySlot();

        }
    }

//palauttaa Unitin slotista x
    public Unit creature(int slot) {

        return this.party[slot];

    }

    //tarkistaa onko joukossa ketään hengissä
    public boolean wiped() {

        for (int i = 0; i <= 5; i++) {
            if (party[i].status().equals("alive")) {
                return false;
            }

        }
        return true;

    }

    public void printTeam() {
        for (int i = 0; i < this.party.length; i++) {
            System.out.println("Target " + i + ". " + this.party[i].toString());
        }

    }

    public boolean player() {
        return this.player;
    }
}
