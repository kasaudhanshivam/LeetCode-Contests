class Solution {
    public int solve(int[][] grid, int r1, int c1, int r2, int c2){
        if(r1>=grid.length || c1>=grid[0].length || r2<0 || c2>=grid[0].length) return Integer.MIN_VALUE;
        if(r1==grid.length-1 && c1==grid[0].length-1 && r2==0 && c2==grid[0].length-1){
            return 0;
        }

        int res = 0;
        if(r1==r2 && c1==c2){
            res = grid[r1][c2];
        }

        int a = solve(grid, r1+1, c1, r2-1, c2);
        int b = solve(grid, r1+1, c1, r2, c2+1);
        int c = solve(grid, r1, c1+1, r2-1, c2);
        int d = solve(grid, r1, c1+1, r2, c2+1);

        int temp = a;
        temp = Math.max(temp, b);
        temp = Math.max(temp, c);
        temp = Math.max(temp, d);
        res += temp;
        return res;
    }
    public int maxScore(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        return solve(grid, 0, 0, m-1, 0);
    }
}