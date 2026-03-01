class Solution {
    public String mergeCharacters(String s, int k) {
        StringBuilder sb = new StringBuilder(s);
        int n = s.length();
        boolean merged = true;
        while(merged){
            merged = false;
            for(int i=0; i<sb.length(); i++){
                for(int j=i+1; j<sb.length(); j++){
                    char a = sb.charAt(i);
                    char b = sb.charAt(j);
                    if(a==b){
                        if(sb.charAt(j)==a && j-i<=k){
                            sb.deleteCharAt(j);
                            merged = true;
                            break;
                        }
                    }
                    if(j-i>k || merged) break;
                }
                if(merged) break;
            }
        }
        return sb.toString();
    }
}