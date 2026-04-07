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
    public boolean isSubtree(TreeNode root, TreeNode subRoot) {
        if(subRoot==null){
            return true;
        }
        if(root==null && subRoot!=null){
            return false;
        }
        
        return isSame(root, subRoot) || isSubtree(root.left, subRoot) || isSubtree(root.right, subRoot);

    }

    public boolean isSame(TreeNode p , TreeNode q){
        if(p==null && q==null){
            return true;
        }

        if(p!=null && q!=null && p.val==q.val){
            return true && isSame(p.right, q.right) && isSame(p.left, q.left);
        }

        else{
            return false;
        }
    }
}
