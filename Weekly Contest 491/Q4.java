class Solution {
    public long countSubarrays(int[] nums, int k, int m) {
        long count = 0;
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        int good = 0; // number of freq >= m
        int l=0;
        int r=0;
        long prefix=0;
        while(r<n){
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);
            if(map.get(nums[r])==m) good++;
            
            while(map.size()>k){
                if(map.get(nums[l])== m) good--;
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0) map.remove(nums[l]);
                l++;
                prefix = 0;
            }
            if(good==k && map.size()==k){
                count++;
                while(map.get(nums[l]) > m) {
                    map.put(nums[l], map.get(nums[l])-1);
                    l++;
                    prefix++;
                }
                count += prefix;
            }
            r++;
        }
        return count;
    }
}