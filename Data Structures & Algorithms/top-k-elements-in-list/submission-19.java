class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        // create buckets (freq), array of lists, size of nums.length
        // populate with empty lists
        // create hashmap (num, occurrences) and count occurrences per num
        // iterate hmap, freq, i = occurences, [i] content = num (s)
        // create int[] result, size k
        // iterate freq[] from + to -, last to first
        //  iterate array inside freq[]
        //  add
        // return
        
        List<Integer>[] freq = new List[nums.length+1];

        for(int i = 0 ; i<freq.length ; i++){
            freq[i] = new ArrayList<>();
        }

        // map<k -> num, v -> occurrences>
        Map<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        for(Map.Entry<Integer, Integer> entry : map.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        int[] result = new int[k];
        int rcounter = 0;
        for(int i = freq.length-1 ; i>0 && rcounter<k ; i--){
            for(int num : freq[i]){
                if(!(rcounter<k)){
                    return result;
                }
                result[rcounter++] = num;
            }
        }
        return result;
    }
}
