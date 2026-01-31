class Solution {
    public void reverse(ArrayList<Character> list){
        int l = 0;
        int r = list.size()-1;
        while(l<r){
            char temp = list.get(l);
            list.set(l, list.get(r));
            list.set(r, temp);
            l++;
            r--;
        }
    }
    public String reverseByType(String s) {
        int n = s.length();
        char[] str = s.toCharArray();

        ArrayList<Character> alpha = new ArrayList<>();
        ArrayList<Character> spec = new ArrayList<>();

        for(int i=0; i<n; i++){
            if(str[i]>='a' && str[i]<='z'){
                alpha.add(str[i]);
            }else{
                spec.add(str[i]);
            }
        }

        reverse(alpha);
        reverse(spec);

        // System.out.println(alpha);
        // System.out.println(spec);

        String res = "";
        for(int i=0; i<n; i++){
            if(str[i]>='a' && str[i]<='z'){
                res += alpha.remove(0);
            }else{
                res += spec.remove(0);
            }
        }
        
        return res;
    }
}