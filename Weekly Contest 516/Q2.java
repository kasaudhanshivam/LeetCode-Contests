class Solution {
    public int binSearch(int[] nums, int target){
        int l = 0;
        int r = nums.length-1;
        int ans = -1;
        while(l<=r){
            int mid = l + (r-l)/2;
            if(nums[mid]==target){
                ans = mid;
                r = mid-1;
            }else if(nums[mid]<target) l = mid+1;
            else r = mid-1;
        }
        return ans;
    }
    public List<List<Integer>> findDisappearedNumbers(int[] nums, int lower, int upper) {
        int n = nums.length;
        int[] arr = new int[n+2];
        for(int i=0; i<n; i++){
            arr[i] = nums[i];
        }
        arr[n] = lower;
        arr[n+1] = upper;

        Arrays.sort(nums);
        boolean lower_flag = binSearch(nums, lower)==-1? true : false;
        boolean upper_flag = binSearch(nums, upper)==-1? true : false;

        Arrays.sort(arr);
        List<List<Integer>> res = new ArrayList<>();

        int lower_idx = binSearch(arr, lower);
        int upper_idx = binSearch(arr, upper);
        while(upper_idx+1<arr.length && arr[upper_idx+1]==upper) upper_idx++;

        for(int i=lower_idx; i<upper_idx; i++){

            int x = (i==lower_idx && lower_flag)? arr[i] : arr[i]+1;
            int y = (i==upper_idx-1 && upper_flag)? arr[i+1] : arr[i+1]-1;

            if(x<=y){
                List<Integer> list = new ArrayList<>();
                list.add(x);
                list.add(y);
                res.add(list);
            }
            
        }
        return res;
    }
}