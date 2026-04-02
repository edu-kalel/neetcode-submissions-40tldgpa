class Solution {
    public int maxArea(int[] heights) {
        // two pointers, start and end
        // max = 0
        // calculate amount of water
            // end - start * min(heights[start], h[end])
            // max = max(current, new)
        // move pointer with smaller height
        // umm i think thats it
        // return max
        int start = 0, end = heights.length-1;
        int max = 0;
        while(start<end){
            // calculate
            max = Math.max(max, ((end-start) * (Math.min(heights[start], heights[end]))));
            if(heights[start]<heights[end]){
                start++;
            }
            else{
                end--;
            }
        }
        return max;
    }
}
