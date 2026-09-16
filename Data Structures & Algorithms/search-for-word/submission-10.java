class Solution {
    int rowmax;
    int columnmax;
    boolean[][] visited;
    public boolean exist(char[][] board, String word) {
        rowmax = board.length;
        columnmax = board[0].length;
        visited = new boolean[rowmax][columnmax];
        for(int row = 0 ; row<rowmax; row++){
            for(int column = 0 ; column<columnmax ; column++){
                if(dfs(board, word, 0, row, column)){
                    return true;
                }
            }
        }
        return false;
    }

    boolean dfs(char[][] board, String word, int wordindex, int row, int column){
        if(
            row<0 ||
            column < 0 ||
            !(row < rowmax) ||
            !(column < columnmax)
        ){
            return false;
        }
        if(visited[row][column]==true){
            return false;
        }
        if(board[row][column] == word.charAt(wordindex)){
            visited[row][column] = true;
            wordindex++;
            if(wordindex==word.length()){
                return true;
            }
            if(
                dfs(board, word, wordindex, row+1, column) ||
                dfs(board, word, wordindex, row-1, column) ||
                dfs(board, word, wordindex, row, column+1) ||
                dfs(board, word, wordindex, row, column-1)
            ){
                return true;
            }
            else{
                visited[row][column] = false;
            }
        }
        // else{
            return false;
        // }

    }
}
