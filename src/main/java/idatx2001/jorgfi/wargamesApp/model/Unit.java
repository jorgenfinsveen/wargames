package idatx2001.jorgfi.wargamesApp.model;

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
    private Terrain terrain;

    protected int numberOfDealtHits;
    protected int amountOfRecievedHits;

    private enum Terrain {
        NONE, HILL, PLAINS, FOREST
    };

    /**
     * Constructor initializing a Unit-instance. 
     * 
     * @param name   String name of the unit
     * @param health int the quantified status of a units life
     * @param attack int representing the amount of damage that the unit is
     *               capable of causing
     * @param armor  int representing extra protection on top of the units health
     */
    public Unit(String name, int health, int attack, int armor) throws IllegalArgumentException {
        if (name.isBlank()) throw new IllegalArgumentException("You must give the unit a name");
        if (health <= 0) throw new IllegalArgumentException("Health must be above 0");
        if (attack <= 0) throw new IllegalArgumentException("Attack must be above 0");
        this.name = name;
        this.setHealth(health);
        this.attack = attack;
        this.armor = armor;
        this.numberOfDealtHits = 0;
        this.amountOfRecievedHits = 0;
        this.terrain = Terrain.NONE;
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
     * Returns the terrain at the units location.
     * 
     * @return String terrain name e.g "PLAINS"
     */
    public String getTerrain() {
        return String.valueOf(this.terrain);
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
     * Mutates the terrain of the unit. 
     * 
     * @param terrain Terrain to be set.
     */
    public void setTerrain(String terrain) {
        switch (terrain.toUpperCase()) {
            case "HILL": this.terrain = Terrain.HILL;
            case "FOREST": this.terrain = Terrain.FOREST;
            case "PLAINS": this.terrain = Terrain.PLAINS;
            default: this.terrain = Terrain.NONE;
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

    /**
     * Returns further attack and resist bonus depending on the terrain
     * @return int[] value representing extra damage and resistance
     */
    public abstract int[] getTerrainAttackAndResistBonus();

}
