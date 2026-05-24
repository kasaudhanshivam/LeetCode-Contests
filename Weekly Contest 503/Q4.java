class Solution {
    int[] st;
    int[] nums;
    public void build(int i, int l, int r){
        if(l==r){
            st[l] = nums[i];
            return;
        }

        int mid = l+(r-l)/2;
        build(2*i+1, l, mid);
        build(2*i+2, mid+1, r);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public int[] numberOfPairs(int[] nums1, int[] nums2, int[][] queries) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        st = new int[4*n2];
        build(0, 0, n2-1);
        
        int[] ans = new int[queries.length];
        for(int[] q : queries){
            if(q[0]==1){
                
            }else{
                
            }
        }
    }
}