class Solution {
    public int gcd(int n, int m){
        if(m>n) return gcd(m, n);
        if(m==0) return n;
        return gcd(m, n%m);
    }
    public long gcdSum(int[] nums) {
        int n = nums.length;
        int[] prefGcd = new int[n];

        int max = nums[0];
        for(int i=0; i<n; i++){
            max = Math.max(max, nums[i]);
            prefGcd[i] = gcd(nums[i], max);
        }


        Arrays.sort(prefGcd);
        // for(int i=0; i<n; i++){
        //     System.out.print(prefGcd[i] + " ");
        // }

        long ans = 0;
        int l = 0;
        int r = n-1;
        while(l<r){
            int temp = gcd(prefGcd[l], prefGcd[r]);
            ans += temp;
            System.out.println(nums[l] + " " + nums[r] + " "+ temp);
            l++;
            r--;
        }

        return ans;
    }
}