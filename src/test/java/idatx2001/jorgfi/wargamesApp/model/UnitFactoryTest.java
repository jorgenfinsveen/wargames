package idatx2001.jorgfi.wargamesApp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

/**
 * Tests the functionality of the UnitFactory-class
 * 
 * @author jorgfi
 */
public class UnitFactoryTest {
    UnitFactory factory = new UnitFactory();

    /**
     * Tests the creation of single unit with valid and invalid parameters.
     */
    @Test
    public void testCreateNewUnitMethod() {
        // Positive test
        Unit posUnit = factory.createNewUnit("Ranger", "Archer", 100);
        assertEquals("Ranger", posUnit.getType());
        assertEquals("Archer", posUnit.getName());
        assertEquals(100, posUnit.getHealth());


        // Negative test
        Unit negUnit1 = factory.createNewUnit("Mage", "Dumbledore", 100);
        Unit negUnit2 = factory.createNewUnit("Ranger", "", 100);
        Unit negUnit3 = factory.createNewUnit("Ranger", "Archer", 0);
        assertNull(negUnit1);
        assertNull(negUnit2);
        assertNull(negUnit3);
    }


    /**
     * Tests the creation of multiple units with valid and invalid parameters.
     */
    @Test
    public void testCreateListOfUnits() {
        // Positive test 
        ArrayList<Unit> armyList = new ArrayList<Unit>();
        armyList.addAll(factory.createListOfUnits(5, "Cavalry", "Knight", 100));
        Army army = new Army("Norwegian army", armyList); 
        Unit randomUnit = army.getRandom();

        assertEquals("Cavalry", randomUnit.getType());
        assertEquals("Knight", randomUnit.getName());
        assertEquals(100, randomUnit.getHealth());
        assertEquals(5, army.getArmySize());


        // Negative test
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createListOfUnits(0, "Infantry", "Grunt", 100);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createListOfUnits(10, "Soldier", "Seargant", 100);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createListOfUnits(10, "Infantry", "", 100);
        });
        assertThrows(IllegalArgumentException.class, () -> {
            factory.createListOfUnits(10, "Infantry", "Grunt", 0);
        });
    }
}
