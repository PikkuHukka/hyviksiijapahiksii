/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

import java.util.ArrayList;
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
public class CompareSpeedTest {

    public CompareSpeedTest() {
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
    public void speed() {
        Unit creature1 = new Creature("Squire",true);
        Unit creature2 = new Creature("Apprentice",true);
        Unit creature3 = new Creature("Archer",true);
        ArrayList<Unit> creatures = new ArrayList();
        creatures.add(creature1);
        creatures.add(creature2);
        creatures.add(creature3);
        Random rand = new Random();
        CompareSpeed comparetool = new CompareSpeed(rand);
        creatures.sort(comparetool);
        
        assertEquals("Archer",creatures.get(0).name());
        assertEquals("Squire",creatures.get(1).name());
        assertEquals("Apprentice",creatures.get(2).name());
        
        
    }
}
