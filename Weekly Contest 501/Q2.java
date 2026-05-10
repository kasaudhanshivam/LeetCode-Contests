class Solution {
    public int[] countWordOccurrences(String[] chunks, String[] queries) {
        HashMap<String, Integer> map = new HashMap<>();
        StringBuilder s = new StringBuilder();
        for(String ch : chunks){
            for(char c : ch.toCharArray()){
                if(c==' '){
                    if(s.length()>0 && s.charAt(s.length()-1)=='-'){
                        s.deleteCharAt(s.length()-1);
                    }
                    map.put(s.toString(), map.getOrDefault(s.toString(), 0)+1);
                    s = new StringBuilder();
                }else if(s.length()==0 && c=='-'){
                    continue;
                }else if(s.length()>0 && c=='-' && s.charAt(s.length()-1)=='-'){
                    s.deleteCharAt(s.length()-1);
                    map.put(s.toString(), map.getOrDefault(s.toString(), 0)+1);
                    s = new StringBuilder();
                }else if(('a'<=c && c<='z') || c=='-'){
                    s.append(c);
                }
            }
        }
        if(s.length()>0 && s.charAt(s.length()-1)=='-'){
            s.deleteCharAt(s.length()-1);
        }
        map.put(s.toString(), map.getOrDefault(s.toString(), 0)+1);

        int[] res = new int[queries.length];
        for(int i=0; i<queries.length; i++){
            String q = queries[i];
            res[i] = map.getOrDefault(q, 0);
        }
        return res;
    }
}