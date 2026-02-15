class Solution {
    public int firstUniqueFreq(int[] nums) {
        int n = nums.length;
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        HashMap<Integer, Integer> freqCount = new HashMap<>();
        for(int key : map.keySet()){
            int freq = map.get(key);
            freqCount.put(freq, freqCount.getOrDefault(freq, 0)+1);
        }

        for(int num : nums){
            int freq = map.get(num);
            int freq_count = freqCount.get(freq);
            if(freq_count==1) return num;
        }
        return -1;
    }
}