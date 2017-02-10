/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii;

import hukkis.hyviksiijapahiksii.combat.Combat;
import hukkis.hyviksiijapahiksii.creatures.Creature;
import hukkis.hyviksiijapahiksii.maingame.GameLogic;
import hukkis.hyviksiijapahiksii.party.Party;
import java.util.Random;

import java.util.Scanner;

/**
 *
 * @author oolli
 */
public class Main {

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        Random rand = new Random();

        GameLogic peli = new GameLogic(scan, rand);
        peli.pelaaPeli();

    }

}
