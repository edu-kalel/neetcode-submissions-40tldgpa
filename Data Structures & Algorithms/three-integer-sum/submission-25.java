class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        Arrays.sort(nums);
        int i = 0 ;
        while(i<nums.length-2){
            int target = 0 - nums[i];
            int start = i+1;
            int end = nums.length-1;
            while(start<end){
                if(nums[start]+nums[end]>target){
                    end--;
                    continue;
                }
                else if(nums[start]+nums[end]<target){
                    start++;
                    continue;
                }
                else{
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[start]);
                    sub.add(nums[end]);
                    result.add(sub);
                    start++;
                    while(nums[start]==nums[start-1] && start<end){
                        start++;
                    }
                }
            }
            i++;
            while(i<nums.length && nums[i]==nums[i-1]){
                i++;
            }
        }
        return result;
    }
}
