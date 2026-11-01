package com.smartwastebin;

import java.util.ArrayList;
import java.util.List;

public class SmartWasteBinApp {

    static class WasteBin {

        private final int id;
        private final int fillLevel; // percentage 0-100

        WasteBin(int id, int fillLevel) {
            if (id <= 0) {
                throw new IllegalArgumentException("Bin id must be a positive number");
            }
            if (fillLevel < 0 || fillLevel > 100) {
                throw new IllegalArgumentException("Fill level must be between 0 and 100");
            }
            this.id = id;
            this.fillLevel = fillLevel;
        }

        int getId() {
            return id;
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

    static class BinMonitor {

        private final List<WasteBin> bins = new ArrayList<>();

        void addBin(WasteBin bin) {
            for (WasteBin existing : bins) {
                if (existing.getId() == bin.getId()) {
                    throw new IllegalArgumentException("Bin already exists: " + bin.getId());
                }
            }
            bins.add(bin);
        }

        List<WasteBin> getAllBins() {
            return new ArrayList<>(bins);
        }

        // Highest fill level first
        List<WasteBin> getBinsByPriority() {
            List<WasteBin> sorted = new ArrayList<>(bins);
            sorted.sort((a, b) -> Integer.compare(b.getFillLevel(), a.getFillLevel()));
            return sorted;
        }
    }

    public static void main(String[] args) {
        BinMonitor monitor = new BinMonitor();
        monitor.addBin(new WasteBin(1, 20));
        monitor.addBin(new WasteBin(2, 40));
        monitor.addBin(new WasteBin(3, 65));
        monitor.addBin(new WasteBin(4, 90));

        printHeading("Smart Waste Bin Monitoring System");

        System.out.println();
        System.out.println("All Bin Status:");
        for (WasteBin bin : monitor.getAllBins()) {
            System.out.println(bin);
        }

        System.out.println();
        printHeading("Waste Collection Priority");
        for (WasteBin bin : monitor.getBinsByPriority()) {
            System.out.println(bin);
        }
    }

    private static void printHeading(String title) {
        System.out.println(title);
        System.out.println("-".repeat(title.length()));
    }
}