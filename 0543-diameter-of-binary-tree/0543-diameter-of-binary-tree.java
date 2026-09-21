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
    public int diameterOfBinaryTree(TreeNode root) {
        if(root == null) return 0;

        int leftD = diameterOfBinaryTree(root.left);
        int rightD = diameterOfBinaryTree(root.right);

        int leftH = heightTree(root.left);
        int rightH = heightTree(root.right);

        int selfD = leftH + rightH ;
        

        return Math.max(selfD, Math.max(leftD, rightD));
    }

    public int heightTree(TreeNode root){
            if(root == null){
                return 0;
            }
            int leftH = heightTree(root.left);
            int rightH = heightTree(root.right);

            int height = Math.max(leftH, rightH) + 1;

            return height;
        }
}