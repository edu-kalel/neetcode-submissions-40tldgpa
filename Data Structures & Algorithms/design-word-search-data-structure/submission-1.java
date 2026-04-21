// need object
class TrieNode{
    TrieNode[] children;
    boolean isEnd;

    public TrieNode(){
        children = new TrieNode[26];
        isEnd = false;
    }
}

class WordDictionary {

    TrieNode root;

    public WordDictionary() {
        root = new TrieNode();
    }

    public void addWord(String word) {
        // need helper
        TrieNode helper = root;
        // traverse
        for(char c : word.toCharArray()){
            int index = c - 'a';
            if(helper.children[index]==null){
                helper.children[index] = new TrieNode();
            }
            helper = helper.children[index];
        }
        helper.isEnd=true;
    }

    public boolean search(String word) {
        // dfs when char is '.'
        return dfs(word, root, 0);
    }

    boolean dfs(String word, TrieNode node, int indexWord){
        // cases
        //  . -> iterative
        //  no . -> recursion
        TrieNode helper = node;
        for(int i = indexWord; i<word.length(); i++){
            
            if(word.charAt(i) == '.'){
                // check all children paths
                for(TrieNode child : helper.children){
                    if(child!=null && dfs(word, child, i+1)){
                        return true;
                    }
                }
                return false;
            }
            else{
                int charint = word.charAt(i) - 'a';
                if(helper.children[charint]==null){
                    return false;
                }
                else{
                    helper = helper.children[charint];
                }
            }
        }
        return helper.isEnd;

    }
}
