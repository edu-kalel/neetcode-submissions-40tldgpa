class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0 || t.length()>s.length()){
            return "";
        }

        Map<Character, Integer> tmap = new HashMap<>();
        for(char c : t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c, 0)+1);
        }

        Map<Character, Integer> window = new HashMap<>();
        int minlen = Integer.MAX_VALUE;
        int l = 0 , r = 0;
        int[] resindex = {-1, -1};
        int need = tmap.size(), have = 0;

                // have== need? 
                    // resultlength = min(resultlength, newlength)
                    // while have == need
                        // move l++, removing l-- on count map
                        // tmap contains s[l]? count in res is less? then have--
                        // move l++
                // return reslength == maxvalue ? "" : substring[l, r]

                // fixes:
                // only update result[] when it is in fact, smaller
        while(r<s.length()){
            char c = s.charAt(r);
            window.put(c, window.getOrDefault(c, 0)+1);
            if(tmap.containsKey(c) && window.get(c).equals(tmap.get(c))){
                have++;
            }
            while(have==need){
                int currentlen = r-l+1;
                if(currentlen<minlen){
                    minlen = currentlen;
                    resindex[0] = l;
                    resindex[1] = r;
                }
                char lc = s.charAt(l);
                window.put(lc, window.get(lc)-1);
                if(tmap.containsKey(lc) && window.get(lc) < tmap.get(lc)){
                    have--;
                }
                l++;
            }
            r++;
        }
        return minlen == Integer.MAX_VALUE ? "" :
                s.substring(resindex[0], resindex[1]+1);
    }
}
