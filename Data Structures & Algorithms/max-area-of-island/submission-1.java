class Solution {
    int maxarea;
    int imax;
    int jmax;
    public int maxAreaOfIsland(int[][] grid) {
        // traverse each square
        // if 0, next
        // if 1, island
            // dfs on that, search up down left right until no more 1s
            // area, max? update
            // also mark visited
            // come back
            // repeat
        // if visited, next
        maxarea = 0;
        imax = grid.length;
        jmax = grid[0].length;
        for(int i = 0; i<grid.length ; i++){
            for(int j = 0 ; j<grid[0].length ; j++){
                if(grid[i][j]!=1){
                    continue;
                }
                // if(grid[i][j]==2){
                //     continue;
                // }
                if(grid[i][j]==1){
                    maxarea = Math.max(maxarea, dfs(grid, i, j));
                }
            }
        }
        return maxarea;
    }
    
    int dfs(int[][] grid, int i, int j){
        if(!(i<imax)||!(j<jmax)||i<0||j<0){
            return 0;
        }
        else if(grid[i][j] == 1){
            grid[i][j]=0;
            return 1+
            dfs(grid, i,j+1)+
            dfs(grid, i,j-1)+
            dfs(grid, i+1,j)+
            dfs(grid, i-1,j);
        }
        else{
            return 0;
        }
    }
}
