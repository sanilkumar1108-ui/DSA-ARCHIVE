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
    public int countNodes(TreeNode root) {
        if(root == null){
            return 0;
        }
        int leftD = depth(root.left);
        int rightD = depth(root.right);

        if(leftD == rightD){
            return (int)Math.pow(2, leftD) + countNodes(root.right);
        }else{
            return (int)Math.pow(2, rightD) + countNodes(root.left);
        }
        
    }
    private int depth(TreeNode root){
        int d = 0;
        while(root != null){
            d++;
            root = root.left;
        }
        return d;
    }
}