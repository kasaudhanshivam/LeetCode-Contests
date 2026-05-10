class Solution {
    public int minFlips(String s) {
        // 0000
        // 0010
        // 1001
        // 1111
        int n = s.length();
        
        int ones = 0;
        for(int i=0; i<n; i++){
            if(s.charAt(i)=='1') ones++;
        }

        int zeros = n-ones;
        
        if(ones==0 || ones==1 || zeros==0) return 0;
        int op = 0;

        op = Math.min(ones-1, zeros); // all zero OR all ones (except 1)
        if(ones>=2){
            int l = s.charAt(0)=='1'? 0 : 1;
            int r = s.charAt(n-1)=='1'? 0 : 1;

            if(l==0) ones--;
            if(r==0) ones--;
            int curr = l+r+ones;
            op = Math.min(op, curr);
        }
        return op;
    }
}