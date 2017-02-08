/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

import hukkis.hyviksiijapahiksii.creatures.Creature;
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
public class creatureTest {

    public creatureTest() {
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

    // TODO add test methods here.
    // The methods must be annotated with annotation @Test. For example:
    //
    // @Test
    // public void hello() {}
    @Test
    public void takesDamageCorrectly() {
        Creature squire = new Creature("Squire");
        squire.takeDamage(50);
        assertEquals(50, squire.hp());
        assertEquals("alive", squire.status());
        squire.takeDamage(50);
        assertEquals(0, squire.hp());
        assertEquals("dead", squire.status());

    }

    @Test
    public void deadCannotTakeDamage() {
        Creature squire = new Creature("Squire");
        squire.takeDamage(100);
        squire.takeDamage(100);
        assertEquals(0, squire.hp());
        assertEquals("dead", squire.status());
    }

    @Test
    public void healingHealsCorrectly() {
        Creature squire = new Creature("Squire");
        squire.takeDamage(70);
        squire.heal(60);
        assertEquals(90, squire.hp());
        squire.heal(60);
        assertEquals(100, squire.hp());

    }

    @Test
    public void deadCannotBeHealed() {
        Creature squire = new Creature("Squire");
        squire.takeDamage(100);
        squire.heal(60);
        assertEquals(0, squire.hp());
        assertEquals("dead", squire.status());
    }
}
