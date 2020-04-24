package com.kavanal.interviewcake.qandstacks;
import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class ParanthesisValidator {

    public static int getClosingParen(String sentence, int openingParenIndex) {

        int matchingIndex = 0;
        final char OPENING_PARAN = '(';
        final char CLOSING_PARAN = ')';

        //Alternative simple method - We could keep to O(1) space if we just keep a number to increment/decrement
        //Base case and edge cases
        if (sentence == null || sentence.isEmpty() || sentence.length() <= openingParenIndex)
            return matchingIndex;
        // find the position of the matching closing parenthesis
        Deque<Character> bracketStack = new ArrayDeque<>();

        for (int i = openingParenIndex; i< sentence.length(); i++) {
            char currentChar = sentence.charAt(i);
            if (currentChar == OPENING_PARAN) {
                bracketStack.push(currentChar);
            } else if (currentChar == CLOSING_PARAN) {
                bracketStack.pop();
                if (bracketStack.isEmpty())
                    return i;
            }
        }


        return matchingIndex;
    }


    // tests

    @Test
    public void allOpenersThenClosersTest() {
        final int expected = 7;
        final int actual = getClosingParen("((((()))))", 2);
        assertEquals(expected, actual);
    }

    @Test
    public void mixedOpenersAndClosersTest() {
        final int expected = 10;
        final int actual = getClosingParen("()()((()()))", 5);
        assertEquals(expected, actual);
    }

    @Test
    public void noMatchingCloserTest() {
        final int actual = getClosingParen("()(()", 2);
        assertEquals(0, actual);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(ParanthesisValidator.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
