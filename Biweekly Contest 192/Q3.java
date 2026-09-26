class Solution {
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;
        int max = 0;

        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            int sum = 0;
            for(int j=i; j<n; j++){
                set.add(((2 * nums[j]) % k + k) % k);
                sum += nums[j];

                if(sum%k==0 || set.contains(((sum % k) + k) % k)){
                    max = Math.max(max, j-i+1);
                }
            }
        }
        return max;
    }
}