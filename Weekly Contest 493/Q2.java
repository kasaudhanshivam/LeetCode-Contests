class Solution {
    public long getComma(long n){
        String s = Long.toString(n);
        if(s.length()<4) return 0;

        return (long)(s.length()-1)/3;
    }
    public long countCommas(long n) {
        long count = 0;
        // long last = 0;
        // long prev = 0;
        for(long i=1000; i<=n; i++){
            long temp = getComma(i);
            count += temp;
        }

        // System.out.println(last);

        // for(long i=last; i<=n; i++){
        //     count += getComma(i);
        // }


        // while(n>0){
        //     long num = n%1000;
        //     count += num;
        //     n = n/1000;
        // }
        
        return count;
    }
}