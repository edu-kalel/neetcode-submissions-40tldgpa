class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, Integer> count = new HashMap<>();
        List<Integer>[] freq = new List[nums.length+1];

        for(int i = 0; i<freq.length; i++ ){
            freq[i] = new ArrayList<>();
        }

        for(int n : nums){
            count.put(n, count.getOrDefault(n, 0)+1);
        }
        for(Map.Entry<Integer, Integer> entry : count.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }

        int[] solution = new int[k];
        int index = 0;
        for(int i = freq.length -1 ; index < k && i>0; i--){
            for(int n : freq[i]){
                solution[index] = n;
                index++;
                if(index==k){
                    return solution;
                }
            }
        }
        return solution;
    }
}
