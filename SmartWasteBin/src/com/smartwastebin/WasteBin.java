package com.smartwastebin;

public class WasteBin {

    private final int id;
    private final int fillLevel;

    public WasteBin(int id, int fillLevel) {

        if (id <= 0) {
            throw new IllegalArgumentException(
                "Bin id must be a positive number");
        }

        if (fillLevel < 0 || fillLevel > 100) {
            throw new IllegalArgumentException(
                "Fill level must be between 0 and 100");
        }

        this.id = id;
        this.fillLevel = fillLevel;
    }

    public int getBinId() {
        return id;
    }

    public int getFillLevel() {
        return fillLevel;
    }

    public String getStatus() {

        if (fillLevel < 25) {
            return "Empty";
        }
        else if (fillLevel < 60) {
            return "Partially Filled";
        }
        else if (fillLevel < 85) {
            return "Nearly Full";
        }
        else {
            return "Full";
        }
    }

    @Override
    public String toString() {
        return "Bin ID: " + id
                + " | Fill Level: " + fillLevel
                + "% | Status: " + getStatus();
    }
}