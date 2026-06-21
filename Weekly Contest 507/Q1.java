class Solution {
    public int maxDistance(String moves) {
        int blank = 0;
        int x = 0;
        int y = 0;
        for(char ch : moves.toCharArray()){
            if(ch=='D'){
                x++;
            }else if(ch=='R'){
                y++;
            }else if(ch=='L'){
                y--;
            }else if(ch=='U'){
                x--;
            }else blank++;
        }
        return Math.abs(x)+Math.abs(y)+blank;
    }
}