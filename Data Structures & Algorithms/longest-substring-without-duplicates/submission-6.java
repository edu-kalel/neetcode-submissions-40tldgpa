class Solution {
    public int lengthOfLongestSubstring(String s) {
        int start = 0;
        int max = 0;
        HashMap<Character, Integer> seen = new HashMap<>();

        for (int end = 0; end<s.length(); end++){
            if(seen.containsKey(s.charAt(end))){
                start = Math.max(start, seen.get(s.charAt(end))+1);
            }
            seen.put(s.charAt(end), end);
            max = Math.max(max, end-start+1);
        }
        return max;
    }
}
