package com.kavanal.interviewcake.qandstacks;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.*;

import static org.junit.Assert.*;

public class OpenCloseValidator {

    public static boolean isValid(String code) {

        // determine if the input code is valid
        Map<Character, Character> validator = new HashMap<>();
        validator.put('{','}');
        validator.put('(',')');
        validator.put('[',']');

        Set<Character> allOpeners = validator.keySet();
        Set<Character> allClosers = new HashSet<>(validator.values());

        Deque<Character> validatorStack = new ArrayDeque<>();

        for (char c : code.toCharArray()) {
            if (allOpeners.contains(c)) {
                validatorStack.push(c);
            } else if (allClosers.contains(c)) {
                if (validatorStack.isEmpty()) {
                    return false;
                } else {
                    Character lastChar = validatorStack.pop();

                    if (validator.get(lastChar) != c) {
                        return false;
                    }
                }
            }
        }

        return validatorStack.isEmpty();
    }

    // tests
    @Test
    public void validShortCodeTest() {
        final boolean result = isValid("()");
        assertTrue(result);
    }

    @Test
    public void validLongerCodeTest() {
        final boolean result = isValid("([]{[]})[]{{}()}");
        assertTrue(result);
    }

    @Test
    public void mismatchedOpenerAndCloserTest() {
        final boolean result = isValid("([][]}");
        assertFalse(result);
    }

    @Test
    public void interleavedOpenersAndClosersTest() {
        final boolean result = isValid("([)]");
        assertFalse(result);
    }

    @Test
    public void missingCloserTest() {
        final boolean result = isValid("[[]()");
        assertFalse(result);
    }

    @Test
    public void extraCloserTest() {
        final boolean result = isValid("[[]]())");
        assertFalse(result);
    }

    @Test
    public void emptyStringTest() {
        final boolean result = isValid("");
        assertTrue(result);
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(OpenCloseValidator.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
