package com.kavanal.interviews;

import java.util.HashMap;
import java.util.Map;

// Paypal
// Given a string and a match string,  find if the string is in the input string
// The tokens can be out of order
public class SubStringInString {

    public static boolean isInString(String input, String match) {

        String[] inputs = input.split(" ");
        String[] matchWords = match.split(" ");
        Map<String, Long> countsMap = getCountsMap(matchWords);

        // Loop through the words to see if everything matches
        for (String currentWord : inputs) {
            if (countsMap.containsKey(currentWord)) {
                if (countsMap.get(currentWord) == 1) {
                    countsMap.remove(currentWord);
                } else {
                    countsMap.put(currentWord, countsMap.get(currentWord) - 1);
                }
            }

            if (countsMap.isEmpty())
                return true;
        }

        return false;
    }

    private static Map<String, Long> getCountsMap(String[] words) {
        Map<String, Long> countsMap = new HashMap<>();
        for (String currentWord : words) {
            if (countsMap.containsKey(currentWord)) {
                countsMap.put(currentWord, countsMap.get(currentWord) + 1);
            } else {
                countsMap.put(currentWord, 1L);
            }
        }

        return countsMap;
    }

    public static void main(String[] args) {
        System.out.println(isInString("Paypal sends money faster", "faster money"));
    }
}
