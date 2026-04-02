class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {

        // iterate through strs
        // for each str, count how many occurences of each letter
        // save in hashmap, occurrences -> k , word -> value
        // next str
        // return values of hM
        
        // List<List<String>> result = new ArrayList<>();

        Map<String,List<String>> hMap = new HashMap<>();
        for(String str : strs){
            int[] alph = new int[26];
            for(char c : str.toCharArray()){
                alph[c - 'a']++;
            }
            String key = Arrays.toString(alph);
            hMap.putIfAbsent(key, new ArrayList<>());
            hMap.get(key).add(str);
        }

        return new ArrayList<>(hMap.values());
    }
}
