class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while(i<nums.length){
            int target = 0 - nums[i];
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[l]+nums[r];
                if(sum>target){
                    r--;
                    continue;
                }
                if(sum<target){
                    l++;
                    continue;
                }

                List<Integer> list = new ArrayList<>();
                list.add(nums[i]);
                list.add(nums[l]);
                list.add(nums[r]);
                result.add(list);

                l++;
                while(nums[l]==nums[l-1] && l<r){
                    l++;
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
