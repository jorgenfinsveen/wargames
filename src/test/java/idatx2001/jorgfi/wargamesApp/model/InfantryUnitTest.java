package idatx2001.jorgfi.wargamesApp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;


/**
 * Tests the InfantryUnit-class.
 * 
 * @author jorgfi
 */
public class InfantryUnitTest {

    /**
     * Declares an instance of the InfantryUnit-class with the
     * main constructor. Checks that all paramaters are correct.
     */
    @Test
    public void testCreationOfInfantryUnitObjectWithMainConstructor() {

        // Positive tests
        InfantryUnit infantryUnit1 = new InfantryUnit("Footman", 100, 75, 50);

        assertEquals("Footman", infantryUnit1.getName());
        assertEquals(100, infantryUnit1.getHealth());
        assertEquals(75, infantryUnit1.getAttack());
        assertEquals(50, infantryUnit1.getArmor());


        // Negative Tests
        assertThrows(IllegalArgumentException.class, () -> {
            InfantryUnit infantryUnit2 = new InfantryUnit("",-100,-100,-100);
        });
    }

    /**
     * Declares an instance of the InfantryUnit-class with the
     * simplified constructor. Checks that both given and default
     * parameters are correct.
     */
    @Test
    public void testCreationOfInfantryUnitObjectWithSimpleConstructor() {

        // Positive Tests
        InfantryUnit infantryUnit1 = new InfantryUnit("Grunt", 125);

        assertEquals("Grunt", infantryUnit1.getName());
        assertEquals(125, infantryUnit1.getHealth());
        assertEquals(15, infantryUnit1.getAttack());
        assertEquals(10, infantryUnit1.getArmor());


        // Negative Tests
        assertThrows(IllegalArgumentException.class, () -> {
            InfantryUnit infantryUnit2 = new InfantryUnit("",-100);
        });
    }

    /**
     * Tests that the getAttackBonus() and getResistBonus() methods returns
     * correct values;
     */
    @Test
    public void testGettersForAttackBonusAndResistBonus() {
        InfantryUnit infantryUnit = new InfantryUnit("Grunt", 125);

        assertEquals(2, infantryUnit.getAttackBonus());
        assertEquals(1, infantryUnit.getResistBonus());
    }
}
