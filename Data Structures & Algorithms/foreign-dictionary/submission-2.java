class Solution {
    Map<Character,Set<Character>> adj;
    Map<Character, Boolean> visited;
    // Set<Character> visited;
    List<Character> result;
    public String foreignDictionary(String[] words) {
        adj = new HashMap<>();
        for(String word : words){
            for(char c : word.toCharArray()){
                adj.putIfAbsent(c, new HashSet<>());
            }
        }
        for(int i = 0 ; i<words.length -1; i++){
            String w1 = words[i], w2 = words[i+1];
            if(w1.length()>w2.length() && w1.substring(0, w2.length()).equals(w2)){
                return "";
            }
            int minlen = Math.min(w1.length(), w2.length());
            for(int u = 0 ; u<minlen ; u++){
                if(w1.charAt(u)!=w2.charAt(u)){
                    adj.get(w1.charAt(u)).add(w2.charAt(u));
                    break;
                }
            }
        }
        visited = new HashMap<>();
        result = new ArrayList<>();
        for(char c : adj.keySet()){
            if(dfs(c)){
                return "";
            }
        }
        Collections.reverse(result);
        StringBuilder sb = new StringBuilder();
        for(char c : result){
            sb.append(c);
        }
        return sb.toString();
    }

    boolean dfs(char c){
        if(visited.containsKey(c)){
            return visited.get(c);
        }
        visited.put(c, true);
        for(char c2 : adj.get(c)){
            if(dfs(c2)){
                return true;
            }
        }
        visited.put(c, false);
        result.add(c);
        return false;
    }
}
