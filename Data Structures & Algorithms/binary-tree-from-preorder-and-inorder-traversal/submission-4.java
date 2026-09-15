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
    Map<Integer, Integer> inordermap = new HashMap<>();
    int preindex = 0;
    public TreeNode buildTree(int[] preorder, int[] inorder) {
        for(int i = 0 ; i<inorder.length ; i++){
            inordermap.put(inorder[i], i);
        }

        return dfs(preorder, preindex, inorder.length-1);
    }

    TreeNode dfs(int[] preorder, int l, int r){
        if(l>r){
            return null;
        }
        TreeNode root = new TreeNode(preorder[preindex]);
        int mid = inordermap.get(preorder[preindex]);
        preindex++;
        root.left = dfs(preorder, l, mid-1);
        root.right = dfs(preorder, mid+1, r);

        return root;
    }
}
