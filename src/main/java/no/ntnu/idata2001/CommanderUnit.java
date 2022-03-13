package no.ntnu.idata2001;

/**
 * Represents a more capable verion of a CavalryUnit. It
 * inherits all the fields and methods from the CavalryUnit class,
 * but it has a better default values for attack and armor.
 * 
 * @author jorgfi
 */
public class CommanderUnit extends CavalryUnit {

    /**
     * Simplified constructor with default values for attack and armor
     * 
     * @param name   represents the commanders name
     * @param health represents the commanders health
     */
    public CommanderUnit(String name, int health) {
        super(name, health, 25, 15);
    }

    /**
     * An advanced constructor with full customization options for the
     * commanders fields
     * 
     * @param all are inherited from CavalryUnit, which again
     *            inherits them from the Unit-class
     */
    public CommanderUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }
}
