class Solution {
    public boolean isConflict(int[] nums, HashMap<Integer, Integer> map, int x, int l, int r){
        for(int i=l; i<r; i++){
            if(map.containsKey(x+nums[i]) || (map.containsKey(x-nums[i]) && x-nums[i]!=nums[i]) || (map.containsKey(x-nums[i]) && map.get(nums[i])>=2)){
                return true;
            }
        }
        return false;
    }
    public int maxSubarray(int[] nums) {
        int n = nums.length;

        int max = 0;

        HashMap<Integer, Integer> map = new HashMap<>();
        int l = 0;
        for(int r=0; r<n; r++){

            while(isConflict(nums, map, nums[r], l, r)){
                map.put(nums[l], map.get(nums[l])-1);
                if(map.get(nums[l])==0) map.remove(nums[l]);
                l++;
            }
            
            map.put(nums[r], map.getOrDefault(nums[r], 0)+1);

            if(r-l+1>max) max = r-l+1;
        }
        return max;
    }
}