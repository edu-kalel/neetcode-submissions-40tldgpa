class Solution {
    public int characterReplacement(String s, int k) {
        // two pointers
        // sliding window
        // int maxfreq = 0 ; l = 0 ; r = 0;
        // hashmap count
        // loop
        // while(r<s.length), r++
        // register in count
        // maxfreq = max(maxfreq, s(k))
        // while is not valid, meaning characters to replace are greater than k
            // on the count, l--
            // l++
        // result = max(result, current size)
        int maxfreq = 0 , l = 0 , r = 0 , res = 0;
        Map<Character, Integer> map = new HashMap<>();
        while(r<s.length()){
            map.put(s.charAt(r), map.getOrDefault(s.charAt(r),0)+1);
            maxfreq = Math.max(maxfreq, map.get(s.charAt(r)));
            while((r-l+1-maxfreq)>k){
                map.put(s.charAt(l), map.get(s.charAt(l))-1);
                l++;
            }
            res = Math.max(res, r-l+1);
            r++;
        }
        return res;
    }
}
