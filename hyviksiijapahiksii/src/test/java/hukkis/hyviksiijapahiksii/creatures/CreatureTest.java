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
public class CreatureTest {

    public CreatureTest() {
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
    public void takesDamage() {
        Creature squire = new Creature("Squire", true);
        squire.takeDamage(50);
        assertEquals(50, squire.hp());
        assertEquals("alive", squire.status());
        squire.takeDamage(50);
        assertEquals(0, squire.hp());
        assertEquals("dead", squire.status());

    }

    @Test
    public void deadCannotTakeDamage() {
        Creature squire = new Creature("Apprentice", true);
        squire.takeDamage(100);
        squire.takeDamage(100);
        assertEquals(0, squire.hp());
        assertEquals("dead", squire.status());
    }

    @Test
    public void healing() {
        Creature squire = new Creature("Archer", true);
        squire.takeDamage(20);
        squire.heal(10);
        assertEquals(40, squire.hp());
        squire.heal(60);
        assertEquals(50, squire.hp());

    }

    @Test
    public void returnValues() {
        Creature squire = new Creature("Squire", true);
        assertEquals(100, squire.maxhp());
        assertEquals(1, squire.reach());
        assertEquals("Squire", squire.name());
        assertEquals(25, squire.attack());
        assertEquals(40, squire.speed());
        assertEquals(true, squire.friendly());

    }

    @Test
    public void print() {
        Creature squire = new Creature("Squire", false);
        squire.takeDamage(50);
        assertEquals(false, squire.friendly());
        assertEquals("Squire 50/100 : alive", squire.toString());
    }
}
