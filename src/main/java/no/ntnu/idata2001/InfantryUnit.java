package no.ntnu.idata2001;

public class InfantryUnit extends Unit {

    public InfantryUnit() {
        super();
        this.attack = 15;
        this.armor = 10;

    }

    @Override
    public void attack(Unit opponent) {
        opponent.setHealth(this.attack + getAttackBonus());
    }

    @Override
    public int getAttackBonus() {
        return 2;
    }

    @Override
    public int getResistBonus() {
        // TODO Auto-generated method stub
        return 1;
    }
}
