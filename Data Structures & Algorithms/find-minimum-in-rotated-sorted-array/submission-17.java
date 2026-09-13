class Solution {
    public int findMin(int[] nums) {

        int l = 0, r = nums.length-1, mid = nums.length/2;

        while(nums[l]>nums[r]){
            if(nums[mid]<=nums[r]){
                r = mid;
                mid = ((r-l)/2) + l ;
            }
            else{
                l = mid+1;
                mid = ((r-l)/2)+l;
            }
        }

        return nums[l];
        
    }
    // [3, 4, 5, 6, 1, 2]
    // [5, 6, 1, 2, 3, 4]
    // [5, 6, 7, 1, 2, 3, 4]
    // [1, 2, 3, 4, 5, 6, 7]
}
