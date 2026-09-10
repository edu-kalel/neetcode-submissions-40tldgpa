class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hs = new HashSet<>();
        for(int num : nums){
            hs.add(num);
        }

        int result = 0;
        for(int num : nums){
            if(!(hs.contains(num-1))){
                int newsequence = 1;
                int next = num+1;
                while(hs.contains(next)){
                    newsequence++;
                    next++;
                }
                result = Math.max(result, newsequence);
            }
        }
        return result;
    }
}
