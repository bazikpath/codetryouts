package com.kavanal.interviewcake.arrays;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import static org.junit.Assert.*;

public class MergeSortedArrays {

    public static int[] mergeArrays(int[] myArray, int[] alicesArray) {

        int[] mergedArray = new int[myArray.length + alicesArray.length];

        int currentAlicesIndex = 0;
        int currentMyIndex =0;
        int currentMergedIndex = 0;

        while (currentMergedIndex < mergedArray.length) {
            boolean isMyArrayDone = currentMyIndex >= myArray.length;
            boolean isAlicesArrayDone = currentAlicesIndex >= alicesArray.length;

            if (!isMyArrayDone && (isAlicesArrayDone || (myArray[currentMyIndex] < alicesArray[currentAlicesIndex]))) {
                mergedArray[currentMergedIndex] = myArray[currentMyIndex];
                currentMyIndex++;
            } else {
                mergedArray[currentMergedIndex] = alicesArray[currentAlicesIndex];
                currentAlicesIndex++;
            }

            currentMergedIndex++;
        }

        return mergedArray;
    }

    // tests

    @Test
    public void bothArraysAreEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {};
        final int[] expected = {};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void firstArrayIsEmptyTest() {
        final int[] myArray = {};
        final int[] alicesArray = {1, 2, 3};
        final int[] expected = {1, 2, 3};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void secondArrayIsEmptyTest() {
        final int[] myArray = {5, 6, 7};
        final int[] alicesArray = {};
        final int[] expected = {5, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void bothArraysHaveSomeNumbersTest() {
        final int[] myArray = {2, 4, 6};
        final int[] alicesArray = {1, 3, 7};
        final int[] expected = {1, 2, 3, 4, 6, 7};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    @Test
    public void arraysAreDifferentLengthsTest() {
        final int[] myArray = {2, 4, 6, 8};
        final int[] alicesArray = {1, 7};
        final int[] expected = {1, 2, 4, 6, 7, 8};
        final int[] actual = mergeArrays(myArray, alicesArray);
        assertArrayEquals(expected, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(MergeSortedArrays.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}