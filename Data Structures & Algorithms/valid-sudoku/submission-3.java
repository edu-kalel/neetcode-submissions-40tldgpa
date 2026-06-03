class Solution {
    public boolean isValidSudoku(char[][] board) {
        // create 3 hmaps
            // rows
            // columns
            // square
        // iterate through board
        // if seen in any, return false
        // else continue and return true if ends ok
        Map<Integer, Set<Character>> rows = new HashMap<>();
        Map<Integer, Set<Character>> columns = new HashMap<>();
        Map<String, Set<Character>> squares = new HashMap<>();

        for(int i = 0 ; i<9 ; i++){
            for(int j = 0 ; j<9 ; j++){
                if(board[i][j]=='.'){
                    continue;
                }

                String squareKey = (i/3) + "," + (j/3);
                if(
                    rows.computeIfAbsent(i, k -> new HashSet<>()).contains(board[i][j]) ||
                    columns.computeIfAbsent(j, k -> new HashSet<>()).contains(board[i][j]) ||
                    squares.computeIfAbsent(squareKey, k -> new HashSet<>()).contains(board[i][j])
                ){
                    return false;
                }
                rows.get(i).add(board[i][j]);
                columns.get(j).add(board[i][j]);
                squares.get(squareKey).add(board[i][j]);
            }
        }
        return true;
    }
}
