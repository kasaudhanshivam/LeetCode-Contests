class Solution {
    public int maxXor(int[] nums, int k) {
        int max = 0;
        int n = nums.length;
        int[] prefXor = new int[n];
        prefXor[0] = nums[0];
        for(int i=1; i<n; i++){
            prefXor[i] = prefXor[i-1] ^ nums[i];
        }
        TreeMap<Integer, Integer> map = new TreeMap<>();
        int l = 0;
        int r = 0;
        while(r<n){
            map.put(nums[r], r);
            int minEl = map.getFirstKey();
            int maxEl = map.getLastKey();
            int currXor = pref[r] ^ pref[l];
            if(maxEl-minEl<=k){
                max = Math.max(max, currXor);
            }
            
        }
        
        return max;
    }
}