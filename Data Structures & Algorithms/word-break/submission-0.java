class Solution {
    Map<Integer, Boolean> map;
    public boolean wordBreak(String s, List<String> wordDict) {
        map = new HashMap<>();
        map.put(s.length(), true);
        return dfs(0, wordDict, s);
    }

    boolean dfs(int i, List<String> words, String s){
        if(map.containsKey(i)){
            return map.get(i);
        }
        for(String word : words){
            if((word.length()<= s.length()-i )&& word.equals(s.substring(i, word.length()+i))){
                if(dfs(i+word.length(), words, s)){
                    map.put(i, true);
                    return true;
                }
            }
        }
        map.put(i, false);
        return false;
    }
}
