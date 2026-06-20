class Solution {
    Long[][][] dp;
    public long solve(String s, int k, int i, int rest, int prev){
        if(i>=s.length()) return (prev!=10? 1 : 0);

        if(dp[i][rest][prev]!=null) return dp[i][rest][prev];

        long total = 0;

        int ub = Integer.parseInt(s.charAt(i)+"");
        for(int d=0; d<=((rest==1)? ub : 9); d++){
            if(rest==1){
                int diff = Math.abs(prev-d);
                if(prev==10 || diff<=k){
                    if(d==ub){
                        if(prev==10 && d==0){
                            total += solve(s, k, i+1, 1, prev);
                        }else{
                            total += solve(s, k, i+1, 1, d);
                        }
                    }else{
                        if(prev==10 && d==0){
                            total += solve(s, k, i+1, 0, prev);
                        }else{
                            total += solve(s, k, i+1, 0, d);
                        }
                    }
                }
            }else{
                int diff = Math.abs(prev-d);
                if(prev==10 || diff<=k){
                    if(prev==10 && d==0){
                        total += solve(s, k, i+1, 0, prev);
                    }else{
                        total += solve(s, k, i+1, 0, d);
                    }
                }
            }
        }
        return dp[i][rest][prev] = total;
    }
    public long goodIntegers(long l, long r, int k) {
        String right = r+"";
        dp = new Long[right.length()][2][11];
        long a = solve(right, k, 0, 1, 10);

        if(l==0) return a;
        String left = (l-1)+"";
        dp = new Long[left.length()][2][11];
        long b = solve(left, k, 0, 1, 10);

        return a-b;
    }
}