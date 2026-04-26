class Solution {
    public int compareBitonicSums(int[] nums) {
        int n = nums.length;
        long prefSum = nums[0]; // sum upto peak from front
        int peak = 0;
        for(int i=1; i<n; i++){
            if(nums[i-1]<nums[i]){
                prefSum += nums[i];
            }else{
                peak = i-1;
                break;
            }
        }
        long suffSum = nums[n-1];
        for(int i=n-2; i>=peak; i--){ // sum upto peak from back
            suffSum += nums[i];
        }

        if(prefSum==suffSum) return -1;
        else if(prefSum>suffSum) return 0;
        return 1;
    }
}