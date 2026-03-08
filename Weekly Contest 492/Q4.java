class Solution {
    long min;
    public void solve(int ones, int zeroes, int enc, int flat){
        
    }
    public long minCost(String s, int encCost, int flatCost) {
        int n = s.length();
        int ones = 0;
        int zeros = 0;

        for(int i=0; i<n; i++){
            if(s.charAt(i)=='0') ones++;
            else zeros++;
        }

        min = Long.MAX_VALUE;
        solve(ones, zeroes, encCost, flatCost);
        return min;
    }
}