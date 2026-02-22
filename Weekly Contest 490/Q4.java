class Solution {
    public long gcd(long a, long b){
        if(b==0) return a;
        return gcd(b, a%b);
    }
    HashMap<String, Integer> dp;
    public int solve(int[] nums, int i, long k, long nume, long deno){
        if(i>=nums.length){
            if(nume%deno==0 && nume/deno==k) return 1;
            return 0;
        }

        long g = gcd(nume, deno);
        nume = nume/g;
        deno = deno/g;
        
        String key = i + "," + nume + "," + deno;
        if(dp.containsKey(key)) return dp.get(key);

        int ways = 0;

        ways += solve(nums, i+1, k, nume*nums[i], deno);
        ways += solve(nums, i+1, k, nume, deno*nums[i]);
        ways += solve(nums, i+1, k, nume, deno);

        dp.put(key, ways);
        return ways;
    }
    public int countSequences(int[] nums, long k) {
        double val = 1.0;
        dp = new HashMap<>();
        return solve(nums, 0, k, 1, 1);
    }
}