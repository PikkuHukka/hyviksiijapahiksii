/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii;

import hukkis.hyviksiijapahiksii.creatures.Hero;
import hukkis.hyviksiijapahiksii.maingame.GameLogic;
import hukkis.hyviksiijapahiksii.party.Party;
import hukkis.hyviksiijapahiksii.ui.MainMenu;
import java.io.IOException;
import java.util.Random;

import java.util.Scanner;

/**
 * Main method that is just used to start the actual game.
 *
 * @author oolli
 */
public class Main {

    /**
     * Just jumps into the gameLogic.
     *
     * @param args main method.
     * @throws java.io.IOException Required for swing utilities.
     */
    public static void main(String[] args) throws IOException {
        MainMenu menu = new MainMenu();
        menu.mainMenuFrame();

    }

}
