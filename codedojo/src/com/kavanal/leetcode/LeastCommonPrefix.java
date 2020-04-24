package com.kavanal.leetcode;

public class LeastCommonPrefix {
    public static String longestCommonPrefix(String[] strs) {

        //Base case and edge cases
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        String firstString = strs[0];
        StringBuilder prefix = new StringBuilder(firstString);
        for (int i = 1; i<strs.length; i++ ) {
            StringBuilder compareSB;
            if (prefix.length() < strs[i].length()) {
                compareSB = getMatchingPrefix(prefix.toString(), strs[i]);
            } else {
                compareSB = getMatchingPrefix(strs[i], prefix.toString());
            }

            //If there is no matching prefix, then return empty string
            if (compareSB.length() == 0) {
                return compareSB.toString();
            } else {
                if (compareSB.length() < prefix.length()) {
                    prefix = new StringBuilder(compareSB.toString());
                }
            }
        }
        return prefix.toString();
    }

    // Keep adding to StringBuilder until match not found
    private static StringBuilder getMatchingPrefix(String str1, String str2) {
        StringBuilder sb = new StringBuilder("");
        int i = 0;
        while (i < str1.length() && str1.charAt(i) == str2.charAt(i)) {
            sb.append(str1.charAt(i));
            i++;
        }

        return sb;
    }

    public static void main (String[] args) {
        String[] inputStrs = {"flower", "flow", "flight", "flawless"};
        System.out.println(longestCommonPrefix(inputStrs));
        String[] inputStrs2 = {"dog", "car", "flight"};
        System.out.println(longestCommonPrefix(inputStrs2));
    }
}
