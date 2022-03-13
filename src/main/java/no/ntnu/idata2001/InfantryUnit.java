package no.ntnu.idata2001;

/**
 * A sub-class of the superclass Unit.
 * It inherits the Unit-class fields and methods, and represents
 * a unit of the type infantry in the wargame
 * 
 * @author jorgfi
 */
public class InfantryUnit extends Unit {

    /**
     * Simplified constructor with default values for attack and armor
     * 
     * @param name   represents the name of the infantry-unit
     * @param health represents the health of the infantry-unit
     */
    public InfantryUnit(String name, int health) {
        super(name, health, 15, 10);
    }

    /**
     * A more advanced constructor which allows full customization of the
     * the infantry-units fields
     * 
     * @param name   represents the name of the infantry-unit
     * @param health represents the health of the infantry-unit
     * @param attack represents the amount of damage that the unit can do
     * @param armor  represents the protection of the unit
     */
    public InfantryUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    /**
     * Abstract method inherited from the Unit-class.
     * 
     * @return the amount of extra damage that the unit can
     *         deal.
     */
    @Override
    public int getAttackBonus() {
        return 2;
    }

    /**
     * Abstract method inherited from the Unit-class.
     * 
     * @return the amount of extra resistanse that the unit has.
     */
    @Override
    public int getResistBonus() {
        return 1;
    }
}
