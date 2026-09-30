class Solution {
    public int maxProduct(int[] nums) {
        // need currenmin, currentmax, result
        int result = nums[0];
        int currentmax = 1;
        int currentmin = 1;
        // 3 paths, new result starting here, multiplying by prev biggest and by prev smallest
        for(int num : nums){
            int temp = num * currentmax;
            currentmax = Math.max(num, Math.max(num * currentmax, num * currentmin));
            currentmin = Math.min(num, Math.min(temp, num * currentmin));
            result = Math.max(result, currentmax);
        }
        return result;
    }
}
