/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii;

/**
 *
 * @author oolli
 */
public class Creature {

    private String name;
    private int hp;
    private int maxhp;
    private int attack;
    private int reach;
    private String status;

    public Creature(String type) {

        if (type.equals("Squire")) {
            this.name = "Squire";
            this.hp = 100;
            this.maxhp = 100;
            this.attack = 25;
            this.reach = 1;
            this.status = "alive";
        }
    }

    public void takeDamage(int hit) {
        if (this.hp - hit <= 0) {
            this.hp = 0;
            this.status = "dead";
        } else {
            this.hp -= hit;
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

    public String toString() {
        return this.name + " " + this.hp + "/" + this.maxhp + " :" + status;
    }
}
