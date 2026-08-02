class Solution {
    public int binarySearch(long[] pref, long target){
        int l = 0;
        int r = pref.length-1;
        int ans = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(pref[mid]<=target){
                ans = mid;
                l = mid+1;
            }else{
                r = mid-1;
            }
        }
        return ans;
    }
    public int[] countTasks(int[] tasks, int[] shifts) {
        int n = shifts.length;
        int m = tasks.length;
        
        long[] pref = new long[m];
        pref[0] = tasks[0];
        for(int i=1; i<m; i++){
            pref[i] = pref[i-1] + tasks[i];
        }

        int[] ans = new int[n];
        long currWork = 0;
        for(int i=0; i<n; i++){
            long time = currWork + shifts[i];
            int idx = binarySearch(pref, time);
            if(idx>=m-1) currWork=0;
            else currWork = time;
            int rem = m-idx-1;
            ans[i] = rem;
        }
        return ans;
    }
}