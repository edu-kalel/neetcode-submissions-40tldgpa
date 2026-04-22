class Solution {
    int result;
    int iMax;
    int jMax;
    public int numIslands(char[][] grid) {
        result = 0;
        iMax = grid.length;
        jMax = grid[0].length;

        for(int i = 0 ; i<iMax ; i++){
            for(int j = 0 ; j<jMax ; j++){
                if(grid[i][j]=='1'){
                    result++;
                    island(grid, i, j);
                }
            }
        }
        return result;
    }

    void island(char[][] grid, int i , int j){
        if(i<0 || j<0 || !(i<iMax) || !(j<jMax)){
            return;
        }
        if(grid[i][j]!='1'){
            return;
        }
        if(grid[i][j]=='1'){
            grid[i][j] = '#';
            island(grid, i, j+1);
            island(grid, i, j-1);
            island(grid, i+1, j);
            island(grid, i-1, j);
        }
        
    }
}
