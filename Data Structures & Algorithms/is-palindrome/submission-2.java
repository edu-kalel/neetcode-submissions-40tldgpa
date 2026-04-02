class Solution {
    public boolean isPalindrome(String s) {
        int start = 0;
        int end = s.length()-1;

        while(start<end){
            char charStart = s.charAt(start);
            char charEnd = s.charAt(end);

            if(!Character.isLetterOrDigit(charStart)){
                start++;
                continue;
            }
            if(!Character.isLetterOrDigit(charEnd)){
                end--;
                continue;
            }
            if(Character.toLowerCase(charStart)!=Character.toLowerCase(charEnd)){
                return false;
            }
            start++;
            end--;
        }
        return true;
    }
}
