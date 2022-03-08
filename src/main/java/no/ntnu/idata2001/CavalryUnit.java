package no.ntnu.idata2001;

public class CavalryUnit extends Unit {

    private int amountOfDealtHits = 0;

    public CavalryUnit() {
        /**
         * Jeg er ikke 110% sikker på hvordan super() fungerer. Vil dette gjøre
         * at subklassene arver de andre feltene i konstruktøren til Unit, men at
         * attack og armor feltene får unike verdier?
         */
        super();
        this.attack = 20;
        this.armor = 12;
    }

    /**
     * Det er kanskje bedre mtp responsibility driven design at if-setningene er
     * i getAttackBonus funksjonen framfor i attack. Da vil alle subklassene ha helt
     * lik attack-metode, som gjør at jeg kan integrere den i Unit-klassen framfor
     * i subklassene
     */
    @Override
    public void attack(Unit opponent) {
        if (amountOfDealtHits == 0) {
            opponent.setHealth(this.attack + 4 + getAttackBonus());
        } else {
            opponent.setHealth(this.attack + getAttackBonus());
        }
        amountOfDealtHits++;
    }

    @Override
    public int getAttackBonus() {
        return 2;
    }

    @Override
    public int getResistBonus() {
        return 1;
    }

}
