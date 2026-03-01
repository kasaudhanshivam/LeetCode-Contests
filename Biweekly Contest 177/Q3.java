class Solution {
    public int[] makeParityAlternating(int[] nums) {
        int n = nums.length;
        if(n==1) return new int[]{0, 0};
        int ans1 = Integer.MAX_VALUE;
        int ans2 = 0;

        int min = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;

        // start from odd
        int op = 0;
        boolean flag = false; // odd
        for(int i=0; i<n; i++){
            min = Math.min(min, nums[i]);
            max = Math.max(max, nums[i]);
            if(flag && nums[i]%2!=0){ // flag = even and num = odd
                op++;
            }else if(!flag && nums[i]%2==0){ // flag = odd and num = even
                op++;
            }
            flag = !flag;
        }
        ans1 = Math.min(op, ans1);


        // start from even
        op = 0;
        flag = true; // even
        for(int i=0; i<n; i++){
            if(flag && nums[i]%2!=0){ // flag = even and num = odd
                op++;
            }else if(!flag && nums[i]%2==0){ // flag = odd and num = even
                op++;
            }
            flag = !flag;
        }
        ans1 = Math.min(op, ans1);

        ans2 = max - min - 1;

        return new int[]{ans1, ans2};
    }
}