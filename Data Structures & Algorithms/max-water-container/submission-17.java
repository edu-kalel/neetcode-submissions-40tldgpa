class Solution {
    public int maxArea(int[] heights) {
        int l = 0;
        int r = heights.length-1;
        int result = 0;
        while(l<r){
            int current = (r-l) * (Math.min(heights[l], heights[r]));
            result = Math.max(current, result);
            if(heights[l]<heights[r]){
                l++;
            }
            else{
                r--;
            }
        }
        return result;
    }
}
