class Solution {
    public int[] minCost(int[] nums, int[][] queries) {
        int[] res = new int[queries.length];

        int n = nums.length;
        int[] pref = new int[n];
        pref[0] = 0;
        for(int i=1; i<n; i++){
            int nextCost = 0;
            if(i==1){
                nextCost = 1;
            }else if(i-2>=0 && Math.abs(nums[i-1]-nums[i])<Math.abs(nums[i-2]-nums[i-1])){
                nextCost = 1;
            }else{
                nextCost = Math.abs(nums[i-1]-nums[i]);
            }
            pref[i] = pref[i-1] + nextCost;
        }
        
        int[] suff = new int[n];
        suff[n-1] = 0;
        for(int i=n-2; i>=0; i--){
            int nextCost = 0;
            if(i==n-2){
                nextCost = 1;
            }else if(i+2<n && Math.abs(nums[i+1]-nums[i])<=Math.abs(nums[i+2]-nums[i+1])){
                nextCost = 1;
            }else{
                nextCost = Math.abs(nums[i+1]-nums[i]);
            }
            suff[i] = suff[i+1] + nextCost;
        }


        for(int i=0; i<queries.length; i++){
            int[] q = queries[i];
            int l = q[0];
            int r = q[1];
            if(l==r) res[i] = 0;
            else if(l<r){
                res[i] = pref[r]-pref[l];
            }else{
                res[i] = suff[r]-suff[l];
            }
        }
        return res;
    }
}