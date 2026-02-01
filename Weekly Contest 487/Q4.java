class Solution {
    public int getLongest(int[] nums, int idx){
        int longest =  0;
        int f = 0;
        int s = 1;
        int currLen = 1;
        boolean flag = false;
        while(s<nums.length){
            if(s==idx){
                s++;
                continue;
            }

            if(flag && nums[f]<nums[s]){
                flag = false;
                currLen++;
                f++;
                s++;
            }else if(!flag && nums[f]>nums[s]){
                flag = true;
                currLen++;
                f++;
                s++;
            }else{
                longest = Math.max(currLen, longest);
                currLen = 1;
                f++;
                s++;
            }
        }

        currLen = 0;
        f = 0;
        s = 0;
        flag = true;
        while(s<nums.length){
            if(s==idx){
                s++;
                continue;
            }

            if(flag && nums[f]<nums[s]){
                flag = false;
                currLen++;
                f++;
                s++;
            }else if(!flag && nums[f]>nums[s]){
                flag = true;
                currLen++;
                f++;
                s++;
            }else{
                longest = Math.max(currLen, longest);
                currLen = 1;
                f++;
                s++;
            }
        }
        return longest;
    }
    public int longestAlternating(int[] nums) {
        int n = nums.length;

        int longest = 0;
        for(int i=0; i<n; i++){
            // choose the each item to remove from arr
            // and check for longest alternating subarr
            
            int curr = getLongest(nums, i);
            longest = Math.max(curr, longest);
        }
        return longest;
    }
}