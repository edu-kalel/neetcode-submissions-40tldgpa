class Solution {
    public int longestConsecutive(int[] nums) {
        Set<Integer> hashSet = new HashSet<>();
        for (int num : nums){
            hashSet.add(num);
        }
        int longest = 0;
        
        for(int num : nums){
            if(!hashSet.contains(num-1)){
                int prospect=1;
                while(hashSet.contains(num+prospect)){
                    prospect++;
                }
                longest = Math.max(longest, prospect);
            }
        }
        return longest;
    }
}
