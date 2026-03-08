class Solution {
    public int smallestBalancedIndex(int[] nums) {
        int n = nums.length;
        long possibleSum = 0;
        for(int num : nums){
            possibleSum += num;
        }
        
        long[] suffProd = new long[n];

        suffProd[n-1] = nums[n-1];
        for(int i=n-2; i>=0; i--){
            suffProd[i] = (long)nums[i]*suffProd[i+1];
            if(suffProd[i]>possibleSum){
                suffProd[i] = -1;
            }
        }

        long prefSum = 0;
        for(int i=0; i<n; i++){
            long rightProd = (i==n-1)? 1 : suffProd[i+1];
            if(prefSum==rightProd){
                return i;
            }
            prefSum += nums[i];
        }
        return -1;
    }
}