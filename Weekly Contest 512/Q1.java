class Solution {
    public int largestInteger(int n, int s) {
        if((n*9)<s) return -1;

        int num = 0;
        while(n>0){
            for(int d=Math.min(9, s); d>=0; d--){
                if(s>=d){
                    num = (num * 10) + d;
                    s -= d;
                    break;
                }
            }
            n--;
        }
        return num;
    }
}