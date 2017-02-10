/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

import java.util.Comparator;
import java.util.Random;

/**
 *
 * @author oolli
 */
public class CompareSpeed implements Comparator<Unit> {

    private final Random rand;

    public CompareSpeed(Random rand) {
        this.rand = rand;

    }

    @Override
    public int compare(Unit a, Unit b) {
        int firstSpeed = a.speed() + this.rand.nextInt(10);
        int secondSpeed = b.speed() + this.rand.nextInt(10);
        return secondSpeed - firstSpeed;
    }

}
