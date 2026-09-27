class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        int[] ans = new int[n];

        TreeMap<Integer, Integer> map = new TreeMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        int i=0;
        while(i<n){
            Set<Integer> keys = map.keySet();
            for(int key : keys){
                if(map.get(key)>0){
                    map.put(key, map.get(key)-1);
                    // if(map.get(key)==0) map.remove(key);
                    ans[i++] = key;
                }
            }
        }
        return ans;
    }
}