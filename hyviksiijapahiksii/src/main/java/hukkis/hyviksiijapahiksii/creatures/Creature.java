/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package hukkis.hyviksiijapahiksii.creatures;

import java.util.Random;

/**
 * Class used for a normal creature either friend or foe.
 *
 * @author oolli
 */
public class Creature implements Unit, Comparable<Unit> {

    private final String name;
    private int hp;
    private int maxhp;
    private int attack;
    private int reach;
    private int speed;
    private String status;
    private Random rand;
    private final boolean friendly;

    /**
     * Constructor for creature.
     *
     * @param name name of the creature. This isn't unique and determines the
     * type
     *
     * @param friendly if the creature is controlled by player true, else false.
     */
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
                this.reach = 1;
                this.speed = 60;
                break;
            case "Apprentice":

                this.maxhp = 50;
                this.attack = 15;
                this.reach = 6;
                this.speed = 30;
                break;
        }
        this.name = name;
        this.hp = this.maxhp;
        this.status = "alive";
        this.friendly = friendly;

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
     * Returns the name of the creature.
     *
     * @return the name of the creature.
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
     * Returns the maximum health that the creature can have.
     *
     * @return maxHP value
     */
    @Override
    public int getMaxHP() {
        return this.maxhp;
    }

    /**
     * Returns the reach of the creature. 1 / 6.
     *
     * @return reach value.
     */
    @Override
    public int getReach() {
        return this.reach;
    }

    /**
     * Returns the speed of the creature.
     *
     * @return speed value.
     */
    @Override
    public int getSpeed() {
        return this.speed;
    }

    /**
     * Tells you whether the creature is alive or dead.
     *
     * @return status dead/alive.
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
     * of the enemies.
     *
     * @return boolean friendly.
     */
    @Override
    public boolean getFriendly() {
        return this.friendly;
    }

    /**
     * Compares the speeds of the units. Helps to determine who should attack
     * first.
     *
     * @param t comparable unit.
     */
    @Override
    public int compareTo(Unit t) {
        int firstSpeed = this.speed + this.rand.nextInt(10);
        int secondSpeed = t.getSpeed() + this.rand.nextInt(10);
        return firstSpeed - secondSpeed;
    }

}
