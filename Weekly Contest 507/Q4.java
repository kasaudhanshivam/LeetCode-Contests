class Solution {
    HashMap<String, Long> dp;
    public long solve(int[] val, int[] dec, int m, int i, int t){
        if(m==0) return 0;
        if(i>=val.length) return 0;

        String key = m+","+i+","+t;
        if(dp.containsKey(key)) return dp.get(key);
        // if(dp[m][i][t]!=null) return dp[m][i][t];
        
        long res = 0;
        long curr = val[i]-(long)dec[i]*(t-1);
        if(curr>0){
            res = Math.max(res, curr+solve(val, dec, m-1, i, t+1));
        }
        
        res = Math.max(res, solve(val, dec, m, i+1, 1));
        dp.put(key, res);
        // dp[m][i][t] = res;
        return res;
    }
    public int maxTotalValue(int[] value, int[] decay, int m) {
        // dp = new Long[m+1][decay.length][m+2];
        dp = new HashMap<>();
        long ans = solve(value, decay, m, 0, 1);
        return (int)(ans%1000000007);
    }
}