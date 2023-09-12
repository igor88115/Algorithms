package by.astashevich.leetcode.sortingAndSearching;

/*
Given an array nums with n objects colored red, white, or blue, sort them in-place so that objects of the same color are adjacent, with the colors in the order red, white, and blue.

We will use the integers 0, 1, and 2 to represent the color red, white, and blue, respectively.

You must solve this problem without using the library's sort function.



Example 1:

Input: nums = [2,0,2,1,1,0]
Output: [0,0,1,1,2,2]
Example 2:

Input: nums = [2,0,1]
Output: [0,1,2]


Constraints:

n == nums.length
1 <= n <= 300
nums[i] is either 0, 1, or 2.


Follow up: Could you come up with a one-pass algorithm using only constant extra space?

*/
public class SortingColors {

  public void sortColors(int[] nums) {
    int red = 0;
    int white = 0;
    int blue = 0;
    for (int num : nums) {
      switch (num) {
        case 0 -> red++;
        case 1 -> white++;
        case 2 -> blue++;
      }
    }
    int i = 0;
    while (red != 0) {
      nums[i++] = 0;
      red--;
    }
    while (white != 0) {
      nums[i++] = 1;
      white--;
    }
    while (blue != 0) {
      nums[i++] = 2;
      blue--;
    }
  }

//  slow bubble sort solution
  public void sortColorsWithBubbleSort(int[] nums) {
    int i = 0;
    int j = 1;
    int offset = 0;

    while (j < nums.length - offset) {
      if (nums[i] > nums[j]) {
        int temp = nums[i];
        nums[i] = nums[j];
        nums[j] = temp;
      }
      offset++;
    }
  }

}
