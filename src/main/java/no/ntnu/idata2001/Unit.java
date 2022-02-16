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

    // A constructor.
    public Unit() {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * @return String
     */
    public String getName() {
        return name;
    }

    /**
     * @return int
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return int
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return int
     */
    public int getArmor() {
        return armor;
    }

    /**
     * @param health
     */
    public void setHealth(int health) {
        this.health = health;
    }
}
