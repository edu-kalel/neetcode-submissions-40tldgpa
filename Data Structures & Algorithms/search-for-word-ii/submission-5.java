class TrieNode{
    TrieNode[] children;
    int wordsI;
    int refs;

    public TrieNode(){
        children = new TrieNode[26];
        wordsI = -1;
        refs = 0;
    }
}

class Solution {
    List<String> result;
    int rowMax;
    int columnMax;
    TrieNode root;

    public List<String> findWords(char[][] board, String[] words) {
        result = new ArrayList<>();
        rowMax = board.length;
        columnMax = board[0].length;
        root = new TrieNode();
        buildTree(words);

        for(int row = 0 ; row<rowMax ; row++){
            for(int column = 0 ; column<columnMax ; column++){
                dfs(board, row, column, words, root);
            }
        }

        return result;
    }

    int dfs(char[][] board, int row, int column, String[] words, TrieNode root){
        // base cases
        // out of bounds
        if( row<0 || column<0 || row>=rowMax || column>=columnMax
            || board[row][column]=='#'){
            return 0;
        }


        int charint = board[row][column] - 'a';
        TrieNode helper = root.children[charint];

        if(helper!=null){

            // use it
            char temp = board[row][column];
            board[row][column] = '#';
            // found words that go through this node
            int found = 0;
            // last one??
            if(helper.wordsI!=-1){
                // word found
                // add to result set
                result.add(words[helper.wordsI]);
                helper.wordsI= -1;
                found++;
            }

            found += dfs(board, row+1, column, words, helper);
            found += dfs(board, row-1, column, words, helper);
            found += dfs(board, row, column+1, words, helper);
            found += dfs(board, row, column-1, words, helper);

            // backtrack??
            board[row][column] = temp;
            helper.refs -= found;
            if(helper.refs==0){
                root.children[charint]=null;
            }
            return found;

        }

        return 0;

    }

    void buildTree(String[] words){
        for(int i = 0 ; i < words.length ; i++){
            TrieNode helper = root;
            String word = words[i];
            for(char c : word.toCharArray()){
                if(helper.children[c-'a']==null){
                    helper.children[c-'a'] = new TrieNode();
                }
                helper = helper.children[c-'a'];
                helper.refs++;
            }
            helper.wordsI = i;
        }
    }
}
