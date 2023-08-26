package by.astashevich.leetcode.arrays;

//
//
//Given an integer array nums, rotate the array to the right by k steps, where k is non-negative.
//
//
//
//    Example 1:
//
//    Input: nums = [1,2,3,4,5,6,7], k = 3
//    Output: [5,6,7,1,2,3,4]
//    Explanation:
//    rotate 1 steps to the right: [7,1,2,3,4,5,6]
//    rotate 2 steps to the right: [6,7,1,2,3,4,5]
//    rotate 3 steps to the right: [5,6,7,1,2,3,4]
//    Example 2:
//
//    Input: nums = [-1,-100,3,99], k = 2
//    Output: [3,99,-1,-100]
//    Explanation:
//    rotate 1 steps to the right: [99,-1,-100,3]
//    rotate 2 steps to the right: [3,99,-1,-100]
//
//
//    Constraints:
//
//    1 <= nums.length <= 105
//    -231 <= nums[i] <= 231 - 1
//    0 <= k <= 105
//
//
//    Follow up:
//
//    Try to come up with as many solutions as you can. There are at least three different ways to solve this problem.
//    Could you do it in-place with O(1) extra space?

class RotateArray {

  public int[] rotate(int[] nums, int k) {
    int[] result = new int[nums.length];
    int realK = k < nums.length ? k : k % nums.length;
    for (int i = 0; i < nums.length; i++) {
      if (result.length > i + realK) {
        result[i + realK] = nums[i];
      } else {
        result[(i + realK) % result.length] = nums[i];
      }
    }
    return result;

  }
}

// requires less space (O(1))
//class Solution {
//  public void rotate(int[] nums, int k) {
//    int n = nums.length;
//    k %= n;
//    reverse(nums, n - k, n - 1);
//    reverse(nums, 0, n - 1);
//    reverse(nums, k, n - 1);
//  }
//
//  public void reverse(int nums[], int l, int r) {
//    for(int j = 0; j < (r - l + 1) / 2; j++) {
//      int temp = nums[l + j];
//      nums[l + j] = nums[r - j];
//      nums[r - j] = temp;
//    }
//  }
//}
