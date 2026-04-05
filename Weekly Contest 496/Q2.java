class Solution {
    public List<Integer> findGoodIntegers(int n) {
        HashMap<Long, Integer> map = new HashMap<>();
        for(int i=1; i<Math.cbrt(n); i++){
            for(int j=i; j<Math.cbrt(n); j++){
                long a3 = 1L*i*i*i;
                long b3 = 1L*j*j*j;
                long sum = a3+b3;
                if(sum<=n){
                    map.put(sum, map.getOrDefault(sum, 0)+1);
                }
            }
        }
        List<Integer> res = new ArrayList<>();
        for(long key : map.keySet()){
            if(map.get(key)>=2){
                res.add((int)key);
            }
        }
        Collections.sort(res);
        return res;
    }
}