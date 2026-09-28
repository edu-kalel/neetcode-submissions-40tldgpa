class Solution {
    boolean[][] used;
    int rowMax;
    int columnMax;
    public boolean exist(char[][] board, String word) {
        rowMax = board.length;
        columnMax = board[0].length;
        used = new boolean[rowMax][columnMax];

        for(int row = 0 ; row<rowMax ; row++){
            for(int column = 0 ; column<columnMax ; column++){
                if(dfs(board, row, column, 0, word)){
                    return true;
                }
            }
        }

        return false;
    }

    boolean dfs(char[][] board, int row, int column, int index, String word){
        if( row<0 || column < 0 || row>=rowMax || column>=columnMax
            ||  used[row][column]){
            return false;
        }
        if(board[row][column]==word.charAt(index)){
            // eow?
            index++;
            if(word.length()==index){
                return true;
            }
            // not eow
            // use it
            used[row][column] = true;
            // check for next
            if(
                dfs(board, row+1, column, index, word) ||
                dfs(board, row-1, column, index, word) ||
                dfs(board, row, column+1, index, word) ||
                dfs(board, row, column-1, index, word)
            ){
                return true;
            }
            else{
                // backtrack here?
                used[row][column]=false;
                return false;
            }
        }
        else{
            return false;
        }
    }
}
