/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

import java.util.Random;

/**
 * A hero unit controlled by the player.
 *
 * @author oolli
 */
public class Hero implements Unit, Comparable<Unit> {

    private final String name;
    private int hp;
    private int maxhp;
    private int attack;
    private int reach;
    private int speed;
    private String status;
    private Random rand;
    private final String heroName;

    /**
     * Hero is a unique unit used by the player. Can be considered the leader of
     * the player party.
     *
     * @param name is the unique hero name.
     * @param type determines hero type.
     */
    public Hero(String name, String type) {

        switch (type) {
            //Warrior
            case "Warrior":

                this.maxhp = 150;
                this.attack = 50;
                this.reach = 1;
                this.speed = 50;

                break;
            //Ranger
            case "Ranger":

                this.maxhp = 90;
                this.attack = 40;
                this.reach = 1;
                this.speed = 60;
                break;
            //Wizard
            case "Wizard":

                this.maxhp = 65;
                this.attack = 25;
                this.reach = 6;
                this.speed = 30;
                break;
        }
        this.name = type;
        this.heroName = name;
        this.hp = this.maxhp;
        this.status = "alive";
    }

    /**
     * Creature takes damage from a hit and changes status if it dies.
     *
     * @param hit amount of damage taken.
     */
    @Override
    public void takeDamage(int hit) {

        if (this.hp - hit <= 0) {
            this.hp = 0;
            this.status = "dead";
        } else {
            this.hp -= hit;
        }
    }

    /**
     * Creature takes healing and can't have more health than max health.
     *
     * @param heal amount of healing taken.
     * @return true if the unit was available for healing. Otherwise returns
     * false.
     */
    @Override
    public boolean heal(int heal) {
        if (this.status.equals("dead") || this.maxhp == this.hp) {
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

    /**
     * Returns the name of the hero.
     *
     * @return name.
     */
    @Override
    public String getName() {
        return this.name;
    }

    /**
     * Returns the amount of current health. 0-maximum health.
     *
     * @return health value.
     */
    @Override
    public int getHP() {
        return this.hp;
    }

    /**
     * Returns the attack value.
     *
     * @return attack value.
     */
    @Override
    public int getAttack() {
        return this.attack;
    }

    /**
     * Returns the maximum health that the creature can have value.
     *
     * @return maxHP value.
     */
    @Override
    public int getMaxHP() {
        return this.maxhp;
    }

    /**
     * Returns the reach of the hero. 1 / 6.
     *
     * @return reach value.
     */
    @Override
    public int getReach() {
        return this.reach;
    }

    /**
     * Returns the speed of the hero.
     *
     * @return speed value.
     */
    @Override
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Tells you whether the hero is alive or dead.
     *
     * @return status value. alive / dead
     */
    @Override
    public String getStatus() {
        return this.status;
    }

    @Override
    public String toString() {
        return this.name + " " + this.hp + "/" + this.maxhp + " : " + status;
    }

    /**
     * Helps to keep track of if this creature is part of the your group or one
     * of the enemies This value is always true, since hero units are all
     * friendly.
     *
     * @return true
     */
    @Override
    public boolean getFriendly() {
        return true;
    }

    /**
     * Compares the speeds of the units.
     *
     * @param t for comparing the speed.
     * @return the compared speed.
     */
    @Override
    public int compareTo(Unit t) {
        int firstSpeed = this.speed + this.rand.nextInt(10);
        int secondSpeed = t.getSpeed() + this.rand.nextInt(10);
        return firstSpeed - secondSpeed;
    }
}
