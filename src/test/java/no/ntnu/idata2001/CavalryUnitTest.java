package no.ntnu.idata2001;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class CavalryUnitTest {
    @Test
    public void testCreationOfCavalryUnitObjectWithMainConstructor() {

        Unit cavalryUnit1 = new CavalryUnit("Knight", 100, 75, 50);

        assertEquals("Knight", cavalryUnit1.getName());
        assertEquals(100, cavalryUnit1.getHealth());
        assertEquals(75, cavalryUnit1.getAttack());
        assertEquals(50, cavalryUnit1.getArmor());
    }

    @Test
    public void testCreationOfCavalryUnitObjectWithSimpleConstructor() {

        Unit cavalryUnit2 = new CavalryUnit("Raider", 125);

        assertEquals("Raider", cavalryUnit2.getName());
        assertEquals(125, cavalryUnit2.getHealth());
        assertEquals(20, cavalryUnit2.getAttack());
        assertEquals(12, cavalryUnit2.getArmor());
    }

    @Test
    public void testCorrectValueReturnedFromGetAttackBonusAndGetResistBonus() {
        Unit cavalryUnit1 = new CavalryUnit("Knight", 100, 75, 50);
        Unit cavalryUnit2 = new CavalryUnit("Raider", 125);

        assertEquals(6, cavalryUnit1.getAttackBonus());
        cavalryUnit1.attack(cavalryUnit2);
        assertEquals(2, cavalryUnit1.getAttackBonus());

        assertEquals(1, cavalryUnit1.getResistBonus());
    }
}
