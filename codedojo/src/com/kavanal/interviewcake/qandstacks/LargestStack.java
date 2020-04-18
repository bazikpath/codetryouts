package com.kavanal.interviewcake.qandstacks;

import org.junit.Test;
import org.junit.runner.JUnitCore;
import org.junit.runner.Result;
import org.junit.runner.notification.Failure;

import java.util.ArrayDeque;
import java.util.Deque;

import static org.junit.Assert.*;

public class LargestStack {

    // fill in the definitions for push(), pop(), and getMax()
    // If getMax is rare enough, then we can optimize for push and pop  rather than getMax

    public static class MaxStack {
        private final Deque<Integer> mainStack = new ArrayDeque();
        private final Deque<Integer> maxStack = new ArrayDeque();

        public void push(int item) {
            mainStack.push(item);
            if (maxStack.isEmpty() || item > maxStack.peek())
                maxStack.push(item);
        }

        public int pop() {
            int item = mainStack.pop();
            if (!maxStack.isEmpty() && item == maxStack.peek())
                maxStack.pop();
            return item;
        }

        public int getMax() {
            return (maxStack.isEmpty() ? 0 : maxStack.peek());
        }
    }


    // tests

    @Test
    public void maxStackTest() {
        final MaxStack s = new MaxStack();
        s.push(5);
        assertEquals("check max after 1st push", 5, s.getMax());
        s.push(4);
        s.push(7);
        s.push(7);
        s.push(8);
        assertEquals("check before 1st pop", 8, s.getMax());
        assertEquals("check pop #1", 8, s.pop());
        assertEquals("check max after 1st pop", 7, s.getMax());
        assertEquals("check pop #2", 7, s.pop());
        assertEquals("check max after 2nd pop", 7, s.getMax());
        assertEquals("check pop #3", 7, s.pop());
        assertEquals("check max after 3rd pop", 5, s.getMax());
        assertEquals("check pop #4", 4, s.pop());
        assertEquals("check max after 4th pop", 5, s.getMax());
    }

    public static void main(String[] args) {
        Result result = JUnitCore.runClasses(LargestStack.class);
        for (Failure failure : result.getFailures()) {
            System.out.println(failure.toString());
        }
        if (result.wasSuccessful()) {
            System.out.println("All tests passed.");
        }
    }
}
