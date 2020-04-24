package com.kavanal.educative.twopointers;

class RemoveDuplicates {

    public static int remove(int[] arr) {

        //Base Case and edge cases
        if (arr.length < 2)
            return arr.length;

        // Pointer to the next non duplicate value
        int nextUnique = 1;
        // Loop through the array
        for (int i=0; i<arr.length; i++) {
            if (arr[nextUnique - 1] != arr[i]) {
                arr[nextUnique] = arr[i];
                nextUnique++;
            }
        }

        return nextUnique;
    }

    public static void main(String[] args) {
        int[] arr = new int[] { 2, 3, 3, 3, 6, 9, 9 };
        System.out.println(RemoveDuplicates.remove(arr));

        arr = new int[] { 2, 2, 2, 11 };
        System.out.println(RemoveDuplicates.remove(arr));
    }

    /**
     * Method for removing an element k in a sorted array
     * @param arr
     * @param key
     * @return size of the array
     */
    public static int remove(int[] arr, int key) {
        int nextElement = 0; // index of the next element which is not 'key'
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] != key) {
                arr[nextElement] = arr[i];
                nextElement++;
            }
        }

        return nextElement;
    }
}