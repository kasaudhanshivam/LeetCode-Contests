class Solution {
    public int minCost(int[] nums1, int[] nums2) {
        int n1 = nums1.length;
        int n2 = nums2.length;
        HashMap<Integer, Integer> map1 = new HashMap<>();
        HashMap<Integer, Integer> map2 = new HashMap<>();

        for(int num : nums1){
            map1.put(num, map1.getOrDefault(num, 0)+1);
        }
        for(int num : nums2){
            map2.put(num, map2.getOrDefault(num, 0)+1);
        }

        int op1 = 0;
        for(int key : map1.keySet()){
            int f1 = map1.get(key);
            int f2 = map2.getOrDefault(key, 0);
            if((f1+f2)%2!=0) return -1;
            op1 += f1-f2<0? 0 : f1-f2;
        }
        int op2 = 0;
        for(int key : map2.keySet()){
            int f1 = map1.getOrDefault(key, 0);
            int f2 = map2.get(key);
            if((f1+f2)%2!=0) return -1;
            op2 += f2-f1<0? 0 : f2-f1;
        }

        if(op1==op2) return op1/2;
        return -1;
    }
}