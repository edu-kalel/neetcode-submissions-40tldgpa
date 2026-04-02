class Solution {
    public List<List<Integer>> threeSum(int[] nums) {
        // sort nums
        // create result list
        // first loop i 
            // target = 0 - nums[i]
            // left = i+1 , right = nums.length-1
            // while(left<right)
                // if(left+right == target)
                    // new list, add nums[i left right]
                    // left++ right--
                    // while(nums[left]==nums[left-1] and left<right){left++}
                    // same with right OR NOT
                    // 
                // else if(sum < target)
                    // left++
                // else if(sum>target)
                    // left--
                // return result
        Arrays.sort(nums);
        List<List<Integer>> result = new ArrayList<>();
        int i = 0;
        while(i<nums.length){
            int target = 0 - nums[i];
            int left = i+1, right = nums.length -1;
            while(left<right){
                int sum = nums[left]+nums[right];
                if(sum==target){
                    List<Integer> sub = new ArrayList<>();
                    sub.add(nums[i]);
                    sub.add(nums[left]);
                    sub.add(nums[right]);
                    result.add(sub);
                    left++;
                    while(nums[left]==nums[left-1] && left<right){
                        left++;
                    }
                }
                else if(sum < target){
                    left++;
                }
                else if(sum > target){
                    right--;
                }
            }
            i++;
            while( i<nums.length && nums[i]==nums[i-1]){
                i++;
            }
        }
        return result;
    }
}
