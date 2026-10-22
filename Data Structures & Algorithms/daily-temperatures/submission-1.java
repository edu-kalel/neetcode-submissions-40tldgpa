class Solution {
    public int[] dailyTemperatures(int[] temperatures) {
        //result array
        int[] res = new int[temperatures.length];

        //monotonic stack, should (a, b) -> a-b
        Deque<int[]> stack = new ArrayDeque<>();

        for(int i = 0; i<temperatures.length ; i++){
            int temperature = temperatures[i];
            while(!stack.isEmpty() && temperature > stack.peek()[0]){
                //meaning, stack is not empty and the new temperature is bigger
                // than the one at the top
                int[] pair = stack.pop();
                res[pair[1]] = i - pair[1];
            }
            //now, either stack is empty or the current temp is not
            // bigger than the one at the top
            stack.push(new int[]{temperature, i});
        }
        return res;
    }
}
