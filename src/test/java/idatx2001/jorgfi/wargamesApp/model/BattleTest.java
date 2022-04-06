package idatx2001.jorgfi.wargamesApp.model;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


/**
 * Tests the Battle-class. It is also used
 * to test that the entire game is working so far.
 * 
 * @author jorgfi
 */
public class BattleTest {

    UnitFactory factory = new UnitFactory();

    /**
     * Tests the simulation.
     * Declares two ArrayLists which represents two armies. It
     * fills them up with different warriors based on the example
     * from the task-assignment.
     * The two ArrayLists are used as parameters for two different
     * armies. The main constructor of the army-class is used here.
     * Declares an instance of the battle class and simulates a
     * battle between the two armies. The winner army are to be
     * written out to the console.
     */
    @Test
    public void testSimulation() {

        // Positive Test
        ArrayList<Unit> armyList1 = new ArrayList<>();
        ArrayList<Unit> armyList2 = new ArrayList<>();

        // Fills armyList1
        armyList1.addAll(factory.createListOfUnits(500, "Infantry", "Footman", 100));
        armyList1.addAll(factory.createListOfUnits(100, "Cavalry", "Knight", 100));
        armyList1.addAll(factory.createListOfUnits(100, "Ranger", "Archer", 100));
        armyList1.add(factory.createNewUnit("Commander", "Mountain King", 180));
        
        // Fills armyList2
        armyList2.addAll(factory.createListOfUnits(500, "Infantry", "Grunt", 100));
        armyList2.addAll(factory.createListOfUnits(100, "Cavalry", "Raider", 100));
        armyList2.addAll(factory.createListOfUnits(100, "Ranger", "Spearman", 100));
        armyList2.add(factory.createNewUnit("Commander", "Gul´dan", 180));

        Army army1 = new Army("Human army", armyList1);
        Army army2 = new Army("Orcish horde", armyList2);

        Battle battle = new Battle(army1, army2);
        Army winner = battle.simulate();
        System.out.println(winner.getName() + " wins with " + winner.getAllUnits().size() +
                " warriors left");
        assertTrue(winner.hasUnits());


        // Negative test
        if (winner.equals(army1)) {
            assertFalse(army2.hasUnits());
        } else {
            assertFalse(army1.hasUnits());
        }
        System.out.println(winner.getAllUnits() + " wins");
    }
}
