// need object
class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}

class PrefixTree {
    
    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        // ok need a helper to traverse
        TrieNode helper = root;
        // loop
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(helper.children[index]==null){
                helper.children[index] = new TrieNode();
            }
            helper = helper.children[index];
        }
        helper.isEnd = true;

    }

    public boolean search(String word) {
        // pretty much the same
        TrieNode helper = root;
        for(char c : word.toCharArray()){
            int index = c-'a';
            if(helper.children[index]==null){
                return false;
            }
            helper = helper.children[index];
        }
        return helper.isEnd;
    }

    public boolean startsWith(String prefix) {
        TrieNode helper = root;
        for(char c : prefix.toCharArray()){
            int index = c-'a';
            if(helper.children[index]==null){
                return false;
            }
            helper = helper.children[index];
        }
        return true;
    }
}
