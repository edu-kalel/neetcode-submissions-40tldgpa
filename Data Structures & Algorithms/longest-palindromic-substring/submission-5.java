class Solution {
    public String longestPalindrome(String s) {
        // start from center and expand
        String result = s.substring(0,1);
        int longest = result.length();

        for(int i = 0 ; i<s.length() ; i++){
            int b = i-1;
            int a = i+1;
            // odd
            while(  b>=0 && a<s.length()
                    && s.charAt(b) == s.charAt(a)){
                b--;
                a++;
                }
            if(a-b-1>longest){
                result = s.substring(b+1, a);
                longest = result.length();
            }
            // even
            // abba
            b = i;
            a = i+1;
            while(b>=0 && a<s.length() 
                && s.charAt(b)==s.charAt(a)){
                    b--;
                    a++;
                }
            if(a-b-1>longest){
                result = s.substring(b+1, a);
                longest = result.length();
            }
        }
        return result;

    }
}
