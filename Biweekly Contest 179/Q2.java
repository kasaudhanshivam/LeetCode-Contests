class Q2 {
    public long solve(int n, int r){
        if(n==0){
            return r==0? 1 : 0;
        }

        long ways = 0;
        ways += solve(n-1, r-1);
        ways += solve(n-1, r);

        return ways;
    }
    public int countVisiblePeople(int n, int pos, int k) {
        int MOD = 1000000007;
        long ways = 0;
        for(int left=0; left<n; left++){ // choose from left
            for(int x=0; x<=k; x++){
                long l = solve(left, x);
                long r = solve(n-x-1, k-x+1);
                ways += ((long)l * r) % MOD;
            }
        }
        return (int)ways;
    }
}