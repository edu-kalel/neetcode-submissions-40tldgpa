class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> solution = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c - 'a']++;
            }
            String key = Arrays.toString(count);
            solution.putIfAbsent(key, new ArrayList<>());
            solution.get(key).add(str);
        }
        return new ArrayList<>(solution.values());
    }
}
