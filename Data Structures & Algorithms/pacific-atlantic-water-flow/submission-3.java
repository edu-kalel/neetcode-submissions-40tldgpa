class Solution {
    List<List<Integer>> result;
    Set<List<Integer>> pac;
    Set<List<Integer>> atl;
    int rowMax;
    int columnMax;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        result = new ArrayList<>();
        pac = new HashSet<>();
        atl = new HashSet<>();
        rowMax = heights.length;
        columnMax = heights[0].length;
        // from sea to land
        // pacific upper
        for(int column = 0 ; column<columnMax ; column++){
            dfs(0, column, heights, 0, pac);
        }
        // pacific left
        for(int row = 0 ; row<rowMax; row++){
            dfs(row, 0, heights, 0, pac);
        }
        // atlantic lower
        for(int column = 0 ; column<columnMax ; column++){
            dfs(rowMax-1, column, heights, 0, atl);
        }
        // atlantic right
        for(int row = 0 ; row<rowMax ; row++){
            dfs(row, columnMax-1, heights, 0, atl);
        }

        // check matcher
        for(List<Integer> solution : pac){
            if(atl.contains(solution)){
                result.add(solution);
            }
        }
        return result;
    }

    void dfs(int row, int column, int[][] heights, int prev, Set<List<Integer>> sea){
        // base cases
        // out of bounds
        if(row<0 || column < 0 || row>= rowMax || column>=columnMax){
            return;
        }
        // check if already in set
        List<Integer> solution = new ArrayList<>();
        solution.add(row);
        solution.add(column);
        if(sea.contains(solution)){
            return;
        }
        // check if it can reach
        if(heights[row][column]>=prev){
            // it can
            // add cordinates to set
            sea.add(solution);
            // check contiguous
            dfs(row+1, column, heights, heights[row][column], sea);
            dfs(row-1, column, heights, heights[row][column], sea);
            dfs(row, column+1, heights, heights[row][column], sea);
            dfs(row, column-1, heights, heights[row][column], sea);
        }
    }
}
