class Solution {
    public boolean isAnagram(String s, String t) {
        int slength = s.length(), tlength = t.length();
        if(slength != tlength)
            return false;
        HashMap<Character, Integer> shmap = new HashMap<Character, Integer>();
        HashMap<Character, Integer> thmap = new HashMap<Character, Integer>();
        for (int i=0; i<slength; i++){
            shmap.put(s.charAt(i), (shmap.getOrDefault(s.charAt(i), 0))+1);
            thmap.put(t.charAt(i), (thmap.getOrDefault(t.charAt(i), 0))+1);
            // char schar = s.charAt(i);
            // char tchar = t.charAt(i);
            // if(shmap.get(schar)==null)
            //     shmap.put(schar, 1);
            // else{
            //     int scounter = shmap.get(schar);
            //     shmap.put(schar, scounter++);
            // }
            // if(thmap.get(tchar)==null)
            //     thmap.put(tchar, 1);
            // else{
            //     int tcounter = thmap.get(tchar);
            //     thmap.put(tchar, tcounter++);
            // }
        }
        return shmap.equals(thmap);
    }
}
