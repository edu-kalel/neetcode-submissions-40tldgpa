class Solution {
    Map<Integer, List<Integer>> adj;
    Set<Integer> visited;
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        // build a map
        // <Int, List>
        // <course, prerequisites>
        // 
        //  have a set , visited
        // recursive check here??
        //  
        // loop ( i = 0 -> numCourses -1)
        //  get map entry [i]
        // nah recursive check here
        //  recursive check (i)
        //      if i in visited
        //          fuck it return false
        //      add i to visited
        //      loop pq through i prereqs
        //  
        //          recursive check to 
        //      all good? remove from visited

        adj = new HashMap<>();
        for(int[] entry : prerequisites){
            adj.computeIfAbsent(entry[0], key -> new ArrayList<>()).add(entry[1]);
            // adding course and all its prerequisites
        }

        visited = new HashSet<>();

        for(int i = 0 ; i<numCourses ; i++){
            // if(adj.containsKey(i)){
                if(!canComplete(i)){
                    return false;
                }
                adj.put(i, new ArrayList<>());
            // }
        }

        return true;

    }

    boolean canComplete(int i){
        if(visited.contains(i)){
            return false;
        }
        visited.add(i);
        List<Integer> prereqs = adj.get(i);
        if(prereqs!=null && !prereqs.isEmpty()){
            for(int prereq : prereqs){
                if(!canComplete(prereq)){
                    return false;
                }
                adj.put(prereq, new ArrayList<>());
            }
        }
        visited.remove(i);
        return true;
    }
}
