class Solution {
    // Long[][][] dp;
    HashMap<String, Long> dp;
    public long solve(int[] nums, int k, int i, int prev, int greater){
        if(i>=nums.length) return 0;

        // if(dp[i][prev][greater]!=null) return dp[i][prev][greater];
        String key = i+","+prev+","+greater;
        if(dp.containsKey(key)) return dp.get(key);

        long res = 0;
        if(greater==1){
            if(nums[i]>prev){
                long take = nums[i] + solve(nums, k, i+k, nums[i], 0);
                res = Math.max(res, take);
            }
        }else{
            if(nums[i]<prev){
                long take = nums[i] + solve(nums, k, i+k, nums[i], 1);
                res = Math.max(res, take);
            }
        }

        long skip = solve(nums, k, i+1, prev, greater);
        res = Math.max(res, skip);

        dp.put(key, res);
        // dp[i][prev][greater] = res;
        return res;
    }
    public long maxAlternatingSum(int[] nums, int k) {

        // int max = 0;
        // for(int num : nums) max = Math.max(max, num);
        
        // dp = new Long[nums.length][max+2][2];
        dp = new HashMap<>();
        long a = solve(nums, k, 0, 0, 1); // start from nums[i]<nums[i+1]
        
        // dp = new Long[nums.length][max+2][2];
        dp = new HashMap<>();
        long b = solve(nums, k, 0, Integer.MAX_VALUE, 0); // start from nums[i]>nums[i+1]
        return Math.max(a, b);
    }
}