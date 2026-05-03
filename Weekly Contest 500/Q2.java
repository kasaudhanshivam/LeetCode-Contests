class Solution {
    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public int sumOfPrimesInRange(int n) {
        int r = Integer.parseInt(new StringBuilder(n+"").reverse().toString());
        int max = Math.max(n, r);
        int min = Math.min(n, r);

        int sum = 0;
        for(int i=min; i<=max; i++){
            if(isPrime(i)) sum += i;
        }
        return sum;
    }
}