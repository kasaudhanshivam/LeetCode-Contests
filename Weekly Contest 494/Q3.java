class Solution {
    // Integer[][] dp;
    HashMap<String, Integer> dp;
    public int solve(int[] nums, int target, int i, int xor){
        if(i==nums.length){
            return xor==target? 0 : Integer.MIN_VALUE;
        }

        // if(dp[i][xor]!=null) return dp[i][xor];
        String key = i + "," + xor;
        if(dp.containsKey(key)) return dp.get(key);

        int take = 1 + solve(nums, target, i+1, xor^nums[i]);
        int skip = solve(nums, target, i+1, xor);
        int ans = Math.max(take, skip);
        dp.put(key, ans);
        return ans;
    }
    public int minRemovals(int[] nums, int target) {
        int n = nums.length;
        // dp = new Integer[n][target+1];
        dp = new HashMap<>();
        int maxLen = solve(nums, target, 0, 0);
        if(maxLen<0) return -1;
        return n-maxLen; // removals required
    }
}