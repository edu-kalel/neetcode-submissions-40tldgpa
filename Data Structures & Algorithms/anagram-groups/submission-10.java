class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        // hmap
        // iterate through strs
        // array per strs
        // array to string -> key (k, v) value -> str
        // hmap to list
        Map<String, List<String>> hmap = new HashMap<>();
        for(String str : strs){
            int[] count = new int[26];
            for(char c : str.toCharArray()){
                count[c-'a']++;
            }
            String key = Arrays.toString(count);
            hmap.computeIfAbsent(key, k -> new ArrayList<>());
            hmap.get(key).add(str);
        }
        return new ArrayList<>(hmap.values());
    }
}
