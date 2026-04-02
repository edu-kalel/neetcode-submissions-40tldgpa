class Solution {
    public int maxArea(int[] heights) {
        int left = 0;
        int max = 0;
        while(left<heights.length-1){
            int right = left+1;
            while(right<heights.length){
                int tallest = Math.min(heights[left], heights[right]);
                int currentVolume = (tallest*(right-left));
                max = Math.max(currentVolume, max);
                right++;
            }
            left++;
        }
        return max;
    }
}
