package idatx2001.jorgfi.wargamesApp;

/**
 * Represents a simulation of a battle between to armies.
 * 
 * @author jorgfi
 */
public class Battle {

    // Fields which contain the armies which will be fighting
    private Army armyOne;
    private Army armyTwo;

    /**
     * Constructor that takes in two Army-objects as parameters
     * 
     * @param armyOne the first army
     * @param armyTwo the opposing army
     */
    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

    /**
     * Simulates a battle between the two armies.
     * While both armies has units in them, the method
     * will pick two random units from each army and run
     * their attack-methods on each other. When one of the
     * opponents dies, the loosing opponent will be removed
     * from its army, since its now "dead". This loop will
     * continue until one of the armies dont have ant units left.
     * 
     * @return the army which conqures the other army
     */
    public Army simulate() {
        Unit opponent1;
        Unit opponent2;
        Army victorious;

        while (armyOne.hasUnits() && armyTwo.hasUnits()) {
            opponent1 = armyOne.getRandom();
            opponent2 = armyTwo.getRandom();

            while (opponent1.getHealth() > 0 && opponent2.getHealth() > 0) {
                opponent1.attack(opponent2);
                opponent2.attack(opponent1);
            }
            if (opponent1.getHealth() == 0) {
                armyOne.remove(opponent1);
            } else {
                armyTwo.remove(opponent2);
            }
        }
        if (armyOne.hasUnits()) {
            victorious = armyOne;
        } else {
            victorious = armyTwo;
        }
        return victorious;
    }

    /**
     * @return String containing the name of the victorious army
     */
    public String toString() {
        return simulate().getName() + " won the battle!";
    }
}
