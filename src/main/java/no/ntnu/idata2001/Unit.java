package no.ntnu.idata2001;

/**
 * Kunne egt ha trengt en kjapp gjennomgang på commit, og at pom-filen
 * har det den trenger av informasjon
 */

/**
 * Kunne også trengt en oppfriskning i hvordan man lager passende
 * testklasser til alle klassene, bare så jeg er sikker på at jeg
 * får de implementert på en bra måte
 */

/**
 * Står at jeg fikk comitted på riktig måte både i terminalen og i sourcetree,
 * men den dukker ikke opp her i vsc
 */

public abstract class Unit {

    /**
     * Blir det riktig å bruke protected her? Fikk feilmelding når jeg
     * brukte private, men vil jo implementere encapsulation så mye som mulig.
     * Kunne kanskje fått en kjapp definisjon på de forskjellige public, private
     * protected osv. er, når de burde brukes og hva som skiller dem fra hverandre
     */
    private String name;
    private int health;
    private int attack;
    private int armor;

    // Constructor
    public Unit(String name, int health, int attack, int armor) {
        this.name = name;
        this.health = health;
        this.attack = attack;
        this.armor = armor;
    }

    /**
     * @return String name of the unit
     */
    public String getName() {
        return name;
    }

    /**
     * @return int health of the unit
     */
    public int getHealth() {
        return health;
    }

    /**
     * @return int health of the unit
     */
    public int getAttack() {
        return attack;
    }

    /**
     * @return int armor of the unit
     */
    public int getArmor() {
        return armor;
    }

    /**
     * Grei nok string å bruke?
     */
    public String toString() {
        return getName() + " has " + getHealth() + "hp left.";
    }

    /**
     * Burde jeg gjøre om på hvordan health justeres?
     * Evt burde denne mutatoren brukes for å "skade" en
     * unit? Hvordan kan jeg evt ellers gjøre det her?
     * 
     * @param health of the unit
     */
    public void setHealth(int health) {
        this.health = health;
        if (this.health < 0) {
            this.health = 0;
        }
    }

    public abstract void attack(Unit opponent);

    public abstract int getAttackBonus();

    public abstract int getResistBonus();
}
