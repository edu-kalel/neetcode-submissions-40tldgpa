class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int target = 0;
        int i = 0;
        while(i<nums.length){
            int l = i+1;
            int r = nums.length-1;
            while(l<r){
                int sum = nums[i]+nums[l]+nums[r];
                if(sum>0){
                    r--;
                    continue;
                }
                if(sum<0){
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
