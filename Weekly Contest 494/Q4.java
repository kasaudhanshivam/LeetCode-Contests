class Solution {
    public long countGoodSubarrays(int[] nums) {
        long count = 0;
        int n = nums.length;
        // HashMap<Integer, Integer> map = new HashMap<>();
        // int l = 0;
        // for(int r=0; r<n; r++){
        //     map.put(nums[r], map.getOrDefault(nums[r], 0));

        //     while(){ // shrink
                
        //     }

        //     if() count += 1 + l; // something
        // }


        for(int i=0; i<n; i++){
            HashSet<Integer> set = new HashSet<>();
            int xor = 0;
            for(int j=0; j<i; j++){
                set.add(nums[j]);
                xor = xor ^ nums[j];
                if(set.contains(xor)) count++;
            }
        }
        return count;
    }
}