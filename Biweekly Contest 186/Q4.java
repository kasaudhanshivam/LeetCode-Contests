class Solution {
    int[][][][][] dp;
    int MOD = 1000000007;
    public int solve(String s1, String s2, String target, int i, int j, int k, int taken1, int taken2){
        if(k==target.length()) return (taken1!=0 && taken2!=0)? 1 : 0;

        if(dp[i][j][k][taken1][taken2]!=-1) return dp[i][j][k][taken1][taken2];
        
        int req = target.charAt(k);
        long ways = 0;
        for(int ni=i; ni<s1.length(); ni++){
            if(s1.charAt(ni)==req){
                ways += solve(s1, s2, target, ni+1, j, k+1, 1, taken2); // pick
            }
        }

        for(int nj=j; nj<s2.length(); nj++){
            if(s2.charAt(nj)==req){
                ways += solve(s1, s2, target, i, nj+1, k+1, taken1, 1); // pick
            }
        }

        return dp[i][j][k][taken1][taken2] = (int)(ways % MOD);
    }
    public int interleaveCharacters(String word1, String word2, String target) {
        dp = new int[word1.length()+1][word2.length()+1][target.length()][2][2];
        for(int[][][][] a : dp){
            for(int[][][] b : a){
                for(int[][] c : b){
                    for(int[] d : c){
                        Arrays.fill(d, -1);
                    }
                }
            }
        }
        return solve(word1, word2, target, 0, 0, 0, 0, 0);
    }
}