class Solution {
    public int minimumIndex(int[] capacity, int itemSize) {
        int minCap = Integer.MAX_VALUE;
        int idx = -1; 
        for(int i=0; i<capacity.length; i++){
            if(capacity[i]>=itemSize){
                if(minCap>capacity[i]){
                    idx = i;
                    minCap = capacity[i];
                }
            }
        }
        return idx;
    }
}