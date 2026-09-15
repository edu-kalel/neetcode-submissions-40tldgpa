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
    public boolean isValidBST(TreeNode root) {
        // left < root
        // right > root
        return isValid(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean isValid(TreeNode root, int lower, int upper){
        if(root == null){
            return true;
        }
        if(!(root.val>lower && root.val < upper)){
            return false;
        }
        else{
            return true && isValid(root.left, lower, root.val) && isValid(root.right, root.val, upper);
        }
    }
}
