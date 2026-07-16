class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum(int[] nums, int target) {
        result = new ArrayList<>();
        Arrays.sort(nums);
        dfs(0, nums, target, 0, new ArrayList<>());
        return result;

    }

    void dfs(int index , int[] nums, int target, int sum, List<Integer> current){
        if(sum==target){
            result.add(new ArrayList<>(current));
            return;
        }
        for(int i = index ; i<nums.length ; i++){
            if(sum + nums[i]>target){
                return;
            }
            current.add(nums[i]);
            dfs(i, nums, target, sum+nums[i], current);
            current.remove(current.size()-1);

        }
    }
}
