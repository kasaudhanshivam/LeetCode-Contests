class Solution {
    public int solve(int[] nums, int i, int last, int prev, HashMap<String, Integer> dp){
        if(i>=nums.length) return 0;

        String key = i + "," + last + "," + prev;
        if(dp.containsKey(key)) return dp.get(key);
        
        int ans = Integer.MIN_VALUE;
        if(last==-1 || (prev<nums[i] && (last & nums[i])!=0)){ // valid
            int new_last = last==-1? nums[i] : (last&nums[i]);
            int take = 1 + solve(nums, i+1, new_last, nums[i], dp);
            int not_take = solve(nums, i+1, last, prev, dp);
            ans = Math.max(take, not_take);
        }else{ // take not possible
            ans = solve(nums, i+1, last, prev, dp);
        }
        dp.put(key, ans);
        return ans;
    }
    public int longestSubsequence(int[] nums) {
        HashMap<String, Integer> dp = new HashMap<>();
        int res = 0;
        res = solve(nums, 0, -1, 0, dp);
        return res;
    }
}