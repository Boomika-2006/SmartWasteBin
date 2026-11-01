package com.smartwastebin;

import java.util.ArrayList;
import java.util.List;

public class Main {

    public static void main(String[] args) {

        List<WasteBin> bins = new ArrayList<>();

        bins.add(new WasteBin(1, 20));
        bins.add(new WasteBin(2, 40));
        bins.add(new WasteBin(3, 65));
        bins.add(new WasteBin(4, 90));

        System.out.println("Smart Waste Bin Monitoring System");
        System.out.println("---------------------------------");

        System.out.println("\nAll Bin Status:");

        for (WasteBin bin : bins) {
            System.out.println(bin);
        }

        System.out.println();

        CollectionPriority.displayPriority(bins);
    }
}