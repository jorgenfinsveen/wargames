package idatx2001.jorgfi.wargamesApp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;
import org.junit.jupiter.api.Test;


/**
 * Tests the Army-class.
 * 
 * @author jorgfi
 */
public class ArmyTest {

    /**
     * Tests that an instance of the Army-class with the simplified
     * constructor gets correctly initialized
     */
    @Test
    public void testCreationOfArmyObjectWithSimplifiedMethod() {

        // Positive Test
        Army army = new Army("Norwegian Army");
        assertEquals("Norwegian Army", army.getName());


        // Negative Test
        assertThrows(IllegalArgumentException.class, () -> {
            Army army2 = new Army("");
        });
    }

    /**
     * Tests that an instance of the Army-class with the main constructor
     * gets correct fields
     */
    @Test
    public void testCreationOfArmyObjectWithMainMethod() {

        // Positive Test
        ArrayList<Unit> armyList = makeArmyList();
        Army army = new Army("Sweedish army", armyList);

        // Tests that the name of the army is correct
        assertEquals("Sweedish army", army.getName());

        // Tests that all units were added to the army
        assertEquals(armyList, army.getAllUnits());




        // Negative Test 
        ArrayList<Unit> armyList2 = new ArrayList<>();
        // Tests that the list-parameter is not accepted when empty
        assertThrows(IllegalArgumentException.class, () -> {
            Army army2 = new Army("er", armyList2);
        });
    }

    /**
     * Tests all acessormethods
     */
    @Test
    public void testGettersAndSetters() {
        Army army = new Army("Norwegian Army");
        // Tests getName()
        assertEquals("Norwegian Army", army.getName());

        army.add(new InfantryUnit("Infantry", 100));
        // Tests that the unit actually was added to the army
        assertEquals(1, army.getAllUnits().size());

        Unit unit = army.getRandom();
        army.remove(unit);
        // Tests that the unit was removed succesfully
        assertEquals(0, army.getAllUnits().size());
    }

    /**
     * Checks that an army containing units are able to return a 
     * random unit with the getRandom method.
     */
    @Test
    public void testGetRandom() {
        ArrayList<Unit> armyList = makeArmyList();
        Army army = new Army("Norwegian Army", armyList);

        Unit randomUnit = army.getRandom();
        assertNotNull(randomUnit);
        assertTrue(randomUnit instanceof Unit);
    }

    /**
     * Tests that hashCode() method returns a hash code
     */
    @Test
    public void testHashCode() {
        ArrayList<Unit> armyList = makeArmyList();
        Army army = new Army("Norwegian Army", armyList);

        assertNotNull(army.hashCode());
    }


    /**
     * Fills a list with a set og units 
     * 
     * @return ArrayList<Unit> containing units in an army
     */
    public ArrayList<Unit> makeArmyList() {
        ArrayList<Unit> armyList = new ArrayList<>();

        // Fills ArrayList with 500 InfantryUnit instances
        for (int i = 0; i < 500; i++) {
            armyList.add(new InfantryUnit("Infantry", 100));
        }

        // Fills ArrayList with 100 Cavalry- and RangedUnit instances
        for (int i = 0; i < 100; i++) {
            armyList.add(new CavalryUnit("Cavalry", 100));
            armyList.add(new RangedUnit("Ranger", 100));
        }
        // Adds a CommanderUnit to the ArrayList
        armyList.add(new CommanderUnit("Commander", 180));

        return armyList;
    }

}
