package com.kavanal.interviews;

public class CheckIsNumber {
    /**
     * The IsNumber function takes a String and returns true if that string is a number, and false otherwise.
     * This implementation, however, has several bugs in it. Your task is to find and fix those bugs.
     * Please note that you should be fixing bugs in this implementation, not implementing your own version.
     * Parameters:
     *  - Numbers should be base-10 only. They may be negative, and may have decimal portions
     *  - Numbers should not have any size restrictions (as might be imposed by the sizes of doubles or longs)
     *  - Numbers should not have any extra characters, such as whitespace or letters
     *  - Numbers should not have leading zeros (007 is a secret agent, not a number)
     *  - 0.5, .01, 9., and 1.000 are all numbers, however. 00.5 is not.
     * Keep in mind that an engineer will be reviewing your code, and write it in a way that would pass a peer code review
     */

    static boolean isNumber(String toTest) {
        boolean hasNonZeroChar = false;

        for (int i = 0; i < toTest.length(); i++) {
            char c = toTest.charAt(i);
            if (c == '.') {
                continue;
            }
            else if (c >= '1' && c < '9') hasNonZeroChar = true;
            else if (c == '0') {
                if (!hasNonZeroChar) {
                    if (i < toTest.length() - 1) {
                        if (toTest.charAt(i+1) == '.') continue;
                        else return false;
                    } else break;
                }
            }
            else if (c == '-') {
                if (i != 0) return false;
            }
        }
        return true;

    }
    public static void main(String[] args) {
        System.out.println( isNumber("001234.90"));
    }
}