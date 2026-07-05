class Solution {
    public int maxDigitRange(int[] nums) {
        int sum = 0;
        int maxR = 0;
        for(int n : nums){
            int num = n;
            int min = 10;
            int max = -1;
            while(num>0){
                int d = num%10;
                min = Math.min(min, d);
                max = Math.max(max, d);
                num = num/10;
            }
            int currR = max-min;
            if(currR==maxR){
                sum += n;
            }else if(currR>maxR){
                maxR = currR;
                sum = n;
            }
        }
        return sum;
    }
}