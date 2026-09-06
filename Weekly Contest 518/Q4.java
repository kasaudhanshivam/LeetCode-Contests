class Solution {
    // 1 = up, 2 = right, 3 = down, 4 = left, 0 = no dir
    int[][] dir = {{}, {-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    boolean flag = false;
    Integer[][][][] dp;
    public int solve(int[][] grid, int k, int i, int j, int prev){
        if(k<0) return Integer.MAX_VALUE;
        if(i==grid.length-1 && j==grid[0].length-1){
            flag = true;
            return grid[i][j];
        }


        if(dp[i][j][k][prev]!=null) return dp[i][j][k][prev];


        int res = Integer.MAX_VALUE;
        for(int d=1; d<=4; d++){
            int ni = i + dir[d][0];
            int nj = j + dir[d][1];

            if(0<=ni && ni<grid.length && 0<=nj && nj<grid[0].length){
                if(prev==0 || prev==d){ // same direction
                    int ans = solve(grid, k, ni, nj, d);
                    if(ans!=Integer.MAX_VALUE) res = Math.min(res, ans + grid[i][j]);
                }else{ // taking the turn
                    int ans = solve(grid, k-1, ni, nj, d);
                    if(ans!=Integer.MAX_VALUE) res = Math.min(res, ans + grid[i][j]);
                }
            }
        }
        return dp[i][j][k][prev] = res;
    }
    public int minCost(int[][] grid, int k) {
        dp = new Integer[grid.length][grid[0].length][k+1][5];
        int res = solve(grid, k, 0, 0, 0);
        return flag? res : -1;
    }
}
