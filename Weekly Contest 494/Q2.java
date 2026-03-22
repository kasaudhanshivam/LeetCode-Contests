class Solution {
    public boolean uniformArray(int[] nums1) {
        int n = nums1.length;
        int smallest_odd = Integer.MAX_VALUE;
        int smallest_even = Integer.MAX_VALUE;
        
        boolean isOdd = (nums1[0]%2==0);
        boolean isEven = (nums1[0]%2!=0);
        for(int i=0; i<n; i++){
            if(nums1[i]%2==0){
                smallest_even = Math.min(smallest_even, nums1[i]);
                isOdd = false;
            }else{
                smallest_odd = Math.min(smallest_odd, nums1[i]);
                isEven = false;
            }
        }

        // check for even
        if(isOdd && !isEven) return true;
        if(!isOdd && isEven) return true;


        boolean isEv = true;
        // try to make even
        for(int i=0; i<n; i++){
            if(nums1[i]%2!=0 && nums1[i]-smallest_odd<1){
                isEv = false;
                break;
            }
        }
        if(isEv) return true;

        boolean isOd = true;
        // try to make odd
        for(int i=0; i<n; i++){
            if(nums1[i]%2==0 && nums1[i]-smallest_odd<1){
                isOd = false;
                break;
            }
        }
        if(isOd) return true;
        
        return false; // any conflict
    }
}