/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.party;

import hukkis.hyviksiijapahiksii.creatures.Creature;
import java.util.ArrayList;
import java.util.Random;

/**
 * This class generates the party for each enemy party.
 *
 * @author oolli
 */
public class EnemyPartyGenerator {

    private Random rand;

    /**
     * Gives random to be used for the party size and enemy type.
     *
     * @param rand is given from the logic.
     */
    public EnemyPartyGenerator(Random rand) {
        this.rand = rand;

    }

    /**
     * Generates the party with 1-3 enemies.
     *
     * @return the generated party to the combat to be applied.
     */
    public Party createParty() {
        Party enemyParty = new Party(false);

        int enemyCount = (rand.nextInt(3) + 1);
        ArrayList<String> types = new ArrayList();
        types.add("Squire");
        types.add("Apprentice");
        types.add("Archer");

        for (int i = 0; i < enemyCount; i++) {

            int enemyType = (rand.nextInt(3));

            enemyParty.addCreature(new Creature(types.get(enemyType), false), i);

        }
        return enemyParty;
    }
}
