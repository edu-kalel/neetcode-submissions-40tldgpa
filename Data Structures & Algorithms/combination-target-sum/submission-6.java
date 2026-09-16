class Solution {
    List<List<Integer>> result ;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(nums, target, 0, new ArrayList<>(), 0);
        return result;
    }

    void dfs(int[] nums, int target, int sum, List<Integer> current, int index){
        if(sum==target){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = index ; i<nums.length ; i++){
            if(sum+nums[i]>target){
                return;
            }
            current.add(nums[i]);
            dfs(nums, target, sum+nums[i], current, i);
            current.remove(current.size()-1);
        }
    }
}
