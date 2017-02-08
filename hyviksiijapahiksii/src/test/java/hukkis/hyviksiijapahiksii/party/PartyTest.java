/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package partytest;

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
        Party joukko = new Party();

        assertEquals("empty", joukko.creature("backLeft").toString());

    }

    @Test
    public void partyAddCreature() {
        Party joukko = new Party();
        Creature jatka = new Creature("Squire");
        joukko.addCreature(jatka, "backLeft");
        assertEquals("Squire 100/100 :alive", joukko.creature("backLeft").toString());

    }

    @Test
    public void partyRemoveCreature() {
        Party joukko = new Party();
        Creature jatka = new Creature("Squire");
        joukko.addCreature(jatka, "backLeft");
        assertEquals("Squire 100/100 :alive", joukko.creature("backLeft").toString());
        joukko.removeCreature("backLeft");
        assertEquals("empty", joukko.creature("backLeft").toString());

    }

}
