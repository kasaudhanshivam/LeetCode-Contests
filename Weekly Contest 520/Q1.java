class Solution {
    public int countIntersectingIntervals(int[][] intervals) {
        Arrays.sort(intervals, (a, b) -> {
            if(a[0]==b[0]) return a[1]-b[1];
            return a[0]-b[0];
        });
        int n = intervals.length;
        int count = 0;
        for(int i=0; i<n; i++){
            for(int j=i+1; j<n; j++){
                if(intervals[i][1]>=intervals[j][0]){
                    count++;
                }
            }
        }
        return count;
    }
}