/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

import java.util.Random;

/**
 *
 * @author oolli
 */
public class Creature implements Unit, Comparable<Unit> {

    private String name;
    private int hp;
    private int maxhp;
    private int attack;
    private int reach;
    private int speed;
    private String status;
    private Random rand;
    private boolean friendly;

    public Creature(String name, boolean friendly) {

        switch (name) {
            case "Squire":

                this.maxhp = 100;
                this.attack = 25;
                this.reach = 1;
                this.speed = 40;

                break;
            case "Archer":

                this.maxhp = 50;
                this.attack = 20;
                this.reach = 2;
                this.speed = 60;
                break;
            case "Apprentice":

                this.maxhp = 35;
                this.attack = 15;
                this.reach = 3;
                this.speed = 30;
                break;
        }
        this.name = name;
        this.hp = this.maxhp;
        this.status = "alive";
        this.friendly = friendly;

    }

    public void takeDamage(int hit) {

        if (this.hp - hit <= 0) {
            this.hp = 0;
            this.status = "dead";
        } else {
            this.hp -= hit;
        }

    }

    public boolean heal(int heal) {
        if (this.status.equals("dead") || this.status.equals("empty")) {
            return false;
        } else {
            if (this.hp + heal >= this.maxhp) {
                this.hp = maxhp;
            } else {
                this.hp += heal;
            }
            return true;
        }

    }

    public String name() {
        return this.name;
    }

    public int hp() {
        return this.hp;
    }

    public int attack() {
        return this.attack;
    }

    public int maxhp() {
        return this.maxhp;
    }

    public int reach() {
        return this.reach;
    }

    public int speed() {
        return this.speed;
    }

    public String status() {
        return this.status;
    }

    public String toString() {
        return this.name + " " + this.hp + "/" + this.maxhp + " : " + status;
    }

    public boolean friendly() {
        return this.friendly;
    }

    @Override
    public int compareTo(Unit t) {
        int firstSpeed = this.speed + this.rand.nextInt(10);
        int secondSpeed = t.speed() + this.rand.nextInt(10);
        return firstSpeed - secondSpeed;
    }

}
