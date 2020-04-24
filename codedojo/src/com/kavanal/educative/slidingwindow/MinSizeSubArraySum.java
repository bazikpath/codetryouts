package com.kavanal.educative.slidingwindow;

class MinSizeSubArraySum {
    public static int findMinSubArray(int S, int[] arr) {
        // Base and edge cases
        if (S == 0 || arr.length < 2)
            return 0;

        int rangeSum = 0, rangeLength = Integer.MAX_VALUE;
        int rangeStart = 0;

        // Loop through the array
        for (int i=0; i<arr.length; i++) {
            rangeSum += arr[i];
            while (rangeSum >= S) {
                // Keep reducing the range until we hit optimal range
                rangeLength = Math.min(rangeLength, i - rangeStart + 1);
                rangeSum -= arr[rangeStart];
                rangeStart++;
            }
        }

        return rangeLength == Integer.MAX_VALUE ? 0 : rangeLength;
    }

    public static void main(String[] args) {
        int result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 3, 2 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(7, new int[] { 2, 1, 5, 2, 8 });
        System.out.println("Smallest subarray length: " + result);
        result = MinSizeSubArraySum.findMinSubArray(8, new int[] { 3, 4, 1, 1, 6 });
        System.out.println("Smallest subarray length: " + result);
    }
}