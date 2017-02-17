/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.combat;

import hukkis.hyviksiijapahiksii.creatures.CompareSpeed;
import hukkis.hyviksiijapahiksii.creatures.Creature;
import hukkis.hyviksiijapahiksii.creatures.Unit;
import hukkis.hyviksiijapahiksii.party.Party;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;
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
public class CombatTest {

    public CombatTest() {
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
    public void determineTurns() {
        Party player = new Party(true);
        Party enemy = new Party(false);
        Unit creature1 = new Creature("Squire", true);
        Unit creature2 = new Creature("Apprentice", true);
        Unit creature3 = new Creature("Archer", false);
        player.addCreature(creature1, 0);
        player.addCreature(creature2, 1);
        enemy.addCreature(creature3, 0);
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        Combat battle = new Combat(rand, scan);

        List<Unit> creatures = battle.determineTurns(player, enemy);
        System.out.println(creatures);
        assertEquals("Archer", creatures.get(0).name());
        assertEquals("Squire", creatures.get(1).name());
        assertEquals("Apprentice", creatures.get(2).name());
    }

}
