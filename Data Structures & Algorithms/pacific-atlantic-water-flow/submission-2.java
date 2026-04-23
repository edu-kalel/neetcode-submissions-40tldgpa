class Solution {
    List<List<Integer>> result;
    int iMax;
    int jMax;
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        result = new ArrayList<>();
        Set<List<Integer>> pac = new HashSet<>();
        Set<List<Integer>> atl = new HashSet<>();

        // pac sea = top, left
        // atl sea = bottom, right
        // check from sea, which cells are reached
        iMax = heights.length;
        jMax = heights[0].length;
        // check top
        for(int  i = 0 ; i<iMax ; i++){
            dfs(i, 0, heights, 0, pac);
        }
        // check left
        for(int j = 0 ; j<jMax ; j++){
            dfs(0, j, heights, 0, pac);
        }
        // check bottom
        for(int i = 0 ; i<iMax ; i++){
            dfs(i, jMax-1, heights, 0, atl);
        }
        // check right
        for(int j=0 ; j<jMax ; j++){
            dfs(iMax-1, j, heights, 0, atl);
        }
        for(List<Integer> helper : pac){
            if (atl.contains(helper)){
                result.add(helper);
            }
        }
        return result;
    }

    void dfs(int i , int j, int[][] heights, int prevheight, Set<List<Integer>> set){
        if(i<0 || j<0 || !(i<iMax) || !(j<jMax)){
            return;
        }
        if(heights[i][j]>=prevheight){
            List<Integer> helper = new ArrayList<>();
            helper.add(i);
            helper.add(j);
            if(set.contains(helper)){
                return;
            }
            set.add(helper);
            dfs(i, j+1, heights, heights[i][j], set);
            dfs(i, j-1, heights, heights[i][j], set);
            dfs(i+1, j, heights, heights[i][j], set);
            dfs(i-1, j, heights, heights[i][j], set);
        }
        // return;
    }
}
