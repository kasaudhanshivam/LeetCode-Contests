class Solution {
    public int minimumSwaps(int[] nums) {
        int n = nums.length;
        int i=0; // pointer at zero
        while(i<n && nums[i]!=0){
            i++;
        }
        int j=n-1; // pointer at non-zero
        while(j>i && nums[j]==0){
            j--;
        }

        int op = 0;
        while(i<n && j>i){
            // swap
            op++;
            int temp = nums[i];
            nums[i] = nums[j];
            nums[j] = temp;

            while(i<n && nums[i]!=0){
                i++;
            }
            while(j>i && nums[j]==0){
                j--;
            }
        }
        return op;
    }
}