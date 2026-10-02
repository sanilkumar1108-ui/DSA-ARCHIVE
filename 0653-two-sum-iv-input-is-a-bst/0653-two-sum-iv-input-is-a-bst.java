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
    public boolean findTarget(TreeNode root, int k) {
        ArrayList<Integer> a = new ArrayList<>();
        inorder(root, a);

        int st = 0, end = a.size() - 1;
        while(st<end){
            if(a.get(st) + a.get(end) == k) return true;
            if(a.get(st) + a.get(end) < k){
                st++;
            }else{
                end--;
            }
        }
        return false;
    }
    public void inorder(TreeNode root, ArrayList<Integer> a){
        if(root == null){
            return;
        }

        inorder(root.left, a);
        a.add(root.val);
        inorder(root.right, a);
    }
}