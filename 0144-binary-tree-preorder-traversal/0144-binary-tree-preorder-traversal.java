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
    public List<Integer> preorderTraversal(TreeNode root) {
        List<Integer>List = new ArrayList<>();
        preorder(root, List);
        return List;
    }
    private void preorder(TreeNode root, List<Integer>List){
        if(root == null){
            return;
        }
        List.add(root.val);
        preorder(root.left,List);
        preorder(root.right,List);
    }
}