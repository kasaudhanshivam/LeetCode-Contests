class Solution {
    public int passwordStrength(String password) {
        HashSet<Character> set = new HashSet<>();
        for(char ch : password.toCharArray()){
            set.add(ch);
        }

        int score = 0;
        for(char ch : set){
            if('a'<=ch && ch<='z'){
                score += 1;
            }else if('A'<=ch && ch<='Z'){
                score += 2;
            }else if('0'<=ch && ch<='9'){
                score += 3;
            }else if(ch=='!' || ch=='@' || ch=='#' || ch=='$'){
                score += 5;
            }
        }
        return score;
    }
}