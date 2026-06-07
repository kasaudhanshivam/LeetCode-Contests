class Solution {
    // Long[][][][] dp;
    HashMap<Long, Long> dp;
    public long solve(int[] nums, int m, int l, int r, int i, int st, int taken){
        if(m<0) return (long)-1e15;
        if(i==nums.length){
            if(st!=-1){
                return (i-st>=l && m>=1 && taken==1)? 0 : (long)-1e15;
            }
            return taken==1? 0 : (long)-1e15;
        }

        int stIdx = st+1;

        long key = ((long) i << 22) | ((long) stIdx << 12) | ((long) m << 2) | taken;
        // String key = i+","+st+","+taken+","+m;
        // if(dp[i][stIdx][taken][m]!=null) return dp[i][stIdx][taken][m];
        if(dp.containsKey(key)) return dp.get(key);

        long res = (long)-1e15;

        if(st==-1){
            long a = nums[i] + solve(nums, m, l, r, i+1, i, 1);
            res = Math.max(res, a);

            long b = solve(nums, m, l, r, i+1, st, taken);
            res = Math.max(res, b);

            dp.put(key, res);
            return res;
        }
        
        // when we cant extend the subarray
        if(i-st==r){
            long a = solve(nums, m-1, l, r, i, -1, taken);
            res = Math.max(res, a);
        }else{

            
            // when we cant take this size subarray
            if(i-st<l){
                long b = nums[i] + solve(nums, m, l, r, i+1, st, taken);
                res = Math.max(res, b);
            }else{
                // freedom
                long c = nums[i] + solve(nums, m, l, r, i+1, st, taken); // take
                res = Math.max(res, c);
                
                long d = solve(nums, m-1, l, r, i, -1, taken); // skip
                res = Math.max(res, d);
            }

            
        }

        // dp[i][stIdx][taken][m] = res;
        dp.put(key, res);
        return res;
    }
    public long maximumSum(int[] nums, int m, int l, int r) {
        int n = nums.length;
        // dp = new Long[n][n+1][2][m+1];
        dp = new HashMap<>();
        return solve(nums, m, l, r, 0, -1, 0);
    }
}