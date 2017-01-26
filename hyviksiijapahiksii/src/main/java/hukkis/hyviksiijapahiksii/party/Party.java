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

    public boolean wiped() {

        if (backLeft.status().equals("alive")) {
            return false;
        }
        if (backCenter.status().equals("alive")) {
            return false;
        }
        if (backRight.status().equals("alive")) {
            return false;
        }
        if (fronLeft.status().equals("alive")) {
            return false;
        }
        if (frontCenter.status().equals("alive")) {
            return false;
        }
        if (frontRight.status().equals("alive")) {
            return false;
        }
        return true;
    }

}
