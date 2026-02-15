class Solution {
    public List<Integer> toggleLightBulbs(List<Integer> bulbs) {
        List<Integer> res = new ArrayList<>();
        HashMap<Integer, Integer> map = new HashMap<>();

        for(int i=0; i<bulbs.size(); i++){
            map.put(bulbs.get(i), map.getOrDefault(bulbs.get(i), 0)+1);
        }

        for(int key : map.keySet()){
            if(map.get(key)%2!=0){
                res.add(key);
            }
        }

        Collections.sort(res);

        return res;
    }
}