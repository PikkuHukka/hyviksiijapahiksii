/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

import java.util.Comparator;
import java.util.Random;

/**
 * Used to compare units by speed.
 *
 * @author oolli
 */
public class CompareSpeed implements Comparator<Unit> {

    private final Random rand;

    /**
     * Initiates a new CompareSpeed.
     *
     * @param rand adds the random generator to CompareSpeed.
     */
    public CompareSpeed(Random rand) {
        this.rand = rand;

    }

    /**
     * compares the speed of unit a to unit b.
     *
     * @param a first unit.
     * @param b second unit.
     *
     */
    @Override
    public int compare(Unit a, Unit b) {
        int firstSpeed = a.getSpeed() + this.rand.nextInt(10);
        int secondSpeed = b.getSpeed() + this.rand.nextInt(10);
        return secondSpeed - firstSpeed;
    }

}
