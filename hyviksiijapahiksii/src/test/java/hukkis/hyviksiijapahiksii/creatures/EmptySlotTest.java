/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

import hukkis.hyviksiijapahiksii.creatures.EmptySlot;
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
public class EmptySlotTest {

    public EmptySlotTest() {
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
    public void values() {
        Unit empty = new EmptySlot();
        assertEquals(-1, empty.getAttack());
        assertEquals(-1, empty.getReach());
        assertEquals(-1, empty.getHP());
        assertEquals(-1, empty.getMaxHP());
        assertEquals(-1, empty.getSpeed());
        assertEquals("Empty", empty.getStatus());
        assertEquals(false, empty.getFriendly());
        assertEquals("Empty", empty.getName());
        assertEquals("Empty", empty.toString());
        empty.takeDamage(0);
        assertEquals(false, empty.heal(100));
    }
}
// TODO add test methods here.
// The methods must be annotated with annotation @Test. For example:
//
// @Test
    // public void hello() {}
