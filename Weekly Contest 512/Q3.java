class Solution {
    int MOD = 1000000007;
    // Integer[][][] dp;
    HashMap<String, Integer> dp;
    public int solve(int len, int target, int i, int flag){
        if(i>=len){
            if(flag==1 && target==0) return 1;
            else return 0;
        }

        // if(dp[target][i][flag]!=null) return dp[target][i][flag];

        String key = target + "," + i + "," + flag;
        if(dp.containsKey(key)) return dp.get(key);

        long res = 0;
        for(int num=1; num<=target; num++){
            if(num%2==0){
                res = (res + solve(len, target-num, i+1, 1)) % MOD;
            }else{
                res = (res + solve(len, target-num, i+1, flag)) % MOD;
            }
        }

        dp.put(key, ((int)(res % MOD)));
        return (int)(res % MOD);
    }
    public int countValidSequences(int n, int k) {
        // dp = new Integer[n+1][k][2];
        dp = new HashMap<>();
        return solve(k, n, 0, 0);
    }
}