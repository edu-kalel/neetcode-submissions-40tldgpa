class DSU{
    int[] parents;
    int[] ranks;

    public DSU(int n){
        parents = new int[n];
        ranks = new int[n];
        for(int i = 0; i<n ; i++){
            parents[i] = i;
            ranks[i] = 1;
        }
    }

    public int find(int n){
        if(parents[n]!=n){
            parents[n] = find(parents[n]);
        }
        return parents[n];
    }

    public boolean union(int m, int n){
        int parent1 = find(m);
        int parent2 = find(n);
        if(parent1==parent2){
            return false;
        }
        if(ranks[parent1]<ranks[parent2]){
            parents[parent1] = parents[parent2];
            ranks[parent2]++;
        }
        else{
            parents[parent2]=parents[parent1];
            ranks[parent1]++;
        }
        return true;
    }
}

class Solution {
    public int countComponents(int n, int[][] edges) {
        DSU dsu = new DSU(n);
        int result = n;
        for(int[] edge : edges){
            if(dsu.union(edge[0], edge[1])){
                result--;
            }
        }
        return result;
    }
}
