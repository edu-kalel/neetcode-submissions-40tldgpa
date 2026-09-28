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
        hmap = new HashMap<>();
        return copy(node);
    }

    Node copy(Node node){
        // base case -> null
        if(node==null){
            return null;
        }
        // already exists on map
        if(hmap.containsKey(node)){
            return hmap.get(node);
        }
        // copy & save
        Node copy = new Node(node.val);
        hmap.put(node, copy);
        for(Node neighbor : node.neighbors){
            copy.neighbors.add(copy(neighbor));
        }
        return copy;
    }
}