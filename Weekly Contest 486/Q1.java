class Solution {
    public int minimumPrefixLength(int[] nums) {
        int n = nums.length;
        int till = -1;
        for(int i=n-2; i>=0; i--){
            if(nums[i]>=nums[i+1]){
                till = i;
                break;
            }
        }
        return till+1;
    }
}