package no.ntnu.idata2001;

public class Unit {
    private String name;
    private int health;
    private int attack;
    private int armor;

    // Constructor
    public Unit() {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * @return String name of the unit
     */
    public String getName() {
        return name;
    }

    /**
     * @return int health of the unit
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return int health of the unit
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return int armor of the unit
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Sets health of the unit
     * 
     * @param health of the unit
     */
    public void setHealth(int health) {
        this.health = health;
        if (this.health < 0) {
            this.health = 0;
        }
    }
}
