class Solution {
    public int maxArea(int[] heights) {
        int start = 0;
        int end = heights.length-1;
        int max=0;
        while(start<end){
            int shortest = Math.min(heights[start] , heights[end]);
            int currentVolume = shortest * (end-start);
            max = Math.max(currentVolume, max);
            if(heights[start]<=heights[end]){
                start++;
                continue;
            }
            if(heights[start]>heights[end]){
                end--;
            }
        }
        return max;
    }
}
