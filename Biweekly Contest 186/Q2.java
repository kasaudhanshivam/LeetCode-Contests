class Solution {
    public int maxValidPairSum(int[] nums, int k) {
        int n = nums.length;
        int[] max = new int[n];
        max[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            max[i] = Math.max(max[i+1], nums[i]);
        }

        int res = 0;
        for(int i=0; i<n-k; i++){
            int curr = nums[i]+max[i+k];
            res = Math.max(res, curr);
        }
        return res;
    }
}