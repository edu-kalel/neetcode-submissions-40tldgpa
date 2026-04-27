class Solution {

    Set<Integer> visited;
    Map<Integer, List<Integer>> hmap;
    public boolean validTree(int n, int[][] edges) {
        if(edges.length > n-1){
            return false;
        }

        // adjacency list
        hmap = new HashMap<>();
        // initialize
        for(int i = 0 ; i<n ; i++){
            hmap.put(i, new ArrayList<>());
        }
        // fill
        for(int[] edge : edges){
            hmap.get(edge[0]).add(edge[1]);
            hmap.get(edge[1]).add(edge[0]);
        }
        // adjacency list complete
        // now dfs
        visited = new HashSet<>();
        return dfs(-1, 0) && visited.size()==n;
    }

    boolean dfs(int prev, int current){
        if(visited.contains(current)){
            return false;
        }
        visited.add(current);
        for(int i : hmap.get(current)){
            if(i==prev){
                continue;
            }
            if(!dfs(current, i)){
                return false;
            }
        }
        return true;
    }
}
