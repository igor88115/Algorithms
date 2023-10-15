package by.astashevich.leetcode.arrays;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
Given an m x n integer matrix matrix, if an element is 0, set its entire row and column to 0's.

You must do it in place.



Example 1:


Input: matrix = [[1,1,1],[1,0,1],[1,1,1]]
Output: [[1,0,1],[0,0,0],[1,0,1]]
Example 2:


Input: matrix = [[0,1,2,0],[3,4,5,2],[1,3,1,5]]
Output: [[0,0,0,0],[0,4,5,0],[0,3,1,0]]


Constraints:

m == matrix.length
n == matrix[0].length
1 <= m, n <= 200
-231 <= matrix[i][j] <= 231 - 1


Follow up:

A straightforward solution using O(mn) space is probably a bad idea.
A simple improvement uses O(m + n) space, but still not the best solution.
Could you devise a constant space solution?
 */
public class SetMatrixZeros {


  //  O(n+m) - space compexity
//  O(N*M)  - time complexity
  public void setZeroes(int[][] matrix) {
    int matrixRows = matrix.length;
    int matrixColumns = matrix[0].length;

    Set<Integer> rows = new HashSet<>();
    Set<Integer> columns = new HashSet<>();

    for (int i = 0; i < matrixRows; i++) {
      for (int j = 0; j < matrixColumns; j++) {
        if (matrix[i][j] == 0) {
          rows.add(i);
          columns.add(j);
        }
      }
    }

    for (int i : rows) {
      for (int j = 0; j < matrixColumns; j++) {
        matrix[i][j] = 0;
      }
    }

    for (int i : columns) {
      for (int j = 0; j < matrixRows; j++) {
        matrix[j][i] = 0;
      }
    }
  }


  //  O(1) - space compexity
//  O(N*M)  - time complexity
  public void setZeroesWithLessSpaceComplexity(int[][] matrix) {

    int rows = matrix.length;
    int columns = matrix[0].length;

    boolean isFirstRowEmpty = false;
    for (int i = 0; i < rows; i++) {
      for (int j = 0; j < columns; j++) {
        if (matrix[i][j] == 0) {
//            is required because if the first row is going to be marked with zeros, then next it will be impossible to fill first row with zeros correctly
          if(i > 0) {
            matrix[i][0] = 0;
            matrix[0][j] = 0;
          } else {
            isFirstRowEmpty = true;
          }
        }
      }
    }

    for (int i = 1; i < rows; i++) {
      if (matrix[i][0] == 0) {
        Arrays.fill(matrix[i], 0);
      }
    }

    for (int i = 0; i < columns; i++) {
      if (matrix[0][i] == 0) {
        for (int j = 0; j < rows; j++) {
          matrix[j][i] = 0;
        }
      }
    }

    if(isFirstRowEmpty){
      Arrays.fill(matrix[0], 0);
    }

  }

}
