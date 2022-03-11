package no.ntnu.idata2001;

public class Battle {

    private Army armyOne;
    private Army armyTwo;

    public Battle(Army armyOne, Army armyTwo) {
        this.armyOne = armyOne;
        this.armyTwo = armyTwo;
    }

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

    public String toString() {
        return simulate().getName() + " won the battle!";
    }
}
