package idatx2001.jorgfi.wargamesApp;

/**
 * Represents a unit of the type infantry in the wargame.
 * Inherits from the Unit-class.
 * 
 * @author jorgfi
 */
public class InfantryUnit extends Unit {

    /**
     * Simplified constructor with default values for attack and armor
     * 
     * @param name   String representing the name of the infantry-unit
     * @param health int the health of the infantry-unit
     */
    public InfantryUnit(String name, int health) {
        super(name, health, 15, 10);
        amountOfRecievedHits = 0;
        numberOfDealtHits = 0;
    }

    /**
     * Constructs an InfantryUnit-instance with all fields customizeable.
     * 
     * @param name   String representing the name of the infantry-unit
     * @param health int the health of the infantry-unit
     * @param attack int the amount of damage that the unit can do
     * @param armor  int the protection of the unit
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
        amountOfRecievedHits = 0;
        numberOfDealtHits = 0;
    }

    /**
     * Abstract method inherited from the Unit-class returning 
     * the attack bonus of this unit
     * 
     * @return int the amount of extra damage that the unit can
     *         deal.
     */
    @Override
    public int getAttackBonus() {
        return 2;
    }

    /**
     * Abstract method inherited from the Unit-class returning 
     * the resist bonus of this unit
     * 
     * @return int the amount of extra resistanse that the unit has.
     */
    @Override
    public int getResistBonus() {
        return 1;
    }
}
