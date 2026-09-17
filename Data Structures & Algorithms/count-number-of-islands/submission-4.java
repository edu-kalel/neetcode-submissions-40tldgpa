class Solution {
    int result;
    int rowmax;
    int columnmax;
    public int numIslands(char[][] grid) {
        result = 0;
        rowmax = grid.length;
        columnmax = grid[0].length;
        for(int row = 0 ; row<rowmax ; row++){
            for(int column = 0 ; column<columnmax ; column++){
                if(grid[row][column]=='1'){
                    result++;
                    dfs(grid, row, column);
                }
            }
        }
        return result;
    }

    void dfs(char[][] grid, int row, int column){
        if(row<0 || column<0 || !(row<rowmax) || !(column<columnmax)){
            return;
        }
        if(grid[row][column]!='1'){
            return;
        }
        else{
            // result++;
            grid[row][column] = '0';
            dfs(grid, row+1, column);
            dfs(grid, row-1, column);
            dfs(grid, row, column+1);
            dfs(grid, row, column-1);
            return;
        }
    }
}
