package by.astashevich.leetcode.dynamicPrograming;


//You are climbing a staircase. It takes n steps to reach the top.
//
//    Each time you can either climb 1 or 2 steps. In how many distinct ways can you climb to the top?
//
//
//
//    Example 1:
//
//    Input: n = 2
//    Output: 2
//    Explanation: There are two ways to climb to the top.
//    1. 1 step + 1 step
//    2. 2 steps
//    Example 2:
//
//    Input: n = 3
//    Output: 3
//    Explanation: There are three ways to climb to the top.
//    1. 1 step + 1 step + 1 step
//    2. 1 step + 2 steps
//    3. 2 steps + 1 step
//
//
//    Constraints:
//
//    1 <= n <= 45

import java.util.HashMap;
import java.util.Map;


// requires a lot of memory for cache
public class ClimbingStairs {

  public Map<Integer, Integer> cache = new HashMap();

  public int climbStairs(int n) {

    if (n == 1) {
      return 1;
    } else if (n == 2) {
      return 2;
    } else {
      Integer fromFirst = cache.get(n - 1);
      Integer fromTheSecond = cache.get(n - 2);
      if (fromFirst == null) {
        fromFirst = climbStairs(n - 1);
        cache.put(n - 1, fromFirst);
      }
      if (fromTheSecond == null) {
        fromTheSecond = climbStairs(n - 2);
        cache.put(n - 1, fromTheSecond);
      }
      return fromFirst + fromTheSecond;
    }

  }

  //  requires less memory because uses just 2 required values that are necessary for calculating the next one
  public int climbStairs2(int n) {

    if (n == 1) {
      return 1;
    }

    int firstRoute = 1;
    int secondRoute = 2;

    for (int i = 3; i <= n; i++) {
      int tempValue = secondRoute;
      secondRoute = firstRoute + secondRoute;
      firstRoute = tempValue;
    }
    return secondRoute;

  }


}
