/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.party;

import java.util.Random;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author oolli
 */
public class EnemyPartyGeneratorTest {

    public EnemyPartyGeneratorTest() {
    }

    @BeforeClass
    public static void setUpClass() {
    }

    @AfterClass
    public static void tearDownClass() {
    }

    @Before
    public void setUp() {
    }

    @After
    public void tearDown() {
    }

    @Test
    public void generatorTest() {
        EnemyPartyGenerator generator = new EnemyPartyGenerator(new Random());
        Party enemyParty1 = generator.createParty();
        assertEquals("alive", enemyParty1.creature(0).getStatus());
        Party enemyParty2 = generator.createParty();
        assertEquals("alive", enemyParty2.creature(0).getStatus());
        Party enemyParty3 = generator.createParty();
        assertEquals("alive", enemyParty3.creature(0).getStatus());
        Party enemyParty4 = generator.createParty();
        assertEquals("alive", enemyParty4.creature(0).getStatus());
    }

}
