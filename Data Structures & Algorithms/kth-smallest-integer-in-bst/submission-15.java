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

    int result = 0;
    int count = 0;

    public int kthSmallest(TreeNode root, int k) {
        count = k;
        inOrder(root);
        return result;
    }

    public void inOrder(TreeNode node){
        if(node==null){
            return;
        }
        inOrder(node.left);
        count--;
        if(count==0){
            result=node.val;
            System.out.println(result);
            return;
        }
        inOrder(node.right);

    }
}
