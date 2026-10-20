class Solution {
    public int networkDelayTime(int[][] times, int n, int k) {
        //adjacency list
        Map<Integer, List<int[]>> edges = new HashMap<>();
        for(int[] time : times){
            edges.computeIfAbsent(
                time[0], // source
                key -> new ArrayList<>()
                ).add(new int[]{
                    time[1], //destination
                    time[2] // weight
                    }
                );
        }

        // min heap to know which one is the closest
        Queue<int[]> minHeap = new PriorityQueue<>((a, b) -> a[0]-b[0]);

        // from source k to destination k, 0 time
        minHeap.offer(new int[]{0, k});

        Set<Integer> visited = new HashSet<>(); //to keep track of visited

        int t = 0; //time

        while(!minHeap.isEmpty()){
            int[] curr = minHeap.poll(); //current path being evaluated
            int w1 = curr[0], n1 = curr[1]; //weight1, node1
            if(visited.contains(n1)){
                continue;   //we already have a min path for this node?? yeah then skip
            }
            visited.add(n1);
            t = w1;

            if(edges.containsKey(n1)){
                // now lets see which nodes are adjacent to n1
                for(int[] next : edges.get(n1)){
                    int n2 = next[0], w2 = next[1];
                    // can reach from n1 to n2, with weight = w2
                    if(!visited.contains(n2)){ //do we already have a min path to n2??
                        // we dont!! so then
                        minHeap.offer(new int[]{w1 + w2, n2}); //from source, it would take us w1+w2 to reach n2
                    }
                }
            }
        }

        return visited.size() == n ? //did we get to reach all nodes from source??
            t : -1;
    }
}
