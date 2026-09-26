class Solution {
    public boolean canTransform(int[] source, int[] target) {
        long sumA = 0;
        for(int num : source) sumA += num;
        long sumB = 0;
        for(int num : target) sumB += num;
        return sumA==sumB;
    }
}