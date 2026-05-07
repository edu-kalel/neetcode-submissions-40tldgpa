class Solution {
    public String longestPalindrome(String s) {
        int residx = 0;
        int reslen = 0;
        for(int i = 0 ; i<s.length() ; i++){
            // odd
            int l = i, r = i;
            // int helperlen = 1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            int helperlenodd = r-l-1;
            if(helperlenodd>reslen){
                reslen = helperlenodd;
                residx = l+1;
            }
            // even
            l=i;
            r=i+1;
            while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
                l--;
                r++;
            }
            int helperleneven = r-l-1;
            // int longestoftwo = Math.max(helperlenodd, helperleneven);
            if(helperleneven>reslen){
                reslen = helperleneven;
                residx = l+1;
            }
        }
        return s.substring(residx, residx+reslen);
    }
}
