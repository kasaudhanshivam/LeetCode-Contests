class Solution {
    int MOD = 1000000007;
    int sum;
    public void solve(int l, int r, int k, long curr){
        if(k==0){
            sum = ((int)(sum + curr))%MOD;
            return;
        }
        
        for(int j=l; j<=r; j++){
            long next = ((curr*10)+j) % MOD;
            solve(l, r, k-1, next);
        }
    }
    public int sumOfNumbers(int l, int r, int k) {
        sum = 0;
        solve(l, r, k, 0);
        return sum;
    }
}