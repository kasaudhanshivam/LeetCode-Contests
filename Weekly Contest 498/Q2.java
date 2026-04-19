class Solution {
    public int firstStableIndex(int[] nums, int k) {
        int n = nums.length;
        long[] suffSmall = new long[n];
        suffSmall[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            suffSmall[i] = Math.min(suffSmall[i+1], nums[i]);
        }

        long max = nums[0];
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            long min = suffSmall[i];
            if((max-min) <= k) return i;
        }
        
        return -1;
    }
}