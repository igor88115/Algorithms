package by.astashevich.leetcode.design;


//https://leetcode.com/explore/interview/card/top-interview-questions-easy/98/design/670/
//Given an integer array nums, design an algorithm to randomly shuffle the array. All permutations of the array should be equally likely as a result of the shuffling.
//
//    Implement the Solution class:
//
//    Solution(int[] nums) Initializes the object with the integer array nums.
//    int[] reset() Resets the array to its original configuration and returns it.
//    int[] shuffle() Returns a random shuffling of the array.
//
//
//    Example 1:
//
//    Input
//    ["Solution", "shuffle", "reset", "shuffle"]
//    [[[1, 2, 3]], [], [], []]
//    Output
//    [null, [3, 1, 2], [1, 2, 3], [1, 3, 2]]
//
//    Explanation
//    Solution solution = new Solution([1, 2, 3]);
//    solution.shuffle();    // Shuffle the array [1,2,3] and return its result.
//    // Any permutation of [1,2,3] must be equally likely to be returned.
//    // Example: return [3, 1, 2]
//    solution.reset();      // Resets the array back to its original configuration [1,2,3]. Return [1, 2, 3]
//    solution.shuffle();    // Returns the random shuffling of array [1,2,3]. Example: return [1, 3, 2]
//
//
//
//    Constraints:
//
//    1 <= nums.length <= 50
//    -106 <= nums[i] <= 106
//    All the elements of nums are unique.
//    At most 104 calls in total will be made to reset and shuffle.


import java.time.LocalDate;
import java.util.Random;

public class ShuffleAnArray {

  private final int[] nums;
  private final Random random;

  public ShuffleAnArray(int[] nums) {
    this.nums = nums;
    random = new Random();
  }

  public int[] reset() {
    return nums;
  }

  public int[] shuffle() {
    int[] copy = nums.clone();
    for (int i = 0; i < copy.length; i++) {
      int randomNumber = random.nextInt(i,i + 1);
      int tempValue = copy[i];
      copy[i] = copy[randomNumber];
      copy[randomNumber] = tempValue;
    }
    return copy;
  }
}

/**
 * Your Solution object will be instantiated and called as such:
 * Solution obj = new Solution(nums);
 * int[] param_1 = obj.reset();
 * int[] param_2 = obj.shuffle();
 */
