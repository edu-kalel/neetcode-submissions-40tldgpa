class Solution {
    public String minWindow(String s, String t) {
        if(t.length()==0 || s.length()<t.length()){
            return "";
        }
        // hashmap , frequency of each char in t, tmap
        // another map, window
        // how many we have , 
        // how many we need , tmap size i think
        // int l, r, =0;  resultlength = integer.max
        // int[2], -1 and -1, result 
        // start iterating
        // s[r] add to window
        // tmap contains s[r]? matches count? then increment have
        // have== need? 
            // resultlength = min(resultlength, newlength)
            // while have == need
                // move l++, removing l-- on count map
                // tmap contains s[l]? count in res is less? then have--
                // move l++
        // return reslength == maxvalue ? "" : substring[l, r]

        // fixes:
        // only update result[] when it is in fact, smaller
        Map<Character, Integer> tmap = new HashMap<>();
        Map<Character, Integer> window = new HashMap<>();
        int have = 0;
        for(char c : t.toCharArray()){
            tmap.put(c, tmap.getOrDefault(c,0)+1);
        }
        int need = tmap.size();
        int l = 0 , r = 0 , reslength = Integer.MAX_VALUE;
        int[] resplaces = {-1 , -1};
        while(r<s.length()){
            window.put(s.charAt(r) , window.getOrDefault(s.charAt(r), 0)+1);
            if(tmap.containsKey(s.charAt(r)) && tmap.get(s.charAt(r)).equals(window.get(s.charAt(r)))){
                have++;
            }
            while(have==need){
                if(r-l+1<reslength){
                    reslength = r-l+1;
                    resplaces[0]=l;
                    resplaces[1]=r;
                }
                // reslength = Math.min(reslength, r-l+1);
                // resplaces[0]=l;
                // resplaces[1]=r;
                window.put(s.charAt(l), window.get(s.charAt(l))-1);
                if(tmap.containsKey(s.charAt(l)) && window.get(s.charAt(l)) < tmap.get(s.charAt(l))){
                    have--;
                }
                l++;
            }
            r++;
        }
        return reslength == Integer.MAX_VALUE ? "" : s.substring(resplaces[0], resplaces[1]+1);
    }
}
