class Solution {
    public int minimumCost(int[] nums, long k) {
        int n = nums.length;
        long MOD = 1000000007L;

        long org = k;
        long cost = 0;
        long curr = 0;
        for(int num : nums){
            if(num<=k){
                k = k - num;
            }else{
                long times = (num-k+org-1)/org;
                long last = times+curr; // cost for last increment

                long sumLast = ((last % MOD) * ((last + 1) % MOD) % MOD * 500000004L) % MOD;
                long sumCurr = ((curr % MOD) * ((curr + 1) % MOD) % MOD * 500000004L) % MOD;
                long sum = (sumLast - sumCurr + MOD) % MOD;
                
                // long sum = ((last*(last+1)/2)%MOD - ((curr*(curr+1)/2) %MOD)+MOD) % MOD; // sum upto times - sum upto curr
                cost += sum % MOD;
                k += org * times;
                k = k-num;

                curr = last;
            }
        }
        return (int)(cost%MOD);
    }
}