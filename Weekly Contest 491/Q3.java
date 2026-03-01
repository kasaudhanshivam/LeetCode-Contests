class Solution {
    int min;
    HashSet<String> dp;
    public void solve(int[][] grid, int row, int curr){
        if(row>=grid.length){
            min = Math.min(min, curr);
            return;
        }

        if(curr>=min) return;
        String key = row + "," + curr;
        if(dp.contains(key)) return;
        dp.add(key);

        for(int j=0; j<grid[row].length; j++){
            solve(grid, row+1, (curr | grid[row][j]));
        }
        
    }
    public int minimumOR(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;
        min = Integer.MAX_VALUE;
        dp = new HashSet<>();
        solve(grid, 0, 0);
        return min;
    }
}