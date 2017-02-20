/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.party;

import hukkis.hyviksiijapahiksii.creatures.Creature;
import java.util.Random;

/**
 *
 * @author oolli
 */
public class EnemyPartyGenerator {

    private Random rand;

    public EnemyPartyGenerator(Random rand) {
        this.rand = rand;

    }

    public Party createParty() {
        Party enemyParty = new Party(false);

        int enemyCount = (rand.nextInt(3) + 1);

        for (int i = 0; i < enemyCount; i++) {
            int enemyType = (rand.nextInt(3));
            switch (enemyType) {
                case 0: {
                    Creature creature = new Creature("Squire", false);
                    enemyParty.addCreature(creature, i);
                    break;
                }
                case 1: {
                    Creature creature = new Creature("Apprentice", false);
                    enemyParty.addCreature(creature, i);
                    break;
                }
                case 2: {
                    Creature creature = new Creature("Archer", false);
                    enemyParty.addCreature(creature, i);
                    break;
                }
                default:
                    break;
            }

        }
        return enemyParty;
    }
}
