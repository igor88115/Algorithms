package by.astashevich.leetcode.binary_search;


/*
https://leetcode.com/problems/binary-search/

Given an array of integers nums which is sorted in ascending order, and an integer target, write a function to search target in nums. If target exists, then return its index. Otherwise, return -1.

You must write an algorithm with O(log n) runtime complexity.



Example 1:

Input: nums = [-1,0,3,5,9,12], target = 9
Output: 4
Explanation: 9 exists in nums and its index is 4
Example 2:

Input: nums = [-1,0,3,5,9,12], target = 2
Output: -1
Explanation: 2 does not exist in nums so return -1


Constraints:

1 <= nums.length <= 104
-104 < nums[i], target < 104
All the integers in nums are unique.
nums is sorted in ascending order.
 */
public class BinarySearch {

  /*
  my recursive solution
  space - O(log n).
  time - O(log n)
 */
  public int search(int[] nums, int target) {
    return search(nums, 0, nums.length -1, target);
  }

  private int search(int[] nums, int startIndex, int endIndex, int target){
    int middleIndex = (endIndex + startIndex) / 2;
    if(nums[middleIndex] == target){
      return middleIndex;
    } else if(startIndex > endIndex){
      return -1;
    } else if (target > nums[middleIndex]){
      return search(nums, middleIndex + 1, endIndex, target);
    } else {
      return search(nums, startIndex, middleIndex -1, target);
    }
  }

  /*
  using iteration (uses a little bit less memory)

  Time complexity: O(logn)
  - Since binary search reduces the search space by half at each step,
  the maximum number of iterations required to find the target is log base 2 of n, where n is the size of the array.
  Therefore, the time complexity of binary search is O(logn)O(log n)O(logn).

  Space complexity: O(1) - Binary search only uses a constant amount of additional space for the two pointers and the middle index variable,
  so the space complexity is O(1).
   */
  public int nonRecursive(int[] nums, int target) {

    int startIndex = 0;
    int endIndex = nums.length - 1;

    while(startIndex <= endIndex){
      int middleIndex = (endIndex + startIndex) / 2;
      if(nums[middleIndex] == target) {
        return middleIndex;
      } else if (target > nums[middleIndex]){
        startIndex = middleIndex + 1;
      } else {
        endIndex = middleIndex -1;
      }
    }
    return -1;
  }

}
