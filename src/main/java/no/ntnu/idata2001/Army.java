package no.ntnu.idata2001;

import java.util.HashSet;

public class Army {
    private String name;
    private HashSet<Unit> units;

    public Army(String name) {
        this.name = name;
        this.units = new HashSet<>();
    }

    public String getName() {
        return this.name;
    }

    public void add(Unit unit) {
        units.add(unit);
    }
}
