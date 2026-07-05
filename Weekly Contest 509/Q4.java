class Solution {
    Long[][] dp;
    public long[] solve(int[] nums, int i, int j, int broken){
        if(i>j) return new long[]{0, 0};
        if(i==j) return new long[]{nums[i], 0};

        // if(dp[i][j]!=null) return dp[i][j];

        long res = 0;
        if(broken==0){
            if(nums[i]==nums[j]){
                long[] a = solve(nums, i+1, j-1, 0);
                if(a[1]==0){
                    long ans = nums[i]+nums[j] + a[0];
                    res = Math.max(res, ans);
                }
            }else{
                long[] a = solve(nums, i+1, j, 1);
                if(a[1]==0){
                    res = Math.max(res, a[0]);
                }
                long[] b = solve(nums, i, j-1, 1);
                if(b[1]==0){
                    res = Math.max(res, b[0]);
                }
            }
        }else{ // start new
            long[] a = solve(nums, i+1, j, 0);
            if(a[1]==0){
                res = Math.max(res, a[0]);
            }
            long[] b = solve(nums, i, j-1, 0);
            if(b[1]==0){
                res = Math.max(res, b[0]);
            }
        }
        return new long[]{res, 0};
    }
    public long getSum(int[] nums) {
        dp = new Long[nums.length][nums.length];
        return solve(nums, 0, nums.length-1, 0)[0];
    }
}