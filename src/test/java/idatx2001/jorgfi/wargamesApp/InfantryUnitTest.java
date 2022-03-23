package idatx2001.jorgfi.wargamesApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
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

        Unit infantryUnit1 = new InfantryUnit("Footman", 100, 75, 50);

        assertEquals("Footman", infantryUnit1.getName());
        assertEquals(100, infantryUnit1.getHealth());
        assertEquals(75, infantryUnit1.getAttack());
        assertEquals(50, infantryUnit1.getArmor());
        assertEquals(2, infantryUnit1.getAttackBonus());
        assertEquals(1, infantryUnit1.getResistBonus());
    }

    /**
     * Declares an instance of the InfantryUnit-class with the
     * simplified constructor. Checks that both given and default
     * parameters are correct.
     */
    @Test
    public void testCreationOfInfantryUnitObjectWithSimpleConstructor() {

        Unit infantryUnit2 = new InfantryUnit("Grunt", 125);

        assertEquals("Grunt", infantryUnit2.getName());
        assertEquals(125, infantryUnit2.getHealth());
        assertEquals(15, infantryUnit2.getAttack());
        assertEquals(10, infantryUnit2.getArmor());
        assertEquals(2, infantryUnit2.getAttackBonus());
        assertEquals(1, infantryUnit2.getResistBonus());
    }
}
