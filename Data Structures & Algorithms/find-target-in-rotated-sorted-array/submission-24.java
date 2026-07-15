class Solution {
    public int search(int[] nums, int target) {
        int l=0;
        int r=nums.length-1;
        int solution = -1;

        while(l<=r){
            int m = ((r-l)/2)+l;
            if(nums[m]==target){
                return m;
            }
            // we are in the left sorted
            if (nums[l]<=nums[m]){
                if(target>nums[m]||target<nums[l]){
                    l = m+1;
                }
                else{
                    r = m-1;
                }
            }
            // right sorted??
            else{
                if(target<nums[m]||target>nums[r]){
                    r=m-1;
                }
                else{
                    l=m+1;
                }
            }
        }
        return solution;
    }
}
