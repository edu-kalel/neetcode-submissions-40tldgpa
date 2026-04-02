class Solution {
    public int characterReplacement(String s, int k) {
        HashMap<Character, Integer> count = new HashMap<>();
        int solution=0;
        int start = 0;
        int mostFrequent=0;
        for(int end = 0; end<s.length(); end ++){
            count.put(s.charAt(end), count.getOrDefault(s.charAt(end), 0)+1);
            mostFrequent = Math.max(mostFrequent, count.get(s.charAt(end)));

            while((end-start+1)-mostFrequent > k){
                count.put(s.charAt(start), count.get(s.charAt(start))-1);
                start++;
            }

            solution = Math.max(solution, end-start+1);
        }
        return solution;
    }
}
