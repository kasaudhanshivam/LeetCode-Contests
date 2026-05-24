class Solution {
    public int solve(int[] nums, int k, int x, int y){
        int op = 0;
        for(int i=0; i<nums.length; i++){
            int r = nums[i]%k;
            if(i%2==0){
                op += Math.min(k-Math.abs(x-r), Math.abs(x-r));
            }else{
                op += Math.min(k-Math.abs(y-r), Math.abs(y-r));
            }
        }
        return op;
    }
    public int minOperations(int[] nums, int k) {
        int n = nums.length;
        int res = Integer.MAX_VALUE;
        for(int x=0; x<k; x++){
            for(int y=0; y<k; y++){
                if(x==y) continue;
                int curr = solve(nums, k, x, y);
                res = Math.min(curr, res);
            }
        }
        return res;
    }
}