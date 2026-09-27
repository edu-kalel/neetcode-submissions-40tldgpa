class TrieNode{
    TrieNode[] children;
    boolean end;

    public TrieNode(){
        children = new TrieNode[26];
        end = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        TrieNode helper = root;
        for(char c : word.toCharArray()){
            if(helper.children[c-'a'] == null){
                helper.children[c-'a'] = new TrieNode();
            }
            helper = helper.children[c-'a'];
        }
        helper.end = true;
    }

    public boolean search(String word) {
        // dfs
        return dfs(word, 0, root);
    }

    boolean dfs(String word, int index, TrieNode node){
        // no . -> iterative
        // .    -> explore children (bfs)
        TrieNode helper = node;
        for(int i = index ; i<word.length() ; i++){
            if(word.charAt(i) == '.'){
                // go dfs
                for(TrieNode helper2 : helper.children){
                    if(helper2!= null && dfs(word, i+1, helper2)){
                        return true;
                    }
                }
                return false;
            }
            else{
                if(helper.children[word.charAt(i) - 'a']==null){
                    return false;
                }
                helper = helper.children[word.charAt(i)-'a'];
            }
        }
        return helper.end;

    }
}
