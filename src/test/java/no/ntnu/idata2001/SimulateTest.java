package no.ntnu.idata2001;

import java.util.ArrayList;

import org.junit.jupiter.api.Test;

public class SimulateTest {

    @Test
    public void testSimulation() {

        ArrayList armyList1 = new ArrayList<Unit>();
        ArrayList armyList2 = new ArrayList<Unit>();

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

        armyList1.add(new RangedUnit("Mountain King", 180));
        armyList2.add(new RangedUnit("Gul´dan", 180));

        Army army1 = new Army("Human army", armyList1);
        Army army2 = new Army("Orcish horde", armyList2);

        Battle battle = new Battle(army1, army2);
        Army winner = battle.simulate();
        System.out.println(winner.getName() + " - " + winner.hasUnits());
    }

}
