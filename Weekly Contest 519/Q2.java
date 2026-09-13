class Solution {
    public long buildPalin(long left, boolean evenLen){
        long res = left;
        if(!evenLen){
            left /= 10;
        }

        while(left>0){
            res = res * 10 + (left % 10);
            left /= 10;
        }
        return res;
    }
    public long minOperations(int[] nums) {
        long res = 0;
        for(int num : nums){
            int orig = num;
            String s = num+"";
            int len = s.length();
            int mid = (s.length()+1)/2;
            int pref = Integer.parseInt(s.substring(0, mid));
            
            long ans = Long.MAX_VALUE;
            List<Long> cands = new ArrayList<>();

            for(int i=-2; i<=2; i++){
                if(pref+i>0){
                    cands.add(buildPalin(pref+i, len%2==0));
                }
            }

            if(len>1){
                long p = (long)Math.pow(10, len/2)-1;
                for(long i=0; i<=2; i++){
                    if(p-i>0){
                        cands.add(buildPalin(p-i, (len-1)%2==0));
                    }
                }
            }

            long pLarger = (long)Math.pow(10, (len+1+1)/2-1);
            for(long i=0; i<=2; i++){
                cands.add(buildPalin(pLarger + i, (len + 1) % 2 == 0));
            }


            for(long cand : cands){
                if (cand > 0 && (cand % 2) == (num % 2)) {
                    ans = Math.min(ans, Math.abs((long)num - cand) / 2);
                }
            }

            res += ans;
            
            
        }
        return res;
    }
}