class Solution {
    boolean[][][] dp;
    int res;
    public void solve(int[][] grid, int i, int j, int xor){
        if(i==grid.length-1 && j==grid[0].length-1){
            xor = xor ^ grid[i][j];
            res = Math.min(res, xor);
            return;
        }
        if(i>=grid.length || j>=grid[0].length){
            return;
        }

        if(dp[i][j][xor]) return;
        dp[i][j][xor] = true;
        
        solve(grid, i, j+1, xor^grid[i][j]);
        solve(grid, i+1, j, xor^grid[i][j]);
    }
    public int minCost(int[][] grid) {
        res = Integer.MAX_VALUE;
        dp = new boolean[grid.length][grid[0].length][1024];
        solve(grid, 0, 0, 0);
        return res;
    }
}