class Solution {
    public long operations(int[] nums, long k){
        long op = 0;
        for(int i=0; i<nums.length; i++){
            op += (nums[i] + k - 1) / k;
        }
        return op;
    }
    public int minimumK(int[] nums) {
        int n = nums.length;

        for(int i=1; i<100000; i++){
            long allowed = i * i;
            if(operations(nums, i)<=allowed){
                return i;
            }
        }
        return -1;
    }
}