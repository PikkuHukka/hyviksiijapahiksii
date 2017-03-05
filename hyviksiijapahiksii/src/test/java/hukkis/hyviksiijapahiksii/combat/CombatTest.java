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
        assertEquals("Archer", creatures.get(0).getName());
        assertEquals("Squire", creatures.get(1).getName());
        assertEquals("Apprentice", creatures.get(2).getName());
    }

    @Test
    public void endCombat() {
        Party player = new Party(true);
        Party enemy = new Party(false);
        Unit creature1 = new Creature("Squire", true);
        Unit creature2 = new Creature("Apprentice", true);
        Unit creature3 = new Creature("Archer", false);
        player.addCreature(creature1, 0);
        player.addCreature(creature2, 1);
        enemy.addCreature(creature3, 0);
        Combat battle = new Combat(new Random(), new Scanner(System.in));
        battle.newCombat(player, enemy);
        enemy.creature(0).takeDamage(70);
        assertEquals(true, battle.endCombat());
    }

    @Test
    public void fleeing() {
        Party player = new Party(true);
        Party enemy = new Party(false);
        Unit creature1 = new Creature("Squire", true);
        Unit creature2 = new Creature("Apprentice", true);
        Unit creature3 = new Creature("Archer", false);
        player.addCreature(creature1, 0);
        player.addCreature(creature2, 1);
        enemy.addCreature(creature3, 0);
        Combat battle = new Combat(new Random(), new Scanner(System.in));
        battle.newCombat(player, enemy);
        assertEquals(false, battle.endCombat());
        battle.flee();
        assertEquals(true, battle.endCombat());
        battle.notFleeing();
        assertEquals(false, battle.endCombat());

    }

    /**
     * Enemy takes hit, but after the enemy is dead, he can't be hit anymore.
     * Also empty slots can't be hit either.
     */
    @Test
    public void playerHit() {
        Party player = new Party(true);
        Party enemy = new Party(false);
        Unit creature1 = new Creature("Squire", true);
        Unit creature2 = new Creature("Apprentice", true);
        Unit creature3 = new Creature("Squire", false);
        player.addCreature(creature1, 0);
        player.addCreature(creature2, 1);
        enemy.addCreature(creature3, 0);
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        Combat battle = new Combat(rand, scan);
        battle.newCombat(player, enemy);
        assertEquals(false, battle.endCombat());
        assertEquals(true, battle.playerUnitHit(0, creature1)); //Can take damage.
        assertEquals(true, battle.playerUnitHit(0, creature2));
        assertTrue(creature3.getMaxHP() > creature3.getHP()); //Damage was taken and the creature is no longer at ful HP.
        creature3.takeDamage(999); //Kills the enemy creature.
        assertEquals(false, battle.playerUnitHit(0, creature1)); //Is dead now.
        assertEquals(false, battle.playerUnitHit(5, creature3)); //Is empty slot.
        assertEquals(true, battle.endCombat());

    }

    @Test
    public void enemyHit() {
        Party player = new Party(true);
        Party enemy = new Party(false);
        Unit creature1 = new Creature("Apprentice", true);
        Unit creature2 = new Creature("Apprentice", true);
        Unit creature3 = new Creature("Archer", false);
        Unit creature4 = new Creature("Apprentice", false);
        Unit creature5 = new Creature("Squire", false);
        player.addCreature(creature1, 0);
        player.addCreature(creature2, 1);
        enemy.addCreature(creature3, 0);
        enemy.addCreature(creature2, 1);
        Random rand = new Random();
        Scanner scan = new Scanner(System.in);
        Combat battle = new Combat(rand, scan);
        battle.newCombat(player, enemy);
        battle.enemyTurn(creature3);
        battle.enemyTurn(creature4);
        battle.enemyTurn(creature5);
        assertTrue(creature2.getMaxHP() > creature2.getHP());
        assertEquals("dead", creature1.getStatus());

    }
}
