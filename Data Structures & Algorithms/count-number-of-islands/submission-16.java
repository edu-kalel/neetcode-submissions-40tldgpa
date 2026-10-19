class Solution {
    // boundaries
    int rMax;
    int cMax;

    public int numIslands(char[][] grid) {
        // traverse grid
        // if 1, theres an island!!
        // SWALLOW IT
        // next
        // yayy
        // profit???
        rMax = grid.length;
        cMax = grid[0].length;
        int result = 0;
        for(int row = 0 ; row<rMax ; row++){
            for(int column = 0 ; column<cMax ; column++){
                if(grid[row][column] == '1'){
                    result++;
                    swallow(grid, row, column);
                }
            }
        }
        return result;
    }

    void swallow(char[][] grid, int row, int column){
        // check : out of bounds??
        if(row<0 || column < 0 || !(row<rMax) || !(column<cMax) || grid[row][column]!='1'){
            return;
        }
        // transform 1 -> anything but 1
        grid[row][column] = '#';
        // spread
        swallow(grid, row+1, column);
        swallow(grid, row-1, column);
        swallow(grid, row, column+1);
        swallow(grid, row, column-1);
    }
}
