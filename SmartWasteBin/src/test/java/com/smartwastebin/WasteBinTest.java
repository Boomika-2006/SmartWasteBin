package com.smartwastebin;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class WasteBinTest {

    @Test
    void testEmptyBin() {
        WasteBin bin = new WasteBin(1, 20);
        assertEquals("Empty", bin.getStatus());
    }

    @Test
    void testPartiallyFilledBin() {
        WasteBin bin = new WasteBin(2, 40);
        assertEquals("Partially Filled", bin.getStatus());
    }

    @Test
    void testNearlyFullBin() {
        WasteBin bin = new WasteBin(3, 65);
        assertEquals("Nearly Full", bin.getStatus());
    }

    @Test
    void testFullBin() {
        WasteBin bin = new WasteBin(4, 90);
        assertEquals("Full", bin.getStatus());
    }

    @Test
    void testInvalidFillLevel() {
        assertThrows(IllegalArgumentException.class,
            () -> new WasteBin(5, 101));

        assertThrows(IllegalArgumentException.class,
            () -> new WasteBin(5, -1));
    }

    @Test
    void testInvalidBinId() {
        assertThrows(IllegalArgumentException.class,
            () -> new WasteBin(0, 50));
    }
}