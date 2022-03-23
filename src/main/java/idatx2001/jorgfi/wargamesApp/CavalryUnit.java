package idatx2001.jorgfi.wargamesApp;

/**
 * A sub-class that inherit from the super class Unit. It represents
 * a unit of the type cavalry in the game.
 * 
 * @author jorgfi
 */
public class CavalryUnit extends Unit {

    /**
     * Field which tells if the unit has attacked
     * another unit. Relevant for the
     * getAttackBonus() method.
     */

    private boolean dealtHits = false;

    /**
     * Simple constructor with suggested values for attack
     * and armor
     * 
     * @param name   represents the name of the unit
     * @param health represents the health of the unit
     */
    public CavalryUnit(String name, int health) {
        // Inherits name and health from the super-class
        // But has own values for attack and armor
        super(name, health, 20, 12);
    }

    /**
     * More advanced constructor which contains all fields
     * from the super-class
     * 
     * @param name   represents the units name
     * @param health represents the heath of the unit
     * @param attack represents the amount of damage possible for this unit
     * @param armor  represents the protection around the unit
     */
    public CavalryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Abstract method from the Unit class.
     * Calculates the bonus damage for which the unit can deal
     * 
     * @return the bonus as an integer. The units attack bonus
     *         starts at a value of 6, but decreases to 2 after the
     *         first attack
     */
    @Override
    public int getAttackBonus() {
        int bonus;
        if (!dealtHits) {
            bonus = 6;
        } else {
            bonus = 2;
        }
        dealtHits = true;
        return bonus;
    }

    /**
     * Abstract method from the Unit class.
     * Calculates the bonus resistance that the unit has
     * 
     * @return the integer 1, which is the add-on resistance
     *         which this unit recieves
     */
    @Override
    public int getResistBonus() {
        return 1;
    }

}
