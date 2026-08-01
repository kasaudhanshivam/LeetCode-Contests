class Solution {
    public int countValidPrefixes(String s) {
        int n = s.length();
        int zero = 0;
        int one = 0;
        int count = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='0') zero++;
            else one++;

            if(one==zero || Math.abs(one-zero)==1) count++;
        }
        return count;
    }
}