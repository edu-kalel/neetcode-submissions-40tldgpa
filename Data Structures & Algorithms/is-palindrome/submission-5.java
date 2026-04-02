class Solution {
    public boolean isPalindrome(String s) {
        // two pointers
        // s.at(start) !isNorD
            // start++
            // continue
        // s.at(end) !isNorD
            // end--
            // continue
        // s.at(start) != s.at(end)
            // return false
        // else start++ end--
        // return true
        int start = 0;
        int end = s.length()-1;
        while(start<end){
            if(!Character.isLetterOrDigit(s.charAt(start))){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(s.charAt(end))){
                end--;
                continue;
            }
            if(Character.toLowerCase(s.charAt(start))!=Character.toLowerCase(s.charAt(end))){
                return false;
            }
            else{
                start++;
                end--;
            }
        }
        return true;
    }
}
