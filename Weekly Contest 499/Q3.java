class Solution {
    public long minOperations(int[] nums) {
        int n = nums.length;
        long[] arr = new long[n];
        for(int i=0; i<n; i++) arr[i] = nums[i];

        long total = 0;
        for(int i=1; i<n; i++){
            arr[i] += total;
            if(arr[i-1]>arr[i]){
                long diff = arr[i-1]-arr[i];
                arr[i] += diff;
                total += diff;
            }
        }
        return total;
    }
}