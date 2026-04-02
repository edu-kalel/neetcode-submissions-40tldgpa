class Solution {
    public int[] twoSum(int[] nums, int target) {
        Map<Integer, Integer> seen = new HashMap<>();
        for(int i = 0 ; i<nums.length ; i++){
            int num = nums[i];
            int needed = target - num;
            if(seen.containsKey(needed)){
                int[] ans = {seen.get(needed) , i};
                return ans;
            }
            seen.put(num, i);
        }
        return new int[2];
    }
}
