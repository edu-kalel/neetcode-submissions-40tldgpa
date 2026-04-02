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

        // map<k,v> <num, occurrences>
        Map<Integer, Integer> occurrences = new HashMap<>();
        for(int num : nums){
            occurrences.put(num, occurrences.getOrDefault(num,0)+1);
        }
        // System.out.println(occurrences);

        for(Map.Entry<Integer, Integer> entry : occurrences.entrySet()){
            freq[entry.getValue()].add(entry.getKey());
        }
        System.out.println(Arrays.toString(freq));

        int[] result = new int[k];
        int rIndex = 0;
        for(int i = freq.length-1; i>0 && rIndex < k ; i--){
            for(int num : freq[i]){
                System.out.println(num);
                result[rIndex++] = num;
                if(rIndex==k){
                    return result;
                }
            }
        }
        return result;
    }
}
