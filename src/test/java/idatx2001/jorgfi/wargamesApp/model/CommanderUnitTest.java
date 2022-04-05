package idatx2001.jorgfi.wargamesApp.model;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

/**
 * Tests the CommanderUnit-class
 * 
 * @author jorgfi
 */
public class CommanderUnitTest {
    
    /**
     * Declares an instance of the CommanderUnit with the main constructor
     * and checks that the fields has proper values.
     */
     @Test
     public void testCreationOfCommanderUnitObjectWithMainConstructor() {

        // Positive Test
        CommanderUnit commanderUnit1 = new CommanderUnit("Chief", 180, 50, 50);
        assertEquals("Chief", commanderUnit1.getName());
        assertEquals(180, commanderUnit1.getHealth());
        assertEquals(50, commanderUnit1.getAttack());
        assertEquals(50, commanderUnit1.getArmor());


        // Negative Test
        assertThrows(IllegalArgumentException.class, () -> {
            CommanderUnit commanderUnit2 = new CommanderUnit("", -100);
        });
     }

     /**
      * Declares an instance of the CommanderUnit with the simplified constructor
      * and checks that the field has proper values.
      */
      @Test
      public void testCreationOfCommanderUnitObjectWithSimplifiedConstructor() {

        // Positive Test
        CommanderUnit commanderUnit1 = new CommanderUnit("Chief", 180);
        assertEquals("Chief", commanderUnit1.getName());
        assertEquals(180, commanderUnit1.getHealth());
        assertEquals(25, commanderUnit1.getAttack());
        assertEquals(15, commanderUnit1.getArmor());


        // Negative Test
        assertThrows(IllegalArgumentException.class, () -> {
            CommanderUnit commanderUnit2 = new CommanderUnit("", -100);
        });
      }

      /**
       * Tests that the getAttackBonus() and getResistBonus() returns proper values
       */
      @Test void testGettersForAttackBonusAndResistBonus() {
          CommanderUnit commanderUnit1 = new CommanderUnit("Chief", 180, 35, 20);
          CommanderUnit commanderUnit2 = new CommanderUnit("Master", 125);
  
          assertEquals(6, commanderUnit1.getAttackBonus());
          commanderUnit1.attack(commanderUnit2);
          assertEquals(2, commanderUnit1.getAttackBonus());
  
          assertEquals(1, commanderUnit1.getResistBonus());
      }

}
