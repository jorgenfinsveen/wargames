package no.ntnu.idata2001;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Army {
    private String name;
    private List<Unit> units;

    public Army(String name) {
        this.name = name;
        this.units = new ArrayList<>();
    }

    public Army(String name, List<Unit> units) {
        this.name = name;
        this.units = new ArrayList<>();
        this.units.addAll(units);
    }

    public String getName() {
        return this.name;
    }

    public void add(Unit unit) {
        this.units.add(unit);
    }

    public void addAll(List<Unit> units) {
        this.units.addAll(units);
    }

    public void remove(Unit unit) {
        this.units.remove(unit);
    }

    public boolean hasUnits() {
        return !units.isEmpty();
    }

    public List getAllUnits() {
        return this.units;
    }

    public Unit getRandom() {
        Random rand = new Random();
        return units.get(rand.nextInt(units.size()));
    }

    @Override
    public boolean equals(Object object) {
        return this.equals(object);
    }

    /**
     * @Override
     *           public int hashCode() {
     *           return this.hashCode();
     *           }
     */
}
