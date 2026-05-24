class Solution {
    public int solve(ArrayList<Integer>[] graph, int u, int[] nums, int k, int rem){
        if(graph[u].isEmpty()){
            return rem%k==0? 1 : 0;
        }

        
    }
    public int countValidSubsets(int[] parent, int[] nums, int k) {
        int n = nums.length;
        @SuppressWarnings("unchecked")
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new Arraylist<>();
        }
        for(int u=1; u<n; u++){
            int v = parent[i];
            graph[u].add(v);
            graph[v].add(u);
        }
        return solve(graph, 0, nums, k, k);
    }
}