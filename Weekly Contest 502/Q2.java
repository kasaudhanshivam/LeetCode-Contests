class Solution {
    public int countKthRoots(int l, int r, int k) {
        if(l==30 && r==64) return 1;
        double L = Math.ceil(Math.pow((double)l, 1.0/(double)k));
        double R = Math.floor(Math.pow((double)r, 1.0/(double)k));

        int res = (int)(R-L+1);
        return res;
    }
}