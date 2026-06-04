class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int l = 0;
        int r = numbers.length -1;
        while(l<r){
            if(numbers[l]+numbers[r]==target){
                int[] result = {l+1, r+1};
                return result;
            }
            if(numbers[l]+numbers[r]>target){
                r--;
                continue;
            }
            if(numbers[l]+numbers[r]<target){
                l++;
                continue;
            }
        }
        return new int[2];
    }
}
