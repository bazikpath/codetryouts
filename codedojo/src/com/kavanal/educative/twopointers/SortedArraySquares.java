package com.kavanal.educative.twopointers;

class SortedArraySquares {

    public static int[] makeSquares(int[] arr) {
        int n = arr.length;

        int[] squares = new int[n];
        // Base and edge case
        if (n == 0 ) {
            return arr;
        } else  if (n == 1) {
            return new int[] {arr[0] * arr[0]};
        }

        int highestSqrIndex = n-1;
        int left = 0, right = n-1;
         while (left <= right) {
             int leftSquare = arr[left] * arr[left];
             int rightSquare = arr[right] * arr[right];
             if (leftSquare > rightSquare) {
                squares[highestSqrIndex--] = leftSquare;
                left++;
             } else {
                 squares[highestSqrIndex--] = rightSquare;
                 right--;
             }
         }

        return squares;
    }

    public static void main(String[] args) {

        int[] result = SortedArraySquares.makeSquares(new int[] { -2, -1, 0, 2, 3 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();

        result = SortedArraySquares.makeSquares(new int[] { -3, -1, 0, 1, 2 });
        for (int num : result)
            System.out.print(num + " ");
        System.out.println();
    }
}