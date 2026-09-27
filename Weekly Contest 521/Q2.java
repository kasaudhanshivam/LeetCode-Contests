class Solution {
    public int maxEqualAdjacentPairs(int[] nums) {
        int n = nums.length;
        int base = 0;
        for(int i=0; i<n-1; i++){
            if(nums[i]==nums[i+1]){
                base++;
            }
        }

        int max_freq = 0;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n-1; i++){
            if(nums[i]!=nums[i+1]){
                int min = Math.min(nums[i], nums[i+1]);
                int max = Math.max(nums[i], nums[i+1]);
                String key = min + "," + max;
                map.put(key, map.getOrDefault(key, 0)+1);
                max_freq = Math.max(max_freq, map.get(key));
            }
        }
        return base + max_freq;
    }
}