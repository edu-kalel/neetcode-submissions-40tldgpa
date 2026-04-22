class TrieNode{
    TrieNode[] children;
    int wordIndex;
    int refs;

    public TrieNode(){
        children = new TrieNode[26];
        wordIndex = -1;
        refs = 0;
    }
}

class Solution {

    TrieNode root;
    List<String> result;
    int iMax;
    int jMax;

    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        buildTree(words);
        iMax = board.length;
        jMax = board[0].length;
        for(int i = 0 ; i<iMax ; i++){
            for(int j = 0; j<jMax ; j++){
                dfs(board, i, j, root, words);
            }
        }
        return result;
    }

    void dfs(char[][] board, int i, int j, TrieNode node, String[] words){
        if(!(i<iMax) || !(j<jMax) || i<0 || j<0){
            return;
        }
        if(board[i][j] == '*'){
            return;
        }
        int charboardint = board[i][j] -'a';
        TrieNode helper = node;
        if(helper.children[charboardint]==null){
            return;
        }
        helper = helper.children[charboardint];
        char temp = board[i][j];
        board[i][j] = '*';
        if(helper.wordIndex!=-1){
            result.add(words[helper.wordIndex]);
            helper.wordIndex = -1;
            helper.refs--;
            if(helper.refs==0){
                node.children[charboardint]=null;
                board[i][j] = temp;
                return;
            }
        }
        dfs(board, i, j+1, helper, words);
        dfs(board, i, j-1, helper, words);
        dfs(board, i+1, j, helper, words);
        dfs(board, i-1, j, helper, words);

        board[i][j] = temp;

    }

    void buildTree(String[] words){
        root = new TrieNode();
        TrieNode helper;
        for(int i = 0; i<words.length ; i++){
            String word = words[i];
            helper = root;
            for(char c : word.toCharArray()){
                int index = c-'a';
                if(helper.children[index]==null){
                    helper.children[index] = new TrieNode();
                }
                helper = helper.children[index];
                helper.refs++;
            }
            helper.wordIndex = i;
        }
    }
}

