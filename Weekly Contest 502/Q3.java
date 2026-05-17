class Solution {
    public boolean isMax(int[][] mat, int row, int col){
        int pad = mat[row][col];
        for(int i=Math.max(0, row-pad); i<=Math.min(mat.length-1, row+pad); i++){
            for(int j=Math.max(0, col-pad); j<=Math.min(mat[0].length-1, col+pad); j++){
                if(Math.abs(i-row)==Math.abs(j-col) && Math.abs(i-row)==pad) continue;
                if(mat[i][j]>pad) return false;
            }
        }
        return true;
    }
    public int countLocalMaximums(int[][] matrix) {
        int n = matrix.length;
        int m = matrix[0].length;
        int total = 0;
        for(int i=0; i<n; i++){
            for(int j=0; j<m; j++){
                if(matrix[i][j]==0) continue;
                if(isMax(matrix, i, j)){
                    total++;
                }
            }
        }
        return total;
    }
}