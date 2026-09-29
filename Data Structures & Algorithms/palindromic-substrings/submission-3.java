class Solution {
    
    int result;

    public int countSubstrings(String s) {
        result = 0;

        // iterate over chars and extend to the sides
        for(int i = 0 ; i<s.length() ; i++){
            helper(s, i, i);
            helper(s, i, i+1);
        }


        return result;
    }

    void helper(String s, int l, int r){
        // boundaries
        while(l>=0 && r<s.length() && s.charAt(l) == s.charAt(r)){
            l--;
            r++;
            result++;
        }
    }
}
