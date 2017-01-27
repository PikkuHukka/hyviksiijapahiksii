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

    private Unit backLeft;
    private Unit backCenter;
    private Unit backRight;
    private Unit frontLeft;
    private Unit frontCenter;
    private Unit frontRight;

    public Party() {
        this.backLeft = new EmptySlot();
        this.backCenter = new EmptySlot();
        this.backRight = new EmptySlot();
        this.frontLeft = new EmptySlot();
        this.frontCenter = new EmptySlot();
        this.frontRight = new EmptySlot();

    }

    public void addCreature(Creature Unit, String slot) {
        switch (slot) {
            case "backLeft":
                this.backLeft = Unit;
                break;
            case "backCenter":
                this.backCenter = Unit;
                break;
            case "backRight":
                this.backRight = Unit;
                break;
            case "fronLeft":
                this.frontLeft = Unit;
                break;
            case "frontCenter":
                this.frontCenter = Unit;
                break;
            case "frontRight":
                this.frontRight = Unit;
                break;
            default:
                break;
        }
    }

    public void removeCreature(String slot) {
        switch (slot) {
            case "backLeft":
                this.backLeft = new EmptySlot();
                break;
            case "backCenter":
                this.backCenter = new EmptySlot();
                break;
            case "backRight":
                this.backRight = new EmptySlot();
                break;
            case "fronLeft":
                this.frontLeft = new EmptySlot();
                break;
            case "frontCenter":
                this.frontCenter = new EmptySlot();
                break;
            case "frontRight":
                this.frontRight = new EmptySlot();
                break;
            default:
                break;
        }
    }

    public Unit creature(String slot) {
        switch (slot) {
            case "backLeft":
                return this.backLeft;
            case "backCenter":
                return this.backCenter;
            case "backRight":
                return this.backRight;
            case "fronLeft":
                return this.frontLeft;
            case "frontCenter":
                return this.frontCenter;
            case "frontRight":
                return this.frontRight;
            default:
                return null;

        }

    }

    public boolean wiped() {

        if (backLeft.status().equals("alive") || backLeft.status().equals("alive")) {
            return false;
        }
        if (backCenter.status().equals("alive") || backLeft == null) {
            return false;
        }
        if (backRight.status().equals("alive") || backLeft == null) {
            return false;
        }
        if (frontLeft.status().equals("alive") || backLeft == null) {
            return false;
        }
        if (frontCenter.status().equals("alive") || backLeft == null) {
            return false;
        }
        if (frontRight.status().equals("alive") || backLeft == null) {
            return false;
        }
        return true;
    }

}
