class Solution {
    public int minQueenMoves(int[] source, int[] target) {
        if(source[0]==target[0] && source[1]==target[1]) return 0;
        int a = Math.abs(source[0]-target[0]);
        int b = Math.abs(source[1]-target[1]);

        if(a==0 && b!=0) return 1;
        if(a!=0 && b==0) return 1;
        if(a==b) return 1;
        return 2;
    }
}