/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.party;

import hukkis.hyviksiijapahiksii.creatures.Creature;
import hukkis.hyviksiijapahiksii.party.Party;
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
public class PartyTest {

    public PartyTest() {
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
    public void emptySlotInParty() {
        Party joukko = new Party(true);

        assertEquals("Empty", joukko.creature(0).toString());

    }

    @Test
    public void partyAddCreature() {
        Party joukko = new Party(true);
        Creature jatka = new Creature("Squire", true);
        joukko.addCreature(jatka, 0);
        assertEquals("Squire 100/100 : alive", joukko.creature(0).toString());

    }

    @Test
    public void partyRemoveCreature() {
        Party joukko = new Party(false);
        Creature jatka = new Creature("Squire", false);
        joukko.addCreature(jatka, 0);
        assertEquals("Squire 100/100 : alive", joukko.creature(0).toString());
        joukko.removeCreature(0);
        assertEquals("Empty", joukko.creature(0).toString());
        assertEquals(false, joukko.player());

    }

    @Test
    public void partyWiped() {
        Party joukko = new Party(true);
        Creature creature1 = new Creature("Apprentice", true);
        joukko.addCreature(creature1, 0);
        assertEquals(false, joukko.wiped());
        joukko.creature(0).takeDamage(50);
        assertEquals(true, joukko.wiped());
        assertEquals(true, joukko.player());

    }

}
