/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

/**
 *
 * @author oolli
 */
public class Creature implements Unit {

    private String name;
    private int hp;
    private int maxhp;
    private int attack;
    private int reach;
    private int speed;
    private String status;

    public Creature(String name) {

        switch (name) {
            case "Squire":

                this.maxhp = 100;
                this.attack = 25;
                this.reach = 1;
                this.speed = 50;
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
    }

    public boolean takeDamage(int hit) {
        if (this.status.equals("dead") || this.status.equals("empty")) {
            return false;
        } else {
            if (this.hp - hit <= 0) {
                this.hp = 0;
                this.status = "dead";
            } else {
                this.hp -= hit;
            }
            return true;
        }

    }

    public boolean heal(int heal) {
        if (this.status.equals("dead")|| this.status.equals("empty")) {
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
        return this.name + " " + this.hp + "/" + this.maxhp + " :" + status;
    }
}
