class Solution {
    public int minOperations(String s1, String s2) {
        int n = s1.length();
        StringBuilder sb = new StringBuilder(s1);
        int op = 0;

        while(!s2.equals(sb.toString())){
            int i=0;
            while(i<n){
                if(sb.charAt(i)==s2.charAt(i)){
                    i++;
                }else{
                    if(sb.charAt(i)=='0'){ // operation 1 => 0->1
                        sb.setCharAt(i, '1');
                        op++;
                    }else{ // operation 2
                        if(i+1<n && sb.charAt(i+1)=='1'){
                            sb.setCharAt(i+1, '0');
                            sb.setCharAt(i, '0');
                            op++;
                            i++;
                        }else if(i-1>=0 && sb.charAt(i-1)=='1'){ // 11->00
                            sb.setCharAt(i-1, '0');
                            sb.setCharAt(i, '0');
                            op++;
                            // i--;
                        }else{
                            if(i+1<n && sb.charAt(i+1)=='0'){
                                sb.setCharAt(i+1, '1');
                                op++;
                            }else if(i-1>=0 && sb.charAt(i-1)=='0'){
                                sb.setCharAt(i-1, '1');
                                op++;
                                // i--;
                            }else return -1;
                        }
                    }
                }
            }
        }
        return op;
    }
}