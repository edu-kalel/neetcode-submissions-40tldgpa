class Solution {
    public boolean isValid(String s) {
        // stack
        // deque arraydeque
        // loop through s
        // if opening, push
        // if closing and matches, pop
            // does not match? return false
        // loop finishes, stack empty? return true, else false
        Deque<Character> stack = new ArrayDeque<>();
        // Set<Character> open = new HashSet<>();
        // Set<Character> close = new HashSet<>();
        // open.add('{');
        // open.add('(');
        // open.add('[');
        // close.add(')');
        // close.add('}');
        // close.add(']');
        Map<Character, Character> pairs = new HashMap<>();
        pairs.put('}', '{');
        pairs.put(']', '[');
        pairs.put(')', '(');
        for(Character c : s.toCharArray()){
            if(pairs.containsValue(c)){
                stack.push(c);
            }
            else if(pairs.containsKey(c)){
                if(!pairs.get(c).equals(stack.peek())){
                    return false;
                }
                else{
                    stack.pop();
                }
            }
        }
        return stack.isEmpty() ? true : false;
    }
}
