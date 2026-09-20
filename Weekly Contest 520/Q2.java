class Solution {
    public int binSearch(int[][] nums, int target){
        int l = 0;
        int r = nums.length-1;
        int ans = -1;
        while(l<=r){
            int mid = l+(r-l)/2;
            if(nums[mid][0]>target){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }
        return ans;
    }
    public long countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });

        long count = 0;
        
        int n = intervals.length;
        for(int i=0; i<n; i++){
            int idx = binSearch(intervals, intervals[i][1]);
            count += idx!=-1? (idx-1-i) : n-1-i;
        }
        return count;
    }
}