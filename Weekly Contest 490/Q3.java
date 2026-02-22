class Solution {
    public void getPermutation(char[] arr, int i, List<String> res){
        if(i>=arr.length){
            res.add(new String(arr));
            return;
        }

        for(int j=i; j<arr.length; j++){
            swap(arr, i, j);
            getPermutation(arr, i+1, res);
            swap(arr, i, j);
        }
    }
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public String maximumXor(String s, String t) {
        // List<String> perm = new ArrayList<>();
        // getPermutation(t.toCharArray(), 0, perm);

        // int max = 0;
        // int n = Integer.parseInt(s, 2);
        // for(String t_new : perm){
        //     int m = Integer.parseInt(t_new, 2);
        //     int xor = n^m;
        //     max = Math.max(xor, max);
        // }

        // String ans = Integer.toBinaryString(max);
        // while(ans.length()<s.length()){
        //     ans = '0' + ans;
        // }

        // return ans; // TLE



        int zeros = 0;
        int ones = 0;
        for(char ch : t.toCharArray()){
            if(ch=='1') ones++;
            else zeros++;
        }

        StringBuilder res = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch=='1'){
                if(zeros>0){
                    res.append('1');
                    zeros--;
                }else{
                    res.append('0');
                    ones--;
                }
            }else{ // ch == '0'
                if(ones>0){
                    res.append('1');
                    ones--;
                }else{
                    res.append('0');
                    zeros--;
                }
            }
        }
        return res.toString();
    }
}