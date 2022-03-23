package idatx2001.jorgfi.wargamesApp;

/**
 * A sub-class which inherits from the Unit-class.
 * Represents a ranger unit in the game.
 * 
 * @author jorgfi
 */
public class RangedUnit extends Unit {

    /**
     * A field that represents the amount of attacks that
     * the unit has recieved. Is relevant for the
     * getResistBonus() method.
     */
    private int amountOfRecievedHits = 0;

    /**
     * Simplified constructor with default values for attack and armor
     * 
     * @param name   represents the name of the ranger
     * @param health represents the health of the ranger
     */
    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);
    }

    /**
     * A constructor with all customizeable fields for the ranger-unit
     * 
     * @param name   represents the name of the ranger
     * @param health represents the health of the ranger
     * @param attack represents the rangers damage capability
     * @param armor  represents the rangers protection
     */
    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Abstract method inherited from the Unit-class.
     * 
     * @returns the amount of extra damage that the unit can
     *          deal to the opponent.
     */
    @Override
    public int getAttackBonus() {
        return 3;
    }

    /**
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
