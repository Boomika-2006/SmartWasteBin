package com.smartwastebin;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

public class CollectionPriority {

    public static List<WasteBin> sortByPriority(List<WasteBin> bins) {

        List<WasteBin> sortedBins = new ArrayList<>(bins);

        sortedBins.sort(
            Comparator.comparingInt(WasteBin::getFillLevel).reversed()
        );

        return sortedBins;
    }

    public static void displayPriority(List<WasteBin> bins) {

        System.out.println("Waste Collection Priority");
        System.out.println("-------------------------");

        List<WasteBin> sortedBins = sortByPriority(bins);

        for (WasteBin bin : sortedBins) {
            System.out.println(bin);
        }
    }
}