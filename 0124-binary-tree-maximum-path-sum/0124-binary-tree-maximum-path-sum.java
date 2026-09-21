/**
 * Definition for a binary tree node.
 * public class TreeNode {
 *     int val;
 *     TreeNode left;
 *     TreeNode right;
 *     TreeNode() {}
 *     TreeNode(int val) { this.val = val; }
 *     TreeNode(int val, TreeNode left, TreeNode right) {
 *         this.val = val;
 *         this.left = left;
 *         this.right = right;
 *     }
 * }
 */
class Solution {
    private int maxSum = Integer.MIN_VALUE;
    public int maxPathSum(TreeNode root) {
        maxSum = Integer.MIN_VALUE;
        pathSum(root);
        return maxSum;
    }
    private int pathSum(TreeNode root){
        if(root == null){
            return 0;
        }

        int leftH = Math.max(0, pathSum(root.left));
        int rightH = Math.max(0, pathSum(root.right));
        
        maxSum = Math.max(maxSum, leftH + rightH + root.val);
        return root.val + Math.max(leftH , rightH);
    }
}