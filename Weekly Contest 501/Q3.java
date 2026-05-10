class Solution {
    public long minArraySum(int[] nums) {
        Arrays.sort(nums);
        int n = nums.length;

        // TLE
        // long sum = 0;
        // boolean[] aff = new boolean[n];
        // for(int i=0; i<n; i++){
        //     if(aff[i]) continue;
        //     int num = nums[i];
        //     for(int j=i; j<n; j++){
        //         if(aff[j]) continue;
        //         if(nums[j]%num==0){
        //             sum += num;
        //             aff[j] = true;
        //         }
        //     }
        // }

        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums) map.put(num, map.getOrDefault(num, 0)+1);
        
        int max = nums[n-1];
        long sum = 0;
        for(int i=0; i<n; i++){
            if(map.size()==0) break;
            int num = nums[i];
            
            for(int mul=1; num*mul<=max; mul++){
                if(map.containsKey(num*mul)){
                    sum += ((long)num * map.get(num*mul));
                    map.remove(num*mul);
                }
            }
        }
        
        return sum;
    }
}