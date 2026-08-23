class Solution {
    public boolean isPrime(int n){
        if(n<=1) return false;
        for(int i=2; i*i<=n; i++){
            if(n%i==0) return false;
        }
        return true;
    }
    public List<Integer> getFactors(int n){
        List<Integer> list = new ArrayList<>();
        for(int i=2; i*i<=n; i++){
            if(isPrime(i)){
                if(n%i==0){
                    list.add(i);
                    while(n%i==0){
                        n/=i;
                    }
                }
            }
        }
        if(n>1) list.add(n);
        return list;
    }
    public int longestSubarray(int[] nums, int k) {
        int n = nums.length;

        @SuppressWarnings("unchecked")
        HashSet<Integer>[] prime_fac = new HashSet[n];

        for(int i=0; i<n; i++){
            List<Integer> factors = getFactors(nums[i]);

            HashSet<Integer> set = new HashSet<>();
            for(int fac : factors){
                set.add(fac);
            }
            prime_fac[i] = set;
        }

        int maxLen = 0;
        HashMap<Integer, Integer> prime_set = new HashMap<>();
        int l = 0;
        for(int r=0; r<n; r++){

            for(int f : prime_fac[r]){
                prime_set.put(f, prime_set.getOrDefault(f, 0)+1);
            }

            if(prime_set.size()>k){ // shrink
                while(prime_set.size()>k){
                    for(int f : prime_fac[l]){
                        prime_set.put(f, prime_set.get(f)-1);
                        if(prime_set.get(f)==0) prime_set.remove(f);
                    }
                    l++;
                }
            }
            
            int currLen = r-l+1;
            maxLen = Math.max(maxLen, currLen);
        }
        return maxLen;
    }
}