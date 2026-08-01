class Solution {
    public boolean check(int[] monsters, long[] bonus, long ans){
        for(int i=0; i<monsters.length; i++){
            if(ans + bonus[i]<monsters[i]){
                return false;
            }
            ans = ans - monsters[i];
            if(ans<0) ans = 0;
        }
        return true;
    }
    public long minInitialStrength(int[] monsters, int[][] boosts) {

        long[] bonus = new long[monsters.length+1];
        for(int[] b : boosts){
            bonus[b[0]] += b[2];
            bonus[b[1]+1] -= b[2];
        }
        for(int i=1; i<monsters.length; i++){
            bonus[i] += bonus[i-1];
        }

        long l = 0;
        long r = 0;
        for(int num : monsters){
            r += num;
        }

        long ans = l;
        while(l<=r){
            long mid = l+(r-l)/2;
            if(check(monsters, bonus, mid)){
                ans = mid;
                r = mid-1;
            }else{
                l = mid+1;
            }
        }

        return ans;
    }
}