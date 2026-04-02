class Solution {
    public int[] twoSum(int[] nums, int target) {
        HashMap<Integer, Integer> set = new HashMap<Integer, Integer>(); 
        for(int i=0; i<nums.length; i++){
            int need = target - nums[i];
            if(set.containsKey(need)){
                int[] solution = {set.get(need), i};
                return (solution);
            }
            set.put(nums[i], i);
        }
        return null;
    }
}
