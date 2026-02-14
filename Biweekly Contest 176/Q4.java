class Solution {
    public boolean isPalindrome(String s){
        HashMap<Character, Integer> map = new HashMap<>();
        for(char ch : s){
            map.put(ch, map.getOrDefault(ch, 0)+1);
        }

        int odd = 0;
        for(char key : map.keySet()){
            if(map.get(key)%2!=0){
                if(odd==1){
                    odd++;
                    return false;
                }else if(odd==0){
                    odd++;
                }
            }
        }
    }
    String ans = "";
    public void dfs(ArrayList<Integer>[] graph, int src, int dest, boolean[] isVisited, char[] str){
        isVisited[src] = true;
        ans += str[i];
        for(int ngbr : graph[src]){
            if(!isVisited[src]){
                dfs(graph, ngbr, dest, isVisited, str);
            }
        }
        ans.substring(1, ans.length()-1);
    }
    public List<Boolean> palindromePath(int n, int[][] edges, String s, String[] queries) {
        List<Boolean> res = new ArrayList<>();

        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u); // undirected
        }

        char[] str = s.toCharArray();
        for(int[] q : queries){
            if(q.charAt(0)=='q'){
                int u = (int)q.charAt(q.length()-3) - 'a';
                int v = (int)q.charAt(q.length()-1) - 'a';

                String path = dfs(graph, u, v);
                if(isPalindrome(path)){
                    res.add(true);
                }else{
                    res.add(false);
                }
                
            }else{
                char ch = q.charAt(q.length()-1);
                int u = (int)q.charAt(q.length()-3) - 'a';

                str[u] = ch; // updated

                res.add(false);
            }
        }
    }
}