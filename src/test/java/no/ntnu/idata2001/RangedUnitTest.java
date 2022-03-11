package no.ntnu.idata2001;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;

/**
 * Unit test for simple App.
 */
public class RangedUnitTest {
    @Test
    public void testCreationOfRangedUnitObjectWithMainConstructor() {

        Unit rangedUnit1 = new RangedUnit("Archer", 100, 75, 50);

        assertEquals("Archer", rangedUnit1.getName());
        assertEquals(100, rangedUnit1.getHealth());
        assertEquals(75, rangedUnit1.getAttack());
        assertEquals(50, rangedUnit1.getArmor());
    }

    @Test
    public void testCreationOfRangedUnitObjectWithSimpleConstructor() {

        Unit rangedUnit2 = new RangedUnit("Spearman", 125);

        assertEquals("Spearman", rangedUnit2.getName());
        assertEquals(125, rangedUnit2.getHealth());
        assertEquals(15, rangedUnit2.getAttack());
        assertEquals(8, rangedUnit2.getArmor());
    }

    @Test
    public void testCorrectValueReturnedFromGetAttackBonusAndGetResistBonus() {
        Unit rangedUnit1 = new RangedUnit("Archer", 100, 75, 50);
        Unit rangedUnit2 = new RangedUnit("Spearman", 125);

        assertEquals(3, rangedUnit1.getAttackBonus());
        assertEquals(6, rangedUnit1.getResistBonus());

        rangedUnit2.attack(rangedUnit1);
        assertEquals(4, rangedUnit1.getResistBonus());

        rangedUnit2.attack(rangedUnit1);
        assertEquals(2, rangedUnit1.getResistBonus());
    }
}
