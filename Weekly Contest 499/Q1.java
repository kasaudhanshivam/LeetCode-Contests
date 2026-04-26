class Solution {
    public List<Integer> findValidElements(int[] nums) {
        int n = nums.length;
        List<Integer> res = new ArrayList<>();
        HashSet<Integer> set = new HashSet<>();
        set.add(0);
        int max = nums[0];
        for(int i=1; i<n; i++){
            if(max<nums[i]){
                set.add(i);
                max = nums[i];
            }
        }
        set.add(n-1);
        max = nums[n-1];
        for(int i=n-2; i>=0; i--){
            if(max<nums[i]){
                set.add(i);
                max = nums[i];
            }
        }

        for(int i=0; i<n; i++){
            if(set.contains(i)){
                res.add(nums[i]);
            }
        }
        return res;
    }
}