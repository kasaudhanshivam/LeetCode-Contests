class Solution {
    public boolean canMakeSubsequence(String s, String t) {
        int n = s.length();
        int m = t.length();
        if(n>m) return false;

        int[] L = new int[n];
        Arrays.fill(L, Integer.MAX_VALUE);
        int j=0;
        for(int i=0; i<n; i++){
            while(j<m && s.charAt(i)!=t.charAt(j)) j++;

            if(j<m){
                L[i] = j;
                j++;
            }else{ // we ran out of chars
                 break;
            }
        }

        if(L[n-1]!=Integer.MAX_VALUE) return true;

        int[] R = new int[n];
        Arrays.fill(R, Integer.MIN_VALUE);
        j=m-1;
        for(int i=n-1; i>=0; i--){
            while(j>=0 && s.charAt(i)!=t.charAt(j)) j--;

            if(j>=0){
                R[i] = j;
                j--;
            }else{ // we ran out of chars
                break;
            }
        }

        for(int i=0; i<n; i++){
            int leftEnd = (i==0)? -1 : L[i-1];
            int rightStart = (i==n-1)? m : R[i+1];

            if(leftEnd!=Integer.MAX_VALUE && rightStart!=Integer.MIN_VALUE){
                if(rightStart-leftEnd>=2) return true;
            }
        }
        return false;
    }
}