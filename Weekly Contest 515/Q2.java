class Solution {
    public int minPenalty(int period, int[] lights, int[] arrivalTime) {
        int n = arrivalTime.length;
        int best_light = 0;
        for(int l : lights) best_light = Math.max(best_light, l);

        int max = Integer.MIN_VALUE;
        for(int arr : arrivalTime){
            int r = arr % period;
            int wait = period-r;
            if(r<best_light) wait = 0;

            max = Math.max(max, wait);
        }
        return max;
    }
}