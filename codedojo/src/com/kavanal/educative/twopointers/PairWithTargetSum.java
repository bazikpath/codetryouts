package com.kavanal.educative.twopointers;

class PairWithTargetSum {

    public static int[] search(int[] arr, int targetSum) {
        // Base and edge cases
        if (arr.length < 2 || targetSum < arr[0])
            return new int[] {-1, -1};

        // Initialise pointers at both ends
        int minPointer = 0, maxPointer = arr.length - 1;
        // Loop through the array and find sum
        while (minPointer < maxPointer ) {
            int currentSum = arr[maxPointer] + arr[minPointer];
            if (currentSum == targetSum) {
                return new int[] { minPointer, maxPointer };

            } else if (targetSum > currentSum) {
                minPointer++;
            } else {
                maxPointer--;
            }
        }

        return new int[] { -1, -1 };
    }

    public static void main(String[] args) {
        int[] result = PairWithTargetSum.search(new int[] { 1, 2, 3, 4, 6 }, 6);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
        result = PairWithTargetSum.search(new int[] { 2, 5, 9, 11 }, 11);
        System.out.println("Pair with target sum: [" + result[0] + ", " + result[1] + "]");
    }
}