class Solution {
    public int prefixConnected(String[] words, int k) {
        int n = words.length;
        HashMap<String, Integer> map = new HashMap<>();
        for(int i=0; i<n; i++){
            String word = words[i];
            if(word.length()<k) continue;
            map.put(word.substring(0, k), map.getOrDefault(word.substring(0, k), 0)+1);
        }

        int count = 0;
        for(String key : map.keySet()){
            if(map.get(key)>1) count++;
        }
        return count;
    }
}