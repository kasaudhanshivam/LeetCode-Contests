class Solution {
    public int[][] cyclicShift(int n, int[][] grid, int[] rowShift, int[] colShift) {
        int[][] copy = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                copy[i][j] = grid[i][j];
            }
        }
        
        for(int i=0; i<n; i++){
            int k = rowShift[i];

            for(int j=0; j<n; j++){
                grid[i][(j-k+n)%n] = copy[i][j];
            }
        }


        copy = new int[n][n];
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                copy[i][j] = grid[i][j];
            }
        }
        for(int j=0; j<n; j++){
            int k = colShift[j];

            for(int i=0; i<n; i++){
                grid[(i-k+n)%n][j] = copy[i][j];
            }
        }
        return grid;
    }
}