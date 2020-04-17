package com.kavanal.interviewcake.Hashing;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

import static org.junit.Assert.*;

public class PermutationPalindrome {

    public static boolean hasPalindromePermutation(String theString) {

        // check if any permutation of the input is a palindrome
        // Base case and edge case
        if (theString == null) {
            return false;
        }

        if (theString.isEmpty() || theString.length() < 2){
            return true;
        }

        Set<Character> charStack = new HashSet<>();
        for (char c : theString.toCharArray()) {
            if (charStack.contains(c)) {
                charStack.remove(c);
            } else {
                charStack.add(c);
            }
        }

        return charStack.size() <= 1;
    }


    // tests
    @Test
    public void permutationWithOddNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabcbcd");
        assertTrue(result);
    }

    @Test
    public void permutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabccbdd");
        assertTrue(result);
    }

    @Test
    public void noPermutationWithOddNumberOfChars() {
        final boolean result = hasPalindromePermutation("aabcd");
        assertFalse(result);
    }

    @Test
    public void noPermutationWithEvenNumberOfCharsTest() {
        final boolean result = hasPalindromePermutation("aabbcd");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = hasPalindromePermutation("");
        assertTrue(result);
    }

    @Test
    public void oneCharacterStringTest() {
        final boolean result = hasPalindromePermutation("a");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(PermutationPalindrome.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
