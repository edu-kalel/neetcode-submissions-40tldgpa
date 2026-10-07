class Solution {
    public int lengthOfLIS(int[] nums) {
        int[] lis = new int[nums.length];
        Arrays.fill(lis, 1);
        for(int i = lis.length-1; i>= 0 ; i--){
            for(int j = i+1 ; j<lis.length ; j++){
                if(nums[i]<nums[j]){
                    lis[i] = Math.max(lis[i], lis[j]+1);
                }
            }
        }
        return Arrays.stream(lis).max().getAsInt();
    }
}
