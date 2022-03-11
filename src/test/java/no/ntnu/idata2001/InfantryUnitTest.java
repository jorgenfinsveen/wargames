package no.ntnu.idata2001;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class InfantryUnitTest {
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
