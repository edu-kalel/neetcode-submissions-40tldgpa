class TrieNode {
    TrieNode[] children;
    boolean end;

    public TrieNode(){
        children = new TrieNode[26];
        end = false;
    }
}

class PrefixTree {

    TrieNode root;

    public PrefixTree() {
        root = new TrieNode();
    }

    public void insert(String word) {
        TrieNode helper = root;
        for(char c : word.toCharArray()){
            if(helper.children[c-'a']==null){
                helper.children[c-'a'] = new TrieNode();
            }
            helper = helper.children[c-'a'];
        }
        helper.end = true;
    }

    public boolean search(String word) {
        TrieNode helper = root;
        for(char c : word.toCharArray()){
            if(helper.children[c-'a']==null){
                return false;
            }
            helper = helper.children[c-'a'];
        }
        return helper.end;
    }

    public boolean startsWith(String prefix) {
        TrieNode helper = root;
        for(char c : prefix.toCharArray()){
            if(helper.children[c-'a'] == null){
                return false;
            }
            helper = helper.children[c-'a'];
        }
        return true;
    }
}
