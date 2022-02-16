package no.ntnu.idata2001;

/**
 * Hello world!
 *
 */
public class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;

    public Unit() {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    public String getName() {
        return name;
    }

    public int getHealth() {
        return health;
    }

    public int getAttack() {
        return attack;
    }

    public int getArmor() {
        return armor;
    }

    public void setHealth(int health) {
        this.health = health;
    }
}
