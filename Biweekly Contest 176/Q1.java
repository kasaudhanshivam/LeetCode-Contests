class Solution {
    public String mapWordWeights(String[] words, int[] weights) {
        String res = "";

        for(String word : words){
            int sum = 0;
            for(char ch : word.toCharArray()){
                sum += weights[ch-'a'];
            }
            sum = sum%26;
            char wt = (char)('z' - sum); // to map according to ques
            res += wt;
        }
        return res;
    }
}