class Solution {

    int iMax;
    int jMax;
    public boolean exist(char[][] board, String word) {
        // start at 0 , 0
        // int i = 0;
        // int j = 0;
        iMax = board.length;
        jMax = board[0].length;
        Set<String> visited ;
        // return recursive(board, word, 0, i, j, new HashSet<>());
        for(int i = 0; i<iMax ; i++){
            for(int j = 0 ; j<jMax ; j++){
                if(recursive(board, word, 0, i, j, new HashSet<>())){
                    return true;
                }
            }
        }
        return false;
        // add current to visited
        // check same row, column +1 and column -1
        // check same column, row +1 and row-1
        // BC if out of bounds, return false
        // BC if already visited, return false
        // BC if not the one needed, return false
        // CC ooo it is the one i need, ok then
            // add to visited
            // if not complete check contiguous
            // if word complete return true
    }

    boolean recursive(char[][] board, String word, int wordIndex, int i, int j, Set<String> visited){
        if(i<0 || j < 0 || !(i<iMax) || !(j<jMax)){
            return false;
        }
        String currentCoordinates = String.join(",", String.valueOf(i), String.valueOf(j));
        if(visited.contains(currentCoordinates)){
            return false;
        }
        char need = word.charAt(wordIndex);
        if(need!=board[i][j]){
            return false;
        }
        else{
            visited.add(currentCoordinates);
            wordIndex++;
            if(wordIndex>=word.length()){
                return true;
            }
            else{
                if( 
                    recursive(board, word, wordIndex, i, j+1, visited) ||
                    recursive(board, word, wordIndex, i, j-1, visited) ||
                    recursive(board, word, wordIndex, i+1, j, visited) ||
                    recursive(board, word, wordIndex, i-1, j, visited)
                ){
                    return true;
                }
                else{
                    visited.remove(currentCoordinates);
                    return false;
                }
            }
        }

    }
}
