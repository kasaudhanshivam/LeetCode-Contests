class Solution {
    public boolean isMobo(int n){
        String s = Integer.toBinaryString(n);
        
        for(int i=0; i<s.length()-1; i++){
            if(s.charAt(i)!=s.charAt(i+1)) return false;
        }
        return true;
    }
    public int countMonobit(int n) {
        int count = 0;
        for(int i=0; i<=n; i++){
            if(isMobo(i)) count++;
        }
        return count;
    }
}