class Solution {

    public String encode(List<String> strs) {
        StringBuilder sb = new StringBuilder();
        for(String str : strs){
            sb.append(str.length());
            sb.append("#");
            sb.append(str);
        }
        return sb.toString();
    }

    public List<String> decode(String str) {
        List<String> result = new ArrayList<>();
        // iterate str
        // if number, parse number until #
        // substring from i to j
        // add to list
        int i = 0;
        while(i<str.length()){
            int j = i;
            // if(Character.isDigit(str.charAt(i))){
            while(str.charAt(j)!='#'){
                j++;
            }
            int length = Integer.parseInt(str.substring(i, j));
            result.add(str.substring(j+1, j+1+length));
            // }
            i = j+1+length;
        }
        return result;
    }
}
