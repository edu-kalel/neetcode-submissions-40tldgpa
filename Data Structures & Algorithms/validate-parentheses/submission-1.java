class Solution {
    public boolean isValid(String s) {
        HashMap<Character, Character> pairs = new HashMap<>();
        Stack<Character> stack = new Stack<>();
        pairs.put(')','(');
        pairs.put(']','[');
        pairs.put('}','{');

        for(char c : s.toCharArray()){
            if(!pairs.containsKey(c)){
                stack.push(c);
            }
            else{
                if(!stack.isEmpty() && stack.peek()==pairs.get(c)){
                    stack.pop();
                }
                else{
                    return false;
                }
            }
        }
        return stack.isEmpty();
    }
}
