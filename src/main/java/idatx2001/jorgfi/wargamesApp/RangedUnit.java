package idatx2001.jorgfi.wargamesApp;

/**
 * Represents a ranger unit in the game.
 * Inherits from the Unit-class.
 * 
 * @author jorgfi
 */
public class RangedUnit extends Unit {

    /**
     * Field Represents the amount of attacks that
     * the unit has recieved. Is relevant for the
     * getResistBonus() method.
     */
    private int amountOfRecievedHits = 0;

    /**
     * Simplified constructor with default values for attack and armor
     * 
     * @param name   String representing the name of the ranger
     * @param health int the health of the ranger
     */
    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);

        if (name == null || " ".equals(name) || health <= 0) {
            throw new IllegalArgumentException("Invalid values for unit. Please check parameters and try again.");
        } 
    }

    /**
     * Constructs a RangedUnit-instance without default values for attack and armor
     * 
     * @param name   String representing the name of the ranger
     * @param health int the health of the ranger
     * @param attack int the rangers damage capability
     * @param armor  int the rangers protection
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Calculates the attack bonus of this unit and returns it.
     * Abstract method inherited from the Unit-class.
     * 
     * @return int the amount of extra damage that the unit can
     *          deal to the opponent.
     */
    @Override
    public int getAttackBonus() {
        return 3;
    }

    /**
     * Calculates the resist bonus of this unit and returns it.
     * Abstract method inherited from the Unit-class.
     * 
     * @return the amount of extra protection that the unit
     *         recieves. Starts with a resistance-value of 6, but
     *         decreases by 2 after first and second attack dealt
     *         to this opponent. Stabilizes at a resistbonus of 2
     */
    @Override
    public int getResistBonus() {
        int bonus = 0;

        if (amountOfRecievedHits > 2) {
            bonus = 2;
        } else if (amountOfRecievedHits > 1) {
            bonus = 4;
        } else if (amountOfRecievedHits == 0) {
            bonus = 6;
        }
        amountOfRecievedHits++;
        return bonus;
    }
}
