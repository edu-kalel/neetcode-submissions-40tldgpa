class Solution {
    public int lengthOfLongestSubstring(String s) {
        Set<Character> seen = new HashSet<>();
        int longest = 0;
        int l = 0;
        int r = 0;
        while(r<s.length()){
            while(seen.contains(s.charAt(r))){
                seen.remove(s.charAt(l));
                l++;
            }
            longest = Math.max(longest, (r-l+1));
            seen.add(s.charAt(r));
            r++;
        }
        return longest;
    }
}
