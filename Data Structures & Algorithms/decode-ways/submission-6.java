class Solution {
    public int numDecodings(String s) {
        // if s.length==1 return 1
        int twoafter = 0;
        int oneafter = 1;
        int helper = 0;
        for(int i = s.length()-1 ; i >= 0 ; i--){
            // base case, its zero
            if(s.charAt(i)=='0'){
                helper = 0;
            }
            else{
                helper = oneafter;
                System.out.println(i);
                if( i + 1 < s.length() && (s.charAt(i)=='1' || s.charAt(i)=='2' && s.charAt(i+1)<'7')){
                    helper+= twoafter;
                }
            }
            twoafter = oneafter;
            oneafter = helper;
            helper = 0;
        }

        return oneafter;

    }
}
