class Solution {
    HashSet<Integer> spIdx;
    Long[][][] dp;
    public long solve(String s, int idx, int tight, int prev){
        if(idx>=s.length()) return 1;

        if(dp[idx][tight][prev]!=null) return dp[idx][tight][prev];

        int ub = Integer.parseInt(s.charAt(idx)+"");
        long res = 0;
        for(int d=0; (tight==1? d<=ub : d<=9); d++){
            if(tight==1){
                if(d==ub){
                    if(spIdx.contains(idx)){
                        if(prev<=d){
                            res += solve(s, idx+1, 1, d);
                        }
                    }else{
                        res += solve(s, idx+1, 1, prev);
                    }
                }else{
                    if(spIdx.contains(idx)){
                        if(prev<=d){
                            res += solve(s, idx+1, 0, d);
                        }
                    }else{
                        res += solve(s, idx+1, 0, prev);
                    }
                }
            }else{
                if(spIdx.contains(idx)){
                    if(prev<=d){
                        res += solve(s, idx+1, 0, d);
                    }
                }else{
                    res += solve(s, idx+1, 0, prev);
                }
            }
        }
        return dp[idx][tight][prev] = res;
    }
    public long countGoodIntegersOnPath(long l, long r, String directions) {
        spIdx = new HashSet<>();
        int curr = 0;
        spIdx.add(curr);
        for(char ch : directions.toCharArray()){
            if(ch=='D'){
                curr += 4;
                spIdx.add(curr);
            }else{
                curr += 1;
                spIdx.add(curr);
            }
        }

        String high = r+"";
        while(high.length()<16){
            high = "0" + high;
        }

        dp = new Long[16][2][10];
        long a = solve(high, 0, 1, 0);
        if(l==0) return a;

        String low = (l-1)+"";
        while(low.length()<16){
            low = "0" + low;
        }

        dp = new Long[16][2][10];
        long b = solve(low, 0, 1, 0);
        
        return a-b;
    }
}