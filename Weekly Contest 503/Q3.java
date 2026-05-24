class Solution {
    public int minOperations(int[] nums) {
        int n = nums.length;
        if(n==1) return 0;
        
        int zeroIdx = -1;
        int incBreak = 0; // total increasing order breaks
        int descBreak = 0; // total increasing order breaks

        for(int i = 0; i<n; i++){
            if(nums[i]==0){
                zeroIdx = i;
            }
            if(nums[i]<nums[(i+1)%n]){ // circular
                descBreak++;
            }
            if(nums[i]>nums[(i+1)%n]){ // circular
                incBreak++;
            }
        }

        int ans = Integer.MAX_VALUE;

        // Case 1 : Sorted in increasing order(circular)
        if(incBreak<=1){
            int op1 = zeroIdx; // left rotate
            int op2 = (zeroIdx==0? 0 : 1+(n-zeroIdx)+1); // reverse, rotate left, reverse
            ans = Math.min(ans, Math.min(op1, op2));
        }
        
        // Case 2 : Sorted in decreasing order(circular)
        if(descBreak<=1){
            int op1 = 1+(n-zeroIdx-1); // reverse, rotate left
            int op2 = zeroIdx+2; // rotate left, reverse
            ans = Math.min(ans, Math.min(op1, op2));
        }
        return ans==Integer.MAX_VALUE? -1 : ans;
    }
}