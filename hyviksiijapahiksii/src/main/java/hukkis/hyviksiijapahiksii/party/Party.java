/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.party;

import hukkis.hyviksiijapahiksii.creatures.Creature;

/**
 *
 * @author oolli
 */
public class Party {

    private Creature backLeft;
    private Creature backCenter;
    private Creature backRight;
    private Creature fronLeft;
    private Creature frontCenter;
    private Creature frontRight;

    public Party() {

    }

    public void addCreature(Creature creature, String slot) {
        switch (slot) {
            case "backLeft":
                this.backLeft = creature;
                break;
            case "backCenter":
                this.backCenter = creature;
                break;
            case "backRight":
                this.backCenter = creature;
                break;
            case "fronLeft":
                this.backCenter = creature;
                break;
            case "frontCenter":
                this.backCenter = creature;
                break;
            case "frontRight":
                this.backCenter = creature;
                break;
            default:
                break;
        }
    }

    public void removeCreature(String slot) {
        switch (slot) {
            case "backLeft":
                this.backLeft = null;
                break;
            case "backCenter":
                this.backLeft = null;
                break;
            case "backRight":
                this.backLeft = null;
                break;
            case "fronLeft":
                this.backLeft = null;
                break;
            case "frontCenter":
                this.backLeft = null;
                break;
            case "frontRight":
                this.backLeft = null;
                break;
            default:
                break;
        }
    }

    public Creature creature(String slot) {
        switch (slot) {
            case "backLeft":
                return this.backLeft;

            case "backCenter":
                return this.backCenter;

            case "backRight":
                return this.backRight;

            case "fronLeft":
                return this.fronLeft;
            case "frontCenter":
                return this.frontCenter;
            case "frontRight":
                return this.frontRight;
            default:
                return null;

        }

    }

    public boolean wiped() {

        if (backLeft.status().equals("alive") || backLeft == null) {
            return false;
        }
        if (backCenter.status().equals("alive") || backLeft == null) {
            return false;
        }
        if (backRight.status().equals("alive") || backLeft == null) {
            return false;
        }
        if (fronLeft.status().equals("alive") || backLeft == null) {
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
