package com.kavanal.interviewcake.sortnsearch;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class FindRotationPoint {

    public static int findRotationPoint(String[] words) {

        //Base and Edge case
        if (words.length < 2)
            return 0;

        // find the rotation point in the array
        final String firstWord = words[0];
        int floor = 0;
        int ceiling = words.length - 1;

        // Keep going until we reach a rotation point
        while (floor < ceiling) {
            int midIndex = floor + ((ceiling - floor) / 2);
            if (words[midIndex].compareToIgnoreCase(firstWord) >= 0) {
                floor = midIndex;
            } else  {
                ceiling = midIndex;
            }

            if ((floor + 1) == ceiling) {
                break;
            }
        }

        return ceiling;
    }


    // tests

    @Test
    public void smallArrayTest() {
        final int actual = findRotationPoint(new String[] {"cape", "cake"});
        final int expected = 1;
        assertEquals(expected, actual);
    }

    @Test
    public void mediumArrayTest() {
        final int actual = findRotationPoint(new String[] {"grape", "orange", "plum",
                "radish", "apple"});
        final int expected = 4;
        assertEquals(expected, actual);
    }

    @Test
    public void largeArrayTest() {
        final int actual = findRotationPoint(
                new String[] {"ptolemaic", "retrograde", "supplant", "undulate", "xenoepist",
                        "asymptote", "babka", "banoffee", "engender", "karpatka", "othellolagkage"});
        final int expected = 5;
        assertEquals(expected, actual);
    }

    @Test
    public void possiblyMissingEdgeCaseTest() {
        // are we missing any edge cases?
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(FindRotationPoint.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
