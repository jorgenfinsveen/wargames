package idatx2001.jorgfi.wargamesApp.model;

import java.util.ArrayList;
import java.util.List;

/**
 * Represents a factory for units in the wargame. 
 * Contains methods for creating a single og several units. 
 * 
 * @author jorgfi
 */
public class UnitFactory {
    
    public static final List<String> UNIT_TYPES = List.of("Ranger", "Infantry", "Commander", "Cavalry");

    
    /** 
     * Creates a new unit with the given type, name and health
     * 
     * @param type String type of unit e.g. CavalryUnit
     * @param name String name which the unit will be called
     * @param health int health of the unit
     * @return Unit
     */
    public Unit createNewUnit(String type, String name, int health) {
        if (health <= 0 || name.isEmpty()) {return null;}
        switch (type) {
            // This is a switch statement. It is checking the type of unit and returning the correct
            // type of unit.
            case "Ranger": return new RangedUnit(name, health);
            case "Infantry": return  new InfantryUnit(name, health);
            case "Commander": return new CommanderUnit(name, health);
            case "Cavalry": return new CavalryUnit(name, health);
            default: return null;
        }
    }
   
    /**
     * Creates several units of a given type, name and health in a list.
     * This will create n identical units with matching fields.
     * 
     * @param amount int amount of units to create
     * @param type String type of the units
     * @param name String what to call the units
     * @param health int health of the units
     * @return List of units produced
     * @throws IllegalArgumentException if the parameters are invalid
     */
    public List<Unit> createListOfUnits(int amount, String type, String name, int health) throws IllegalArgumentException {
        List<Unit> units = new ArrayList<>();

        if (!(UNIT_TYPES.contains(type))) {throw new IllegalArgumentException("That is not a valid type");}
        if (amount <= 0) {throw new IllegalArgumentException("There must be at least one unit");}
        if (health <= 0) {throw new IllegalArgumentException("Health must be greater than 0");}
        if (name.isEmpty()) {throw new IllegalArgumentException("Name must not be empty");}

        for(int i = 0; i < amount; i++) {
            units.add(createNewUnit(type, name, health));
        }
        return units;
    }
}
