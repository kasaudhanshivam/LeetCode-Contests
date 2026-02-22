class Solution {
    public int scoreDifference(int[] nums) {
        int n = nums.length;
        
        int gain1 = 0; // by first player
        int gain2 = 0; // by second player

        boolean Active1 = true; // initially
        boolean Active2 = false;
        
        for(int i=0; i<n; i++){
            if((i+1)%6==0){ // 6th game
                if(Active1){
                    Active1=false;
                    Active2=true;
                }else{
                    Active2=false;
                    Active1=true;
                }
            }
            if(nums[i]%2!=0){ // odd points
                if(Active1){
                    Active1=false;
                    Active2=true;
                    gain2 += nums[i];
                }else{
                    Active2=false;
                    Active1=true;
                    gain1 += nums[i];
                }
            }else{ // even points
                if(Active1){
                    gain1 += nums[i];
                }else{
                    gain2 += nums[i];
                }
            }
        }
        // System.out.println(gain1);
        // System.out.println(gain2);
        return gain1-gain2;
    }
}