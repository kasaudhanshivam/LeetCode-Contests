class Solution {
    public int mirrorFrequency(String s) {
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s.toCharArray()){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int sum = 0;
        for(char ch : s.toCharArray()){
            int freq_c = map.getOrDefault(ch, 0);
            char m; 
            if(0<=ch && ch<='9'){ // digit
                char diff = (char)(ch - '0');
                m = (char)('0' + 9 - diff);
            }else{ // char
                char diff = (char)(ch - 'a');
                m = (char)('a' + 25 - diff);
            }
            int freq_m = map.getOrDefault(m, 0);
            sum += Math.abs(freq_c - freq_m);
            map.remove(ch);
            map.remove(m);
        }
        return sum;
    }
}