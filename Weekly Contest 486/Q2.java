class Solution {
    public void rotate(ArrayList<Integer> arr, int k){
        k = k % arr.size();
        for(int i=0; i<k; i++){
            int rem = arr.remove(0);
            arr.add(rem);
        }
    }
    public int[] rotateElements(int[] nums, int k) {
        ArrayList<Integer> nonNeg = new ArrayList<>();
        for(int num : nums){
            if(num>=0){
                nonNeg.add(num);
            }
        }
        if(nonNeg.size()==0) return nums;
        rotate(nonNeg, k);
        int i=0;
        for(int a : nonNeg){
            while(nums[i]<0){
                i++;
            }
            nums[i++] = a;
        }
        return nums;
    }
}