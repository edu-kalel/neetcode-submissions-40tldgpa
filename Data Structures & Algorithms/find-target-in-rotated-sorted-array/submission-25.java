class Solution {
    public int search(int[] nums, int target) {
        // [ 6, 1, 2, 3, 4, 5 ]
        // binary search
        // l , r , mid
        // while(n[mid]!=target)
            // check which side im in
            // if(nl<=nmid)
                // im on left
                // if(target<nmid)
                    // if(target<nl)
                        // search right
                    // else
                        // search left
                // else
                    // search right
            // else
                // in on right
                // if(target>nmid)
                    // if(target>nr)
                        // search left
                    // else search right
                // else
                    // search left
        int l = 0, r = nums.length-1, mid;
        while(l<=r){
            mid = (r-l)/2 + l;
            if(nums[mid]==target){
                return mid;
            }
            if(nums[l]<=nums[mid]){
                if(target<nums[mid]){
                    if(target<nums[l]){
                        l = mid+1;
                    }
                    else{
                        r = mid-1;
                    }
                }
                else{
                    l = mid+1;
                }
            }
            else{
                if(target>nums[mid]){
                    if(target>nums[r]){
                        r = mid-1;
                    }
                    else{
                        l = mid+1;
                    }
                }
                else{
                    r = mid-1;
                }
            }
        }
        return -1;
    }
}
