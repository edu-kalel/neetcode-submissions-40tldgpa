class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String, List<String>> hashmap = new HashMap<String, List<String>>();
        for(String str : strs){
            int[] keyarray = new int[26];
            for(char c : str.toCharArray()){
                keyarray[c - 'a']++;
            }
            String key = Arrays.toString(keyarray);
            hashmap.putIfAbsent(key, new ArrayList<String>());
            hashmap.get(key).add(str);
        }
        return new ArrayList<>(hashmap.values());
    }
}
