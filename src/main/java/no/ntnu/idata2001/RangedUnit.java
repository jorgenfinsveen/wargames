package no.ntnu.idata2001;

public class RangedUnit extends Unit {

    private int amountOfRecievedHits = 0;

    public RangedUnit(String name, int health) {
        super(name, health, 15, 8);
    }

    public RangedUnit(String name, int health, int attack, int armor) {
        super(name, health, attack, armor);
    }

    @Override
    public int getAttackBonus() {
        return 3;
    }

    @Override
    public int getResistBonus() {
        int bonus = 0;

        if (amountOfRecievedHits > 2) {
            bonus = 2;
        } else if (amountOfRecievedHits > 1) {
            bonus = 4;
        } else if (amountOfRecievedHits == 0) {
            bonus = 6;
        }
        amountOfRecievedHits++;
        return bonus;
    }
}
