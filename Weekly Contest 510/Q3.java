class Solution {
    // Counts total path in the grid recursively
    public int count(char[][] grid, int i, int j){
        if(grid[0][0]=='#' || grid[grid.length-1][grid[0].length-1]=='#') return 0;
        if(i==grid.length-1 && j==grid[0].length-1) return 1;

        int total = 0;
        if(i+1<grid.length && grid[i+1][j]=='.'){
            total += count(grid, i+1, j);
        }
        if(j+1<grid[0].length && grid[i][j+1]=='.'){
            total += count(grid, i, j+1);
        }

        return total;
    }
    public boolean solve(char[][] grid, int k, int i, int j){
        int m = grid.length;
        int n = grid[0].length;
        if(count(grid, 0, 0)==k){
            // we found a valid configuration
            return true;
        }
        if(i>=m) return false; // we are out of bound and still no found any such configuration of grid that satisfies pathCount = k.

        // moving to each cell one by one, like we do in for loops traversing a grid.
        // not down or right
        int nextR = (j==n-1)? i+1 : i; // next row
        int nextC = (j==n-1)? 0 : j+1; // next col

        if((i==0 && j==0) || (i==grid.length-1 && j==grid[0].length-1)){
            // never block the source and destination cell
            return solve(grid, k, nextR, nextC);
        }

        // Option-1 : Block this cell
        grid[i][j] = '#';
        if(count(grid, 0, 0)>=k){ // valid
            if(solve(grid, k, nextR, nextC)) return true;
        }
        // else => path is not enough, i.e lesser than k

        // Option-2 : Leave this cell
        grid[i][j] = '.'; // backtrack
        return solve(grid, k, nextR, nextC);
    }
    public String[] createGrid(int m, int n, int k) {
        char[][] grid = new char[m][n];
        for(int i=0; i<m; i++){
            Arrays.fill(grid[i], '.');
        }

        if(count(grid, 0, 0)<k) return new String[0]; // edge case
        
        solve(grid, k, 0, 0); // fill the grid

        // Buid the result
        String[] res = new String[m];
        for(int i=0; i<m; i++){
            String s = new String(grid[i]);
            res[i] = s;
        }
        return res;
    }
}