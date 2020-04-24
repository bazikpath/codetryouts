package com.kavanal.leetcode;

public class RemoveElement {
    public static int removeElement(int[] nums, int val) {

        //Base Case
        if (nums.length == 0) {
            return 0;
        } else if (nums.length == 1) {
            return (nums[0] == val ?  0 : 1);
        }

        // Define the two pointers
        int frontPtr = 0;
        int endPtr = movePointer(nums.length -1, nums, val);
        int temp = 0;

        //Traverse the array, replacing the values until array ends or we meet the second pointer
        while (frontPtr <= endPtr) {
            if (nums[frontPtr] == val) {
                temp = nums[endPtr];
                nums[endPtr] = val;
                nums[frontPtr] = temp;
                endPtr = movePointer(endPtr - 1, nums, val);
            }
            frontPtr++;
        }

        return frontPtr;
    }

    // Move pointer until a position with a value not val is reached
    private static int movePointer(int pointer, int[]nums, int val) {
        while (nums[pointer] == val) {
            pointer--;
            if (pointer <= 0)
                break;
        }

        return pointer;
    }

    public static void main (String[] args) {
        final  int[] testArray = {3,2,2,3};
        System.out.println(removeElement(testArray, 3));
    }
}
