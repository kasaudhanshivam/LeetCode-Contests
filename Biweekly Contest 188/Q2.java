class Solution {
    public int twoSum(int[] planks, long target){
        int n = planks.length;
        HashMap<Long, Integer> map = new HashMap<>();

        int ans = 0;
        for(int i=0; i<n; i++){
            if(planks[i]==target){
                ans++;
                continue;
            }
            if(map.containsKey(target-planks[i]) && map.get(target-planks[i])>0){
                map.put(target-planks[i], map.get(target-planks[i])-1);
                ans++;
            }else{
                map.put((long)planks[i], map.getOrDefault((long)planks[i], 0)+1);
            }

        }
        return ans;
    }
    public int maximumWidth(int[] planks) {
        int n = planks.length;
        Arrays.sort(planks);
        
        HashSet<Long> set = new HashSet<>();
        for(int i=0; i<n; i++){
            if(i>0 && planks[i]==planks[i-1]) continue;
            set.add((long)planks[i]);
            for(int j=i+1; j<n; j++){
                set.add((long)planks[i] + planks[j]);
            }
        }

        int max = 0;
        for(long height : set){
            int ans = twoSum(planks, height);
            max = Math.max(max, ans);
        }
        return max;
    }
}