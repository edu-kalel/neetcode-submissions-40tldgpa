class Solution {
    List<List<Integer>> result;
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        Arrays.sort(candidates);
        result = new ArrayList<>();
        backtracking(candidates, target, new ArrayList<>(), 0);
        return result;
    }

    void backtracking(int[] candidates, int target, List<Integer> currentlist, int i){
        // base cases
        if(target == 0){
            result.add(new ArrayList<>(currentlist));
            // System.out.println(currentlist);
            return;
        }
        if(target<0 || !(i<candidates.length)){
            return;
        }

        currentlist.add(candidates[i]);
        backtracking(candidates, target - candidates[i], currentlist, i+1);
        currentlist.remove(currentlist.size()-1);
        i++;

        while(i < candidates.length && candidates[i]==candidates[i-1]){
            i++;
        }
        backtracking(candidates, target, currentlist, i);
    }
}
