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
    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q) {
        // traverse tree
        // if p & q > root.val
            // go right
        // else go left
        // if root.val == p || q
            // return root;
        while(true){
            if(root.val == p.val || root.val == q.val){
                return root;
            }
            if(root.val>p.val && root.val>q.val){
                root = root.left;
            }
            else if(root.val<p.val && root.val<q.val){
                root = root.right;
            }
            else{
                return root;
            }
        }
    }
}
