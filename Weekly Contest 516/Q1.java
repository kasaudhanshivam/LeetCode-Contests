class Solution {
    public boolean isPalindrome(String s){
        int l = 0;
        int r = s.length()-1;
        while(l<r){
            if(s.charAt(l)!=s.charAt(r)) return false;
            l++;
            r--;
        }
        return true;
    }
    public boolean isPalindromic(String s) {
        int n = s.length();

        String bin = "";
        for(int i=0; i<n; i++){
            char ch = s.charAt(i);
            int asci = (int)ch;
            String curr = String.format("%8s", Integer.toBinaryString(asci & 0xFF)).replace(' ', '0');
            bin += curr;
        }

        return isPalindrome(bin);
    }
}