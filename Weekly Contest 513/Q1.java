class Solution {
    public long gcd(int m, int n){
        if(n%m==0) return m;
        return gcd(n%m, m);
    }
    public long maxPairStrength(int[] nums) {
        int n = nums.length;

        long max = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                long gc = gcd(Math.min(nums[i], nums[j]), Math.max(nums[i], nums[j]));
                long ans = ((long)nums[i]*nums[j])/(gc*gc);
                max = Math.max(max, ans); // update max
            }
        }
        return max;
    }
}