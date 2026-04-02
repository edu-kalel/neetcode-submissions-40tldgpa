class Solution {
    public int lengthOfLongestSubstring(String s) {
        // two pointers
        // create a hashset, hs
        // int res = 0;
        // int l = 0, r = 0;
        // loop while r<s.length, increasing r
        // do
        // if(hashset.contains(s.at(r)))
            // while(hashset.contains(s.at(r)))
                // hashset.remove(s.at(l))
                // l++;
        // int current size;
        // max (current, result);
        // 
        // add r to hashset
        // return result
        Set<Character> hs = new HashSet<>();
        int res = 0 , l=0 , r=0;
        while(r<s.length()){
            while(hs.contains(s.charAt(r))){
                hs.remove(s.charAt(l));
                l++;
            }
            res = Math.max(res, r-l+1);
            hs.add(s.charAt(r));
            r++;
        }
        return res;
    }
}
