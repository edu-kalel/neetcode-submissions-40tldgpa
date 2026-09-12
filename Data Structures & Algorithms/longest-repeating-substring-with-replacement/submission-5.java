class Solution {
    public int characterReplacement(String s, int k) {
        // sliding window
        // start both pointers at 0
        // maxfreq 0 and result 0
        // frequency map
        // loop
        // moving r
        // check / register r freq
        // check max freq
        // if to replace > k
        // slide from left
        // if not, possible result, compare and save
        // return?

        int maxfreq = 0 , result = 0, l = 0 , r = 0;
        Map<Character, Integer> hmap = new HashMap<>();
        while(r<s.length()){
            hmap.put(s.charAt(r), hmap.getOrDefault(s.charAt(r), 0)+1);
            maxfreq = Math.max(maxfreq, hmap.get(s.charAt(r)));
            while(r-l+1-maxfreq > k){
                hmap.put(s.charAt(l), hmap.get(s.charAt(l))-1);
                l++;
            }
            result = Math.max(result, r-l+1);
            r++;
        }
        return result;
    }
}
