class Solution {
    public boolean isMono(long n){
        boolean isInc = true;
        boolean isDec = true;
        
        long temp = n;
        long prev = Long.MIN_VALUE;
        while(temp>0){
            long dig = temp%10;
            if(dig<=prev){
                isDec = false;
                break;
            }
            prev = dig;
            temp = temp/10;
        }

        temp = n;
        prev = Long.MAX_VALUE;
        while(temp>0){
            long dig = temp%10;
            if(dig>=prev){
                isInc = false;
                break;
            }
            prev = dig;
            temp = temp/10;
        }
        
        return isInc || isDec;
    }
    public boolean digSum(long n){
        long sum = 0;
        while(n>0){
            long dig = n%10;
            sum += dig;
            n = n/10;
        }
        return isMono(sum);
    }
    public long countFancy(long l, long r) {
        long count = 0;
        for(long i=l; i<=r; i++){
            if(isMono(i) || digSum(i)) count++;
        }
        return count;
    }
}