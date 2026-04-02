class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        // int left = 1;
        Arrays.sort(nums);

        List<List<Integer>> solution = new ArrayList<>();

        for(int pivot = 0 ; pivot<nums.length-2 ; pivot++){
            if (nums[pivot]>0){
                break;
            }
            if(pivot>0 && (nums[pivot]==nums[pivot-1])){
                continue;
            }
            int left = pivot+1;
            int right = nums.length-1;
            while(left<right){
                int sum = nums[pivot]+nums[left]+nums[right];
                if(sum<0){
                    left++;
                    continue;
                }
                else if (sum>0){
                    right--;
                    continue;
                }
                else if (sum==0){
                    List<Integer> sums0 = new ArrayList<>();
                    sums0.add(nums[pivot]);
                    sums0.add(nums[left]);
                    sums0.add(nums[right]);
                    solution.add(sums0);
                }
                left++;
                while(nums[left]==nums[left-1]&&left<right){
                    left++;
                }
                right--;
                while(nums[right]==nums[right+1]&&right>left){
                    right--;
                }
            }

        }

        return solution;
    }
}
