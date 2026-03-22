class Solution {
    public int getComma(int n){
        String s = Integer.toString(n);
        if(s.length()<4) return 0;

        return (s.length()-1)/3;
    }
    public int countCommas(int n) {
        int count = 0;
        for(int i=1; i<=n; i++){
            count += getComma(i);
        }
        return count;
    }
}