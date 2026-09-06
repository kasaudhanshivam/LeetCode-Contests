class Solution {
    public int countGoodRotations(int[] nums) {
        int n = nums.length;
        long half1 = 0;
        long half2 = 0;

        List<Integer> list = new ArrayList<>();
        int mid = n/2;
        for(int i=0; i<mid; i++){
            half1 += nums[i];
            list.add(nums[i]);
        }
        for(int i=mid; i<n; i++){
            half2 += nums[i];
            list.add(nums[i]);
        }

        int count = 0;
        // if(half1==half2) count++;
        for(int i=0; i<n; i++){
            int num = list.get(0);
            
            half1 -= num;
            half2 += num;

            half2 -= list.get(mid);
            half1 += list.get(mid);

            if(half1>half2) count++;            
            
            int removed = list.remove(0);
            list.add(removed);
        }
        return count;
    }
}