class Solution {
    public int[] minDistinctFreqPair(int[] nums) {
        HashMap<Integer, Integer> map = new HashMap<>();
        int n = nums.length;
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int[] res = new int[2];
        res[0] = Integer.MAX_VALUE;
        res[1] = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            for(int j=0; j<n; j++){
                if(i==j) continue;
                int fx = map.get(nums[i]); // freq of x
                int fy = map.get(nums[j]); // frewq of y
                if(fx!=fy){
                    if(res[0]>nums[i]){
                        res[0] = nums[i];
                        res[1] = nums[j];
                    }else if(res[0]==nums[i]){
                        res[1] = Math.min(nums[j], res[1]);
                    }
                }
            }
        }
        // Arrays.sort(res);
        return res[0]==Integer.MAX_VALUE? new int[]{-1, -1} : res;
    }
}