class Solution {
    // give even length, minimum subarray sum
    public long kadane(int[] nums){
        long min = 0;
        long sum = 0;
        for(int i=0; i<nums.length-1; i+=2){
            sum += nums[i];
            sum -= nums[i+1];
            if(sum>0){
                sum = 0;
            }
            min = Math.min(min, sum);
        }
        sum = 0;
        for(int i=1; i<nums.length-1; i+=2){
            sum -= nums[i];
            sum += nums[i+1];
            if(sum>0){
                sum = 0;
            }
            min = Math.min(min, sum);
        }
        return min;
    }
    public long maxValue(int[] nums) {
        int n = nums.length;
        long sum = 0;
        for(int i=0; i<n; i++){
            if((i&1)==0){
                sum += nums[i];
            }else{
                sum -= nums[i];
            }
        }
        return sum + (-2 * kadane(nums));
    }
}