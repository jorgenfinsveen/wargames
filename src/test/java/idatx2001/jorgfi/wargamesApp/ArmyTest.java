package idatx2001.jorgfi.wargamesApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import java.util.ArrayList;
import org.junit.jupiter.api.Test;


/**
 * A test-class which tests the Army-class.
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
        Army army = new Army("Norwegian Army");
        assertEquals("Norwegian Army", army.getName());
    }

    /**
     * Tests that an instance of the Army-class with the main constructor
     * gets correct fields
     */
    @Test
    public void testCreationOfArmyObjectWithMainMethod() {
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

        Army army = new Army("Sweedish army", armyList);

        // Tests that the name of the army is correct
        assertEquals("Sweedish army", army.getName());

        // Tests that all units were added to the army
        assertEquals(armyList, army.getAllUnits());
    }

    // Todo: Add negative tests for constructor with invalid parameters

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
}
