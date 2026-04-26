class Solution {
    public boolean validDigit(int n, int x) {
        boolean flag = false;
        while(n>0){
            int d = n%10;
            if(n/10==0 && d==x) return false; // first digit
            if(d==x) flag = true;
            n = n/10;
        }
        return flag;
    }
}