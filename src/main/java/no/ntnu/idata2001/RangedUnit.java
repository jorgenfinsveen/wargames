package no.ntnu.idata2001;

public class RangedUnit extends Unit {

    private int amountOfRecievedHits = 0;

    public RangedUnit() {
        super();
        this.attack = 15;
        this.armor = 8;
    }

    /**
     * Denne metoden er såpass lik i de fleste sub-klassene at jeg kanskje kan
     * implementere
     * den i superklassen og heller override den ved behov
     */
    @Override
    public void attack(Unit opponent) {
        opponent.setHealth(this.attack + getAttackBonus());
    }

    @Override
    public int getAttackBonus() {
        return 3;
    }

    @Override
    public int getResistBonus() {
        int bonus = 0;

        if (amountOfRecievedHits == 0) {
            bonus = 6;
        } else if (amountOfRecievedHits == 1) {
            bonus = 4;
        } else {
            bonus = 2;
        }
        return bonus;
    }

}
