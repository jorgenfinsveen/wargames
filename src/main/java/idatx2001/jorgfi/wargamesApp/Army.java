package idatx2001.jorgfi.wargamesApp;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Represents an Army. It is a collection of different units
 * 
 * @author jorgfi
 */
public class Army {

    /**
     * Fields
     */
    private String name;
    private List<Unit> units;

    /**
     * A constructor which only takes the name parameter.
     * It also declares a list which can be filled with
     * units.
     * 
     * @param name represents the name of the army
     */
    public Army(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    /**
     * A constructor which takes both name and units
     * as parameters. This constructor allows the user
     * to insert a prefilled list of units which the
     * army consists of.
     * 
     * @param name  represents the name of the army
     * @param units represents a list of units which are the
     *              soldiers of the army.
     */
    public Army(String name, List<Unit> units) {
        this.name = name;
        // Declares an ArrayList and fills it with the contents of units
        this.units = new ArrayList<>();
        this.units.addAll(units);
    }

    /**
     * Acesssor-method to get the name of the army
     * 
     * @return String name of the army
     */
    public String getName() {
        return this.name;
    }

    /**
     * Method to add a unit to the units ArrayList which
     * represents the army members.
     * 
     * @param unit to be added
     */
    public void add(Unit unit) {
        if (unit != null) {
            this.units.add(unit);
        } else {
            throw new IllegalArgumentException("The input was invalid");
        }
    }

    /**
     * Method that adds all elements of a list to the units
     * ArrayList, which holds the members of the army
     * 
     * @param units list of units to be added to the army
     */
    public void addAll(List<Unit> units) {
        if (units != null) {
            this.units.addAll(units);
        } else {
            throw new IllegalArgumentException("There was no warriors in the army");
        }
    }

    /**
     * Method that removes a unit from the army. Units are
     * removed when the health equals 0 in the wargame.
     * 
     * @param unit the unit which are to be removed
     */
    public void remove(Unit unit) {
        if (unit != null) {
            this.units.remove(unit);
        } else {
            throw new IllegalArgumentException("ERROR: Unit doesnt exist");
        }
    }

    /**
     * Method that checks if the army has any units in it.
     * 
     * @return boolean (empty = true)
     */
    public boolean hasUnits() {
        return !units.isEmpty();
    }

    /**
     * Method that returns all the units in the army
     * 
     * @return List
     */
    public ArrayList<Unit> getAllUnits() {
        return (ArrayList<Unit>) this.units;
    }

    /**
     * Method that picks a random unit from the army
     * 
     * @return random Unit
     */
    public Unit getRandom() {
        Random rand = new Random();
        return units.get(rand.nextInt(units.size()));
    }

    /**
     * Checks if two objects are equal.
     * 
     * @param object to be compared with
     * @return boolean (equal = true)
     */
    @Override
    public boolean equals(Object object) {
        if (this == object)
            return true;
        if (object == null || getClass() != object.getClass())
            return false;
        Army army = (Army) object;
        return Objects.equals(name, army.name) && Objects.equals(units, army.units);
    }

    /**
     * Generates a hashcode based on the army name and contents
     * 
     * @return int hashcode
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, units);
    }

}
