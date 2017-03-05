/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

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
public class HeroTest {

    public HeroTest() {
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
    public void warriorHero() {
        Unit hero = new Hero("Jaska", "Warrior");
        assertEquals(1, hero.getReach());
        assertEquals(50, hero.getSpeed());
        assertEquals("Warrior 150/150 : alive", hero.toString());
    }

    @Test
    public void takeDamageAndStatus() {
        Unit hero = new Hero("Jaska", "Warrior");
        assertEquals(150, hero.getHP());
        assertEquals("alive", hero.getStatus());
        hero.takeDamage(70);
        assertEquals(80, hero.getHP());
        assertEquals(true, hero.heal(10));
        assertEquals(90, hero.getHP());
        hero.takeDamage(100);
        assertEquals("dead", hero.getStatus());
        assertEquals(0, hero.getHP());
        assertEquals(false, hero.heal(100));

    }

    @Test
    public void wizardHero() {
        Unit hero = new Hero("Torvalds", "Wizard");
        assertEquals("Wizard", hero.getName());
        assertEquals("alive", hero.getStatus());
        assertEquals(true, hero.getFriendly());
        assertEquals(6, hero.getReach());

    }

    @Test
    public void rangerHero() {
        Unit hero = new Hero("Jaska", "Ranger");
        assertEquals(90, hero.getMaxHP());
        assertEquals(1, hero.getReach());

    }
}
