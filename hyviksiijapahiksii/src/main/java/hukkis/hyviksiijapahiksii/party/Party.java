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

    public Party() {
        this.party = new Unit[6];
        for (int i = 0; i < 6; i++) {
            this.party[i] = new EmptySlot();
        }

    }

    //Lisää creaturen slottiin
    public void addCreature(Unit unit, int slot) {
        switch (slot) {
            case 0:
                this.party[0] = unit;
                break;
            case 1:
                this.party[1] = unit;
                break;
            case 2:
                this.party[2] = unit;
                break;
            case 3:
                this.party[3] = unit;
                break;
            case 4:
                this.party[4] = unit;
                break;
            case 5:
                this.party[5] = unit;
                break;

            default:
                break;
        }
    }

    //Poistaa creaturen slotista x
    public void removeCreature(int slot) {
        switch (slot) {
            case 0:
                this.party[0] = new EmptySlot();
                break;
            case 1:
                this.party[1] = new EmptySlot();
                break;
            case 2:
                this.party[2] = new EmptySlot();
                break;
            case 3:
                this.party[3] = new EmptySlot();
                break;
            case 4:
                this.party[4] = new EmptySlot();
                break;
            case 5:
                this.party[5] = new EmptySlot();
                break;
            default:
                break;
        }
    }

    //palauttaa Unitin slotista x
    public Unit creature(int slot) {
        switch (slot) {
            case 0:
                return this.party[0];
            case 1:
                return this.party[1];
            case 2:
                return this.party[2];
            case 3:
                return this.party[3];
            case 4:
                return this.party[4];
            case 5:
                return this.party[5];

            default:
                return null;

        }

    }

    //tarkistaa onko joukossa ketään hengissä
    public boolean wiped() {

        for (int i = 0; i < 5; i++) {
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
}
