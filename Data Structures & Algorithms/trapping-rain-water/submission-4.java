class Solution {
    public int trap(int[] height) {
        if(height == null || height.length ==0){
            return 0;
        }
        int l = 0;
        int r = height.length -1;
        int lmax = height[l];
        int rmax = height[r];
        int result = 0;
        while(l<r){
            if(lmax<rmax){
                l++;
                lmax = Math.max(lmax, height[l]);
                if(lmax - height[l]>0){
                    result += lmax - height[l];
                }
            }
            else{
                r--;
                rmax = Math.max(rmax, height[r]);
                if(rmax-height[r]>0){
                    result+=rmax - height[r];
                }
            }
        }
        return result;
    }
}
