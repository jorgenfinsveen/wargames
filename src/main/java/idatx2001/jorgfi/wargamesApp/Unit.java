package idatx2001.jorgfi.wargamesApp;

/**
 * This is a superclass
 * Represents a Unit in the game. The other unit-subclasses inherit
 * the Unit-class methods. It is an abstract class.
 * 
 * @author jorgfi
 * @version 1.0-SNAPSHOT
 */
public abstract class Unit {

    // Fields
    private String name;
    private int health;
    private int attack;
    private int armor;

    /**
     * Constructor
     * 
     * @param name   of the unit
     * @param health show the quantified status of a units life
     * @param attack represents the amount of damage that the unit is
     *               capable of causing
     * @param armor  represents extra protection on top of the units health
     */
    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * @return String name of the unit
     */
    public String getName() {
        return this.name;
    }

    /**
     * @return int health of the unit
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * @return int health of the unit
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * @return int armor of the unit
     */
    public int getArmor() {
        return this.armor;
    }

    /**
     * Simple method for generating a string which shows the
     * units status. Mainly for debugging purposes
     * 
     * @return string consisting the units name and health
     */
    public String toString() {
        return getName() + " has " + getHealth() + "hp left.";
    }

    /**
     * Adjusts the health-field of the unit.
     * 
     * @param health is the new health which will be adjusted to
     */
    public void setHealth(int health) {
        this.health = health;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * Attack another unit.
     * 
     * @param opponent is the unit which are to be attacked
     *                 the attack-formulae is defined in the assignment
     */
    public void attack(Unit opponent) {
        int newHealth = opponent.getHealth() - (this.getAttack() + this.getAttackBonus())
                + (opponent.getArmor() + opponent.getResistBonus());

        opponent.setHealth(newHealth);
    }

    /**
     * Abstract methods that returns unique values for
     * each sub-class which inherits from this class.
     * 
     * @return integer value representing extra damage
     * @return integer value representing extra protection
     */
    public abstract int getAttackBonus();

    public abstract int getResistBonus();
}
