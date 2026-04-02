class Solution {
    public int longestConsecutive(int[] nums) {
        // create hashset
        // copy stuff
        // iterate
        // has previous? like i-1?
        // no, continue
        // yes, ok start squence
        // loop? while next or smth like that
            // next exist? +1
        // no next? ok save as max(int big = 0 (prev), new big)
        // return big
        Set<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }
        int result = 0;
        for(int num : hs){
            if(!hs.contains(num-1)){
                int newSequence = 1;
                int next = num+1;
                while(hs.contains(next)){
                    newSequence++;
                    next++;
                }
                result = Math.max(result, newSequence);
            }
        }
        return result;
    }
}
