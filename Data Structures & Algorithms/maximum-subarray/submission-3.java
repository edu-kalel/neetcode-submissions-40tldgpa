class Solution {
    public int maxSubArray(int[] nums) {
        int result = Integer.MIN_VALUE;
        int current = 0;
        for(int num : nums){
            // int newsum = num;
            current = Math.max(num, current+num);
            result = Math.max(result, current);
        }
        return result;
    }
}
