class Solution {
    // Integer[][][] dp;
    HashMap<Long, Integer> dp;
    int[] facCount;
    public int solve(int[][] items, int k, int i, int copies){
        if(k<0) return -999999;
        if(i>=items.length) return 0;

        // if(dp[i][k][copies]!=null) return dp[i][k][copies];
        // String key = i+","+k+","+copies;

        long key = ((long) i << 47) | ((long) k << 17) | (long) copies;
        if(dp.containsKey(key)) return dp.get(key);

        int take = -999999;
        int skip = solve(items, k, i+1, 0);
        if(copies<facCount[i]){
            take = 1 + 1 + solve(items, k-items[i][1], i, copies+1);
        }else{
            for(int b=1; b*items[i][1]<=k; b++){
                take = Math.max(take, b+solve(items, k-(b*items[i][1]), i+1, 0));
            }
        }
        int res = Math.max(take, skip);

        dp.put(key, res);
        return res;
    }
    public int maximumSaleItems(int[][] items, int budget) {
        Arrays.sort(items, (a, b) -> a[1]-b[1]);
        int minP = Integer.MAX_VALUE;
        facCount = new int[items.length];
        for(int i=0; i<items.length; i++){
            minP = Math.min(minP, items[i][1]);
            for(int j=0; j<items.length; j++){
                if(i!=j && items[j][0] % items[i][0] == 0){
                    facCount[i]++;
                }
            }
        }

        int maxCopies = (budget/minP) + 1;
        // dp = new Integer[items.length][budget+1][maxCopies];
        dp = new HashMap<>();
        return solve(items, budget, 0, 0);
    }
}