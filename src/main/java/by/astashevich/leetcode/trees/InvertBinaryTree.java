package by.astashevich.leetcode.trees;

/*
https://leetcode.com/problems/invert-binary-tree/
Given the root of a binary tree, invert the tree, and return its root.



Example 1:


Input: root = [4,2,7,1,3,6,9]
Output: [4,7,2,9,6,3,1]
Example 2:


Input: root = [2,1,3]
Output: [2,3,1]
Example 3:

Input: root = []
Output: []


Constraints:

The number of nodes in the tree is in the range [0, 100].
-100 <= Node.val <= 100
 */

import java.util.LinkedList;

// Time Complexity : O(n)
// Space Complexity : O(n)
//The space complexity is determined by the height of the tree due to the recursive calls.
// In the worst case, where the tree is unbalanced and has a height 'h' equal to the number of nodes, the space complexity becomes O(h).
public class InvertBinaryTree {
  public TreeNode invertTree(TreeNode root) {
    if (root != null) {
      TreeNode tempNode = root.right;
      root.right = root.left;
      root.left = tempNode;
      invertTree(root.left);
      invertTree(root.right);
    }
    return root;
  }

  // Time Complexity : O(n)
  // Space Complexity : O(n)
  public TreeNode invertTreeIterative(TreeNode root) {
    LinkedList<TreeNode> q = new LinkedList<>();
    // Base case: if the tree is empty...
    if(root != null){
      // Push the root node...
      q.add(root);
    }
    // Loop till queue is empty...
    while(!q.isEmpty()){
      // Dequeue front node...
      TreeNode temp = q.poll();
      // Enqueue left child of the popped node...
      if(temp.left != null)
        q.add(temp.left);
      // Enqueue right child of the popped node
      if(temp.right != null)
        q.add(temp.right);
      // Swapping process...
      TreeNode curr = temp.left;
      temp.left = temp.right;
      temp.right = curr;
    }
    return root;    // Return the root...
  }
}


class TreeNode {
  int val;
  TreeNode left;
  TreeNode right;

  TreeNode() {
  }

  TreeNode(int val) {
    this.val = val;
  }

  TreeNode(int val, TreeNode left, TreeNode right) {
    this.val = val;
    this.left = left;
    this.right = right;
  }

}

