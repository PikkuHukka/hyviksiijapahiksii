/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.maingame;

import hukkis.hyviksiijapahiksii.combat.Combat;
import hukkis.hyviksiijapahiksii.creatures.Creature;
import hukkis.hyviksiijapahiksii.creatures.Hero;
import hukkis.hyviksiijapahiksii.creatures.Unit;
import hukkis.hyviksiijapahiksii.party.EnemyPartyGenerator;
import hukkis.hyviksiijapahiksii.party.Party;
import hukkis.hyviksiijapahiksii.ui.MainMenu;
import hukkis.hyviksiijapahiksii.ui.CombatMenu;
import java.util.*;

/**
 * Basic game logic class.
 *
 * @author oolli
 */
public class GameLogic {

    private Random rand;

    /**
     * Just to add the scanner and the random class.
     *
     *
     */
    public GameLogic() {
        this.rand = new Random();
    }

    /**
     * Add creatures to the party
     *
     * @param playerParty
     */
    public void startPartyMenu(Party playerParty) {
        EnemyPartyGenerator generator = new EnemyPartyGenerator(this.rand);
        Party enemyParty = generator.createParty();
      //  enemyParty.printTeam();
       // playerParty.printTeam();
        
        CombatMenu combatMenuFrame = new CombatMenu(playerParty, enemyParty);
        combatMenuFrame.combatMenuFrame();

    }
}
