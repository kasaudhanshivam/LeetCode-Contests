class Solution {
    public int getScore(String s){
        int score = 0;
        for(int i=1; i<s.length(); i++){
            if(s.charAt(i-1)==s.charAt(i)){
                score++;
            }
        }
        return score;
    }
    public int countRotations(String s, int k) {
        StringBuilder sb = new StringBuilder(s);

        int count = 0;
        if(getScore(s)==k) count++;
        for(int i=0; i<s.length()-1; i++){

            sb.append(sb.charAt(0));
            sb.deleteCharAt(0);

            int score = getScore(sb.toString());
            if(score==k) count++;
            
        }
        return count;
    }
}