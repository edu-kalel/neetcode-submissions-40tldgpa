/*
Definition for a Node.
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {

    Map<Node, Node> hmap;

    public Node cloneGraph(Node node) {
        if(node == null){
            return null;
        }
        hmap = new HashMap<>();
        Node result = dfs(node);
        // return hmap.get(node);
        return result;
    }

    Node dfs(Node node){
        if(hmap.containsKey(node)){
            return hmap.get(node);
        }
        Node helper = new Node(node.val);
        hmap.put(node, helper);
        for(int i = 0 ; i<node.neighbors.size() ; i++){
            helper.neighbors.add(dfs(node.neighbors.get(i)));
        }
        return helper;
    }
}