class Solution {
    public int[] limitOccurrences(int[] nums, int k) {
        HashMap<Integer, Integer> map = new HashMap<>();
        for(int num : nums){
            map.put(num, map.getOrDefault(num, 0)+1);
        }

        List<Integer> list = new ArrayList<>(map.keySet());
        List<Integer> ans = new ArrayList<>();
        Collections.sort(list);
        for(int num : list){
            int i=0;
            while(i<k && i<map.get(num)){
                ans.add(num);
                i++;
            }
        }

        int[] res = new int[ans.size()];
        for(int i=0; i<ans.size(); i++){
            res[i] = ans.get(i);
        }
        return res;
    }
}