package idatx2001.jorgfi.wargamesApp.model;

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
        if (!armyOne.hasUnits() || !armyTwo.hasUnits()) throw new IllegalArgumentException("Both armies needs to contain at least 1 warrior");
        if (armyOne.equals(armyTwo)) throw new IllegalArgumentException("An army cannot fight itself");
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
     * @return Army-object which are victorious
     */
    public Army simulate() {
        Army victorious;
        int round = 0;

        while (armyOne.hasUnits() && armyTwo.hasUnits()) {

            if (round % 2 == 0) {
                armyAttack(armyOne, armyTwo);
            } else {
                armyAttack(armyTwo, armyOne);
            }
            armyOne.curseActivation();
            armyTwo.curseActivation();
            round++;
        }
        if (armyOne.hasUnits()) {
            victorious = armyOne;
        } else {
            victorious = armyTwo;
        }
        return victorious;
    }

    /**
     * Performs an attack on a random unit in the opposing army.
     * Removes the defending unit from the army if their health
     * is 0 or lower.
     * @param attacker the army which will be attacking
     * @param defender the army which will be defending
     */
    public void armyAttack(Army attacker, Army defender) {
        Unit attackingUnit = attacker.getRandom();
        Unit defendingUnit = defender.getRandom();
        if (attackingUnit.getClass() != Wizard.class) {
            attackingUnit.attack(defendingUnit);
            if (!defendingUnit.isAlive()) {
                defender.remove(defendingUnit);

            }
            // Wizards doesnt attack, they cast spells
        } else if (attackingUnit.getClass() == WhiteWizardUnit.class) {
            attackingUnit.castSpell(attacker);
        } else if (attackingUnit.getClass() == DarkWizardUnit.class) {
            attackingUnit.castSpell(defender);
        }
    }

    /**
     * Calls simulate() and returns the winner as a String.
     * @return String containing the name of the victorious army
     */
    @Override
    public String toString() {
        return simulate().getName() + " won the battle!";
    }
}
