class Solution {
    long[] st;
    int[] nums;
    public void build(int i, int l, int r){
        if(l==r){
            if(l-1>=0 && l+1<nums.length && nums[l-1]<nums[l] && nums[l+1]<nums[l]){
                st[i] = 1;
            }else{
                st[i] = 0;
            }
            return;
        }
        int mid = l+(r-l)/2;
        build(2*i+1, l, mid);
        build(2*i+2, mid+1, r);
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public void update(int i, int l, int r, int idx){
        if(l==r){
            if(l-1>=0 && l+1<nums.length && nums[l-1]<nums[l] && nums[l+1]<nums[l]){
                st[i] = 1;
            }else{
                st[i] = 0;
            }
            return;
        }
        int mid = l+(r-l)/2;
        if(idx<=mid){
            update(2*i+1, l, mid, idx);
        }else{
            update(2*i+2, mid+1, r, idx);
        }
        st[i] = st[2*i+1] + st[2*i+2];
    }
    public long query(int i, int L, int R, int l, int r){
        if(l<=L && R<=r) return st[i]; // complete overlapping
        if(r<L || R<l) return 0; // no overlapping

        int mid = L+(R-L)/2;
        long left = query(2*i+1, L, mid, l, r);
        long right = query(2*i+2, mid+1, R, l, r);
        return left+right;
    }
    public long[] countOfPeaks(int[] nums, int[][] queries) {
        int n = nums.length;
        st = new long[4*n];
        this.nums = nums;

        build(0, 0, n-1); // i, l, r

        List<Long> list = new ArrayList<>();
        for(int[] q : queries){
            int type = q[0];
            if(type==1){
                int l = q[1]+1;
                int r = q[2]-1;
                if(l>r) {
                    list.add(0L);
                    continue;
                }
                long res = query(0, 0, n-1, l, r);
                list.add(res);
            }else{
                int idx = q[1];
                int val = q[2];
                nums[idx] = val;
                update(0, 0, n-1, idx);
                // qki idx k update hone se bas uske ngbrs par frq padega
                if(idx-1>=0) update(0, 0, n-1, idx-1);
                if(idx+1<nums.length) update(0, 0, n-1, idx+1);
            }
        }
        long[] ans = new long[list.size()];
        for(int i=0; i<list.size(); i++){
            ans[i] = list.get(i);
        }
        return ans;
    }
}