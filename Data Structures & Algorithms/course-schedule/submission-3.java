class Solution {
    Map<Integer, List<Integer>> map = new HashMap<>();
    Set<Integer> visited = new HashSet<>();

    public boolean canFinish(int numCourses, int[][] prerequisites) {
        for(int i = 0; i<numCourses ; i++){
            map.put(i, new ArrayList<>());
        }
        for(int[] prerequisite : prerequisites){
            // map.putIfAbsent(prerequisite[0], new ArrayList<>());
            map.get(prerequisite[0]).add(prerequisite[1]);
        }
        for(int i = 0 ; i<numCourses ; i++){
            if(!dfs(i)){
                return false;
            }
        }
        return true;
    }

    boolean dfs(int i){
        if(visited.contains(i)){
            return false;
        }
        if(map.get(i).isEmpty()){
            return true;
        }

        visited.add(i);
        for(int pre : map.get(i)){
            if(!dfs(pre)){
                return false;
            }
        }
        visited.remove(i);
        map.put(i, new ArrayList<>());
        return true;

    }
}
