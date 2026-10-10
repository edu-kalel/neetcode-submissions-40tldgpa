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

        return dfs(root, Integer.MIN_VALUE, Integer.MAX_VALUE);
    }

    boolean dfs(TreeNode node, int floor, int ceiling){
        if(node == null){
            return true;
        }
        if(node.val > floor && node.val < ceiling){
            return dfs(node.left, floor, node.val) && dfs(node.right, node.val, ceiling);
        }
        else
            return false;
    }
}
