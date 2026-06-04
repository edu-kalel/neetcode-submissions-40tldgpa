class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if(s1.length()>s2.length()){
            return false;
        }
        int[] map1 = new int[26];
        for(char c : s1.toCharArray()){
            map1[c-'a']++;
        }
        System.out.println(Arrays.toString(map1));
        // sliding window, fixed size, scan s2 for map match
        for(int i = 0 ; i<=s2.length()-s1.length() ; i++){
            int[] map2 = new int[26];
            for(char c : s2.substring(i, i+s1.length()).toCharArray()){
                map2[c-'a']++;
            }
            System.out.println(Arrays.toString(map2));
            if(Arrays.toString(map2).equals(Arrays.toString(map1))){
                return true;
            }
        }
        return false;
    }
}
