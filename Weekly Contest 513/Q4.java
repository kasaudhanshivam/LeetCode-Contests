class Solution {
    long inversions;
    public void mergeSort(long[] nums, long[] temp, int l, int r){
        if(l>=r) return;

        int mid = l+(r-l)/2;

        mergeSort(nums, temp, l, mid);
        mergeSort(nums, temp, mid+1, r);

        merge(nums, temp, l, r, mid);
    }
    public void merge(long[] nums, long[] temp, int l, int r, int mid){

        // Count Inversions
        int i = l;
        int j = mid+1;
        while(i<=mid && j<=r){
            if(nums[i]>=nums[j]){
                inversions += (mid-i+1);
                j++;
            }else{
                i++;
            }
        }

        // Merge Step
        i = l;
        j = mid+1;
        int idx = l;
        while(i<=mid && j<=r){
            if(nums[i]>=nums[j]){
                temp[idx] = nums[j];
                j++;
            }else{
                temp[idx] = nums[i];
                i++;
            }
            idx++;
        }

        while(i<=mid){
            temp[idx] = nums[i];
            i++;
            idx++;
        }
        while(j<=r){
            temp[idx] = nums[j];
            j++;
            idx++;
        }

        for(int k=l; k<=r; k++){
            nums[k] = temp[k];
        }
    }
    public long countRatioSubarrays(int[] nums, int a, int b) {
        int n = nums.length;

        long[] pref = new long[n+1];
        long sum = 0;
        pref[0] = sum;
        for(int i=0; i<n; i++){
            if(nums[i]%2==0){
                sum += b;
            }else{
                sum -= a;
            }
            pref[i+1] = sum;
        }

        inversions = 0;
        long[] temp = new long[n+1];
        mergeSort(pref, temp, 0, n);
        return inversions;
    }
}