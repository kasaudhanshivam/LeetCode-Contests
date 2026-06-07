class Solution {
    List<String> res;
    public void solve(int n, int k, int cost, String ans){
        if(n==ans.length()){
            if(cost<=k) res.add(ans);
            return;
        }
        if((ans.length()>0 && ans.charAt(ans.length()-1)=='0') || ans.length()==0){
            solve(n, k, cost+ans.length(), ans+"1");
        }
        solve(n, k, cost, ans+"0");   
    }
    public List<String> generateValidStrings(int n, int k) {
        res = new ArrayList<>();
        solve(n, k, 0, "");
        return res;
    }
}