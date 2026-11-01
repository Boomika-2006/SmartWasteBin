package com.smartwastebin;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import java.util.ArrayList;
import java.util.List;

import org.junit.jupiter.api.Test;

public class WasteBinTest {

    static class Bin {

        private final int id;
        private final int fillLevel; // percentage 0-100

        Bin(int id, int fillLevel) {
            if (id <= 0) {
                throw new IllegalArgumentException("Bin id must be a positive number");
            }
            if (fillLevel < 0 || fillLevel > 100) {
                throw new IllegalArgumentException("Fill level must be between 0 and 100");
            }
            this.id = id;
            this.fillLevel = fillLevel;
        }

        int getFillLevel() {
            return fillLevel;
        }

        String getStatus() {
            if (fillLevel < 25) {
                return "Empty";
            } else if (fillLevel < 60) {
                return "Partially Filled";
            } else if (fillLevel < 85) {
                return "Nearly Full";
            } else {
                return "Full";
            }
        }

        @Override
        public String toString() {
            return "Bin ID: " + id + " | Fill Level: " + fillLevel + "% | Status: " + getStatus();
        }
    }

    // ---------------- JUnit tests ----------------

    @Test
    void testEmptyBin() {
        assertEquals("Empty", new Bin(1, 20).getStatus());
    }

    @Test
    void testPartiallyFilledBin() {
        assertEquals("Partially Filled", new Bin(2, 40).getStatus());
    }

    @Test
    void testNearlyFullBin() {
        assertEquals("Nearly Full", new Bin(3, 65).getStatus());
    }

    @Test
    void testFullBin() {
        assertEquals("Full", new Bin(4, 90).getStatus());
    }

    @Test
    void testInvalidFillLevelRejected() {
        assertThrows(IllegalArgumentException.class, () -> new Bin(5, 101));
        assertThrows(IllegalArgumentException.class, () -> new Bin(5, -1));
    }

    // ---------------- Report (Java Application) ----------------

    public static void main(String[] args) {
        List<Bin> bins = new ArrayList<>();
        bins.add(new Bin(1, 20));
        bins.add(new Bin(2, 40));
        bins.add(new Bin(3, 65));
        bins.add(new Bin(4, 90));

        printHeading("Smart Waste Bin Monitoring System");
        System.out.println();
        System.out.println("All Bin Status:");
        for (Bin bin : bins) {
            System.out.println(bin);
        }

        List<Bin> sorted = new ArrayList<>(bins);
        sorted.sort((a, b) -> Integer.compare(b.getFillLevel(), a.getFillLevel()));

        System.out.println();
        printHeading("Waste Collection Priority");
        for (Bin bin : sorted) {
            System.out.println(bin);
        }
    }

    private static void printHeading(String title) {
        System.out.println(title);
        System.out.println("-".repeat(title.length()));
    }
}