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
        // traverse str ; i;
        // j = i
        // encounter a number, j until # ; j == #
        // number is [i -> j];
        // i = j+1;
        // j = i + numero
        // string is [i -> j];
        // add string
        // i = j
        // return list
        int i = 0;
        while(i<str.length()){
            int j = i;
            while(str.charAt(j)!='#'){
                j++;
            }
            int number = Integer.parseInt(str.substring(i,j));
            i = j+1;
            j = i+number;
            result.add(str.substring(i,j));
            i = j;
        }
        return result;
    }
}
