class Solution {
    int result;
    public int countSubstrings(String s) {
        result = 0;
        for(int i = 0; i<s.length() ; i++){
            countPali(i, i, s);
            countPali(i, i+1, s);
        }
        return result;
    }
    void countPali(int il, int ir, String s){
        int l=il;
        int r=ir;
        while(l>=0 && r<s.length() && s.charAt(l)==s.charAt(r)){
            l--;
            r++;
            result++;
        }
    }
}
