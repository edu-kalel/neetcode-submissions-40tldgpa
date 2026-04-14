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

public class Codec {

    // Encodes a tree to a single string.
    public String serialize(TreeNode root) {
        List<String> list = new ArrayList<>();
        dfsSerialize(root, list);
        return String.join("," , list);
    }

    void dfsSerialize(TreeNode node, List<String> list){
        if(node == null){
            list.add("N");
            return;
        }
        list.add(String.valueOf(node.val));
        dfsSerialize(node.left, list);
        dfsSerialize(node.right, list);
    }

    // Decodes your encoded data to tree.
    public TreeNode deserialize(String data) {
        String[] vals = data.split(",");
        int[] i = {0};
        return dfsDe(vals, i);
    }

    TreeNode dfsDe(String[] vals, int[] i){
        if(vals[i[0]].equals("N")){
            i[0]++;
            return null;
        }
        TreeNode node = new TreeNode(Integer.parseInt(vals[i[0]]));
        i[0]++;
        node.left = dfsDe(vals, i);
        node.right = dfsDe(vals, i);
        return node;
    }
}
