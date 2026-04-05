class Solution {
    Long[][] dp;
    public long solve(int i,int[] nums, int target){
        if(target<0) return Long.MAX_VALUE;
        if(i>=nums.length){
            return target!=0? Long.MAX_VALUE/2 : 0;
        }

        if(dp[i][target]!=null) return dp[i][target];
        long take = Long.MAX_VALUE;
        if(i>0 && i<nums.length-1){
            long max = Math.max(nums[i-1],nums[i+1]);
            long next = solve(i+2, nums, target-1);
            if(max>=nums[i]){
                if(next!=Integer.MAX_VALUE){
                    take = max-nums[i]+1 + next;
                }
            }
            if(max<nums[i]){
                take = 0 + next;
            }
        }
        long skip = solve(i+1,nums, target);
        return dp[i][target] = Math.min(take,skip);
    }
    public long minIncrease(int[] nums) {
        int max_ach = (nums.length-1)/2;
        dp = new Long[nums.length][max_ach+1];
        return solve(0,nums, max_ach);
    }
}