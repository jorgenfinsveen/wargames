package idatx2001.jorgfi.wargamesApp;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.jupiter.api.Test;


/**
 * Tests the RangedUnit-class.
 * 
 * @author jorgfi
 */
public class RangedUnitTest {

    /**
     * Declares an instance of the RangedUnit-class with the
     * main constructor. Checks that all paramaters are correct.
     */
    @Test
    public void testCreationOfRangedUnitObjectWithMainConstructor() {

        Unit rangedUnit1 = new RangedUnit("Archer", 100, 75, 50);

        assertEquals("Archer", rangedUnit1.getName());
        assertEquals(100, rangedUnit1.getHealth());
        assertEquals(75, rangedUnit1.getAttack());
        assertEquals(50, rangedUnit1.getArmor());
    }

    /**
     * Declares an instance of the RangedUnit-class with the
     * simplified constructor. Checks that both given and default
     * parameters are correct.
     */
    @Test
    public void testCreationOfRangedUnitObjectWithSimpleConstructor() {

        Unit rangedUnit2 = new RangedUnit("Spearman", 125);

        assertEquals("Spearman", rangedUnit2.getName());
        assertEquals(125, rangedUnit2.getHealth());
        assertEquals(15, rangedUnit2.getAttack());
        assertEquals(8, rangedUnit2.getArmor());
    }

    /**
     * Checks that the Ranger-units getAttackBonus() and
     * getResistBonus() gives the correct values as result.
     */
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
