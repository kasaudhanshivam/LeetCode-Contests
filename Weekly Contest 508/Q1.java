class Solution {
    public long maxSum(int[] nums, int k, int mul) {
        int n = nums.length;
        Integer[] arr = new Integer[n];
        for(int i=0; i<n; i++){
            arr[i] = nums[i];
        }
        Arrays.sort(arr, Collections.reverseOrder());
        long total = 0;

        int idx = -1;
        for(int i=0; i<k; i++){
            if(mul<=0){
                total += arr[i];
            }else{
                total += (arr[i] * (long)mul);
                mul--;
            }
        }
        return total;
    }
}