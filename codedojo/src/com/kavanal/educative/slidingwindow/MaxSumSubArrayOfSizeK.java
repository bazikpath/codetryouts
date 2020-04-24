package com.kavanal.educative.slidingwindow;

class MaxSumSubArrayOfSizeK {
    public static int findMaxSumSubArray(int k, int[] arr) {

        //Base and edge cases
        if (arr.length == 0) {
            return 0;
        } else if (k < 2) {
            return 0; //Her we just add the elements in the array
        }

        int rangeStart = 0, maxSum = 0;
        int rangeSum = 0;

        for (int i = rangeStart; i < arr.length; i++) {
            rangeSum += arr[i]; // Add the next element to the range sum
            // Check if range has been reached
            if (i >= k-1) {
                maxSum = Math.max(maxSum, rangeSum);
                rangeSum -= arr[rangeStart]; //Subtract the element out of range
                rangeStart++; //Slide the range ahead
            }
        }

        return maxSum;
    }

    public static void main(String[] args) {
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(3, new int[] { 2, 1, 5, 1, 3, 2 }));
        System.out.println("Maximum sum of a subarray of size K: "
                + MaxSumSubArrayOfSizeK.findMaxSumSubArray(2, new int[] { 2, 3, 4, 1, 5 }));
    }
}