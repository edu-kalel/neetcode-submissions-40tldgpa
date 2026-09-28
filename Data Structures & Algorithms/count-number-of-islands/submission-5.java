class Solution {
    int rowMax;
    int columnMax;
    int result;
    public int numIslands(char[][] grid) {
        result = 0;
        rowMax = grid.length;
        columnMax = grid[0].length;

        for(int row = 0 ; row<rowMax ; row++){
            for(int column = 0 ; column<columnMax ; column++){
                if(grid[row][column] == '1'){
                    result++;
                    island(grid, row, column);
                }
            }
        }

        return result;
    }

    void island(char[][] grid, int row, int column){
        // base cases
        // out of bounds
        if( row< 0 || column < 0 || row>= rowMax || column >= columnMax
            || grid[row][column]!='1'){
            return;
        }
        // it is part of the island
        grid[row][column] = '#';
        island(grid, row+1, column);
        island(grid, row-1, column);
        island(grid, row, column+1);
        island(grid, row, column-1);

    }
}
