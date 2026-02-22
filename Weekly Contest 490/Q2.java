class Solution {
    public void getPermutaion(char[] arr, int i, List<String> res){
        if(i>=arr.length){
            res.add(new String(arr));
            return;
        }

        for(int j=i; j<arr.length; j++){
            swap(arr, i, j);
            getPermutaion(arr, i+1, res);
            swap(arr, i, j);
        }
    }
    public void swap(char[] arr, int i, int j){
        char temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    public int fac(int n){ // slow
        if(n==0 || n==1) return 1;
        return n*fac(n-1);
    }
    public boolean isPerm(String s1, String s){
        if(s1.length()!=s.length()) return false;
        HashMap<Character, Integer> freq1 = new HashMap<>();
        HashMap<Character, Integer> freq2 = new HashMap<>();

        for(int i=0; i<s.length(); i++){
            freq1.put(s.charAt(i), freq1.getOrDefault(s.charAt(i), 0)+1);
            freq2.put(s1.charAt(i), freq2.getOrDefault(s1.charAt(i), 0)+1);
        }

        for(char key : freq2.keySet()){
            if(!freq1.containsKey(key)) return false;
            else if(freq1.get(key)!=freq2.get(key)) return false;
        }

        for(char key : freq1.keySet()){
            if(!freq2.containsKey(key)) return false;
        }

        return true;
    }
    public boolean isDigitorialPermutation(int n) {
        String s = Integer.toString(n);

        // List<String> res = new ArrayList<>();
        // getPermutaion(s.toCharArray(), 0, res);

        int[] fact = {1,1,2,6,24,120,720,5040,40320,362880};

        // for(String str : res){
        //     int sum = 0;
        //     if(str.charAt(0)=='0') continue;
        //     for(int i=0; i<str.length(); i++){
        //         int num = Integer.parseInt(str.charAt(i)+"");
        //         sum += fact[num];
        //     }
            
        //     // System.out.println(sum);
        //     if(sum==Integer.parseInt(str)) return true;
        // }

        // // System.out.println(fac(5));
        // return false;



        int temp = n;
        int sum = 0;

        while(temp>0){
            int d = temp%10;
            sum += fact[d];
            temp = temp/10;
        }

        String s1 = Integer.toString(sum);
        if(isPerm(s1, s)) return true;

        // for(String str : res){
        //     if(str.charAt(0)=='0') continue;
        //     int m = Integer.parseInt(str);
        //     if(sum==m) return true;
        // }
        return false;
    }
}