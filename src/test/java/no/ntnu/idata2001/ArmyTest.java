package no.ntnu.idata2001;

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
        ArrayList armyList = new ArrayList<Unit>();

        for (int i = 0; i < 500; i++) {
            armyList.add(new InfantryUnit("Infantry", 100));
        }
        for (int i = 0; i < 100; i++) {
            armyList.add(new CavalryUnit("Cavalry", 100));
            armyList.add(new RangedUnit("Ranger", 100));
        }
        armyList.add(new CommanderUnit("Commander", 180));

        Army army = new Army("Sweedish army", armyList);

        assertEquals("Sweedish army", army.getName());

        // TODO: Check why getAllUnits() returns Unit.toString() for each Unit in
        // armyList

        assertEquals(army, army.getAllUnits());
    }

    /**
     * Tests all acessormethods
     */
    @Test
    public void testGettersAndSetters() {
        Army army = new Army("Norwegian Army");
        assertEquals("Norwegian Army", army.getName());
        army.add(new InfantryUnit("Infantry", 100));
        assertEquals(1, army.getAllUnits().size());
        Unit unit = army.getRandom();
        army.remove(unit);
        assertEquals(0, army.getAllUnits().size());
    }
}
