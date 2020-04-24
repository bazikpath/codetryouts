package com.kavanal.leetcode;

public class NumberPalindrome {
    public boolean isPalindrome(int x) {
        //If the number is negative, it will not be a palindrome
        if (x < 0)
            return false;

        long r = 0;
        int num = x;

        //Reverse the number
        while (num != 0) {
            r = r * 10 + num % 10;
            num = num /10;
        }

        return (r == x);
    }
}
