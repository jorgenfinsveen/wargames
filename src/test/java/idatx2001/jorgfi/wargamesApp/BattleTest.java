package idatx2001.jorgfi.wargamesApp;

import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;


/**
 * A test-class which tests the Battle-class. It is also used
 * to test that the entire game is working so far.
 * 
 * @author jorgfi
 */
public class BattleTest {

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

        ArrayList<Unit> armyList1 = new ArrayList<>();
        ArrayList<Unit> armyList2 = new ArrayList<>();

        for (int i = 0; i < 500; i++) {
            armyList1.add(new InfantryUnit("Footman", 100));
            armyList2.add(new InfantryUnit("Grunt", 100));
        }

        for (int i = 0; i < 100; i++) {
            armyList1.add(new CavalryUnit("Knight", 100));
            armyList2.add(new CavalryUnit("Raider", 100));
        }

        for (int i = 0; i < 100; i++) {
            armyList1.add(new RangedUnit("Archer", 100));
            armyList2.add(new RangedUnit("Spearman", 100));
        }

        armyList1.add(new CommanderUnit("Mountain King", 180));
        armyList2.add(new CommanderUnit("Gul´dan", 180));

        Army army1 = new Army("Human army", armyList1);
        Army army2 = new Army("Orcish horde", armyList2);

        Battle battle = new Battle(army1, army2);
        Army winner = battle.simulate();
        System.out.println(winner.getName() + " wins with " + winner.getAllUnits().size() +
                " warriors left");
        assertTrue(winner.hasUnits());
        System.out.println(winner.getAllUnits() + " wins");
    }
}
