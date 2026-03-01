class Solution {
    public int minCost(int n) {
        // Observe pattern by dry running examples
        return ((n*n)-n)/2; // n(n-1)/2
    }
}