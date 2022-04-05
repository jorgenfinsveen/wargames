package idatx2001.jorgfi.wargamesApp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertThrows;

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

        // Positive test
        RangedUnit rangedUnit1 = new RangedUnit("Archer", 100, 75, 50);

        assertEquals("Archer", rangedUnit1.getName());
        assertEquals(100, rangedUnit1.getHealth());
        assertEquals(75, rangedUnit1.getAttack());
        assertEquals(50, rangedUnit1.getArmor());


        // Negative test
        assertThrows(IllegalArgumentException.class, () -> {
            RangedUnit rangedUnit2 = new RangedUnit("", -100, -100, -100);
        });
    }

    /**
     * Declares an instance of the RangedUnit-class with the
     * simplified constructor. Checks that both given and default
     * parameters are correct.
     */
    @Test
    public void testCreationOfRangedUnitObjectWithSimpleConstructor() {

        // Positive test
        RangedUnit rangedUnit1 = new RangedUnit("Spearman", 125);

        assertEquals("Spearman", rangedUnit1.getName());
        assertEquals(125, rangedUnit1.getHealth());
        assertEquals(15, rangedUnit1.getAttack());
        assertEquals(8, rangedUnit1.getArmor());


         // Negative test
         assertThrows(IllegalArgumentException.class, () -> {
            RangedUnit rangedUnit2 = new RangedUnit("", -100);
        });
    }

    /**
     * Checks that the Ranger-units getAttackBonus() and
     * getResistBonus() gives the correct values as result.
     */
    @Test
    public void testCorrectValueReturnedFromGetAttackBonusAndGetResistBonus() {
        RangedUnit rangedUnit1 = new RangedUnit("Archer", 100, 75, 50);
        RangedUnit rangedUnit2 = new RangedUnit("Spearman", 125);

        assertEquals(3, rangedUnit1.getAttackBonus());
        assertEquals(6, rangedUnit1.getResistBonus());

        rangedUnit2.attack(rangedUnit1);
        assertEquals(4, rangedUnit1.getResistBonus());

        rangedUnit2.attack(rangedUnit1);
        assertEquals(2, rangedUnit1.getResistBonus());
    }
}
