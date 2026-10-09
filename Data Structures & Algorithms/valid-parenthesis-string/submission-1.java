class Solution {
    public boolean checkValidString(String s) {
        Deque<Integer> left = new ArrayDeque<>();
        Deque<Integer> asterix = new ArrayDeque<>();
        for(int i = 0 ; i<s.length() ; i++){
            if(s.charAt(i) == '('){
                left.push(i);
            }
            else if(s.charAt(i)=='*'){
                asterix.push(i);
            }
            else{ // ')'
                if(!left.isEmpty()){
                    left.pop();
                }
                else{
                    if(!asterix.isEmpty()){
                        asterix.pop();
                    }
                    else{
                        return false;
                    }
                }
            }
        }

        while(!left.isEmpty()){
            if(asterix.isEmpty()){
                return false;
            }
            if(left.pop()>asterix.pop()){
                return false;
            }
        }

        return true;
    }
}
