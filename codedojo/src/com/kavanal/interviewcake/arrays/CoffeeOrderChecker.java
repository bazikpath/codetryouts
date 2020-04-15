package com.kavanal.interviewcake.arrays;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class CoffeeOrderChecker {

    public static boolean isFirstComeFirstServed(int[] takeOutOrders, int[] dineInOrders, int[] servedOrders) {

        int takeOutIndex = 0;
        int dineInIndex = 0;
        // check if we're serving orders first-come, first-served
        for (int order : servedOrders) {
            if (takeOutIndex < takeOutOrders.length && order == takeOutOrders[takeOutIndex]) {
                takeOutIndex++;
            } else if (dineInIndex < dineInOrders.length && order == dineInOrders[dineInIndex]) {
                dineInIndex++;
            } else {
                return false;
            }
        }

        if (takeOutIndex != takeOutOrders.length || dineInIndex != dineInOrders.length)
            return false;

        return true;
    }


    // tests

    @Test
    public void bothRegistersHaveSameNumberOfOrdersTest() {
        final int[] takeOutOrders = {1, 4, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 2, 3, 4, 5, 6};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertTrue(result);
    }

    @Test
    public void registersHaveDifferentLengthsTest() {
        final int[] takeOutOrders = {1, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 2, 6, 3, 5};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void oneRegisterIsEmptyTest() {
        final int[] takeOutOrders = {};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {2, 3, 6};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertTrue(result);
    }

    @Test
    public void servedOrdersIsMissingOrdersTest() {
        final int[] takeOutOrders = {1, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 6, 3, 5};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void servedOrdersHasExtraOrders() {
        final int[] takeOutOrders = {1, 5};
        final int[] dineInOrders = {2, 3, 6};
        final int[] servedOrders = {1, 2, 3, 5, 6, 8};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    @Test
    public void oneRegisterHasExtraOrders() {
        final int[] takeOutOrders = {1, 9};
        final int[] dineInOrders = {7, 8};
        final int[] servedOrders = {1, 7, 8};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }


    @Test
    public void oneRegisterHasUnservedOrders() {
        final int[] takeOutOrders = {55, 9};
        final int[] dineInOrders = {7, 8};
        final int[] servedOrders = {1, 7, 8, 9};
        final boolean result = isFirstComeFirstServed(takeOutOrders, dineInOrders, servedOrders);
        assertFalse(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(CoffeeOrderChecker.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
