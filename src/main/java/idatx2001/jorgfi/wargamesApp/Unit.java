package idatx2001.jorgfi.wargamesApp;

/**
 * Represents a Unit in the game. The subclasses inherit
 * the Unit-class methods. Is an abstract class.
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
     * Constructor initializing a Unit-instance. 
     * 
     * @param name   String name of the unit
     * @param health int the quantified status of a units life
     * @param attack int representing the amount of damage that the unit is
     *               capable of causing
     * @param armor  int representing extra protection on top of the units health
     */
    public Unit(String name, int health, int attack, int armor) {
        if (name != null && !" ".equals(name) && health > 0 && attack > 0 && armor > 0) {
            this.name = name;
            this.health = health;
            this.attack = attack;
            this.armor = armor;
        } else {
            throw new IllegalArgumentException("Invalid values for unit. Please check parameters and try again.");
        }
    }

    /**
     * Returns the name of the unit-object
     * 
     * @return String name of the unit
     */
    public String getName() {
        return this.name;
    }

    /**
     * Gets the health of the unit-object
     * 
     * @return int health of the unit
     */
    public int getHealth() {
        return this.health;
    }

    /**
     * Returns the attack for this unit-object
     * 
     * @return int health of the unit
     */
    public int getAttack() {
        return this.attack;
    }

    /**
     * Gets the armor for this unit-object
     * 
     * @return int armor of the unit
     */
    public int getArmor() {
        return this.armor;
    }

    /**
     * Generating a string which shows the
     * units name and remaining health.
     * 
     * @return String consisting the units name and health
     */
    public String toString() {
        return getName() + " has " + getHealth() + "hp left.";
    }

    /**
     * Mutates the health-field of the unit.
     * 
     * @param health int the new health which will be adjusted to
     */
    public void setHealth(int health) {
        this.health = health;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    /**
     * Deploys an attack on a opponent.
     * 
     * @param opponent Unit which are to be attacked
     */
    public void attack(Unit opponent) {
        int newHealth = opponent.getHealth() - (this.getAttack() + this.getAttackBonus())
                + (opponent.getArmor() + opponent.getResistBonus());

        opponent.setHealth(newHealth);
    }

    /**
     * Returns attack bonus depening on the Unit sub-class which inherits this method. 
     * @return int value representing extra damage
     */
    public abstract int getAttackBonus();

    /**
     * Returns unique resist bonus for each sub-class which inherits from this class. 
     * 
     * @return in value representing extra protection
     */
    public abstract int getResistBonus();
}
