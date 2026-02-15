class Solution {
    public int solve(String s1, String s2, int i, int j){
        if(i>=s1.length() || j>=s2.length()){
            return 0;
        }

        int ans = 0;
        if(s1.charAt(i)==s2.charAt(j)){
            ans = 1 + solve(s1, s2, i+1, j+1);
        }else{
            int a = solve(s1, s2, i+1, j);
            int b = solve(s1, s2, i, j+1);
            ans = Math.max(a, b);
        }
        return ans;
    }
    public boolean isPalin(String s, int l, int r){
        int count = 0;
        while(l<r){
            if(count>1) break;
            if(s.charAt(l)!=s.charAt(r)){
                count++;
            }
            r--;
            l++;
        }
        return count<2;
    }
    public int almostPalindromic(String s) {
        int n = s.length();
        int max = 0;
        for(int i=0; i<n; i++){
            for(int j=i; j<n; j++){
                if(j - i + 1 <= max) continue;
                if(isPalin(s, i, j)){
                    max = Math.max(max, j-i+1);
                }
            }
        }

        return max;
    }
}