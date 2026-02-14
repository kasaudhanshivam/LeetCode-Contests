class Solution {
    Long[] dp;
    public long solve(int[] nums, int[] colors, int i){
        if(i>=nums.length){
            return 0;
        }

        if(dp[i]!=null) return dp[i];

        long ans;
        long a;
        if(i==nums.length-1 || colors[i+1]==colors[i]){
            a = nums[i] + solve(nums, colors, i+2);
        }else{
            a = nums[i] + solve(nums, colors, i+1);
        }
        long b = solve(nums, colors, i+1);
        ans = Math.max(a, b);

        return dp[i] = ans;
    }
    public long rob(int[] nums, int[] colors) {
        int max = Integer.MIN_VALUE;
        for(int a : colors){
            max = Math.max(max, a);
        }
        dp = new Long[nums.length];
        return solve(nums, colors, 0);
    }
}