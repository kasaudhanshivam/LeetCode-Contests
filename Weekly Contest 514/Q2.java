class Solution {
    public long height(List<Integer>[] graph, int u){
        long max = 1;
        for(int v : graph[u]){
            long curr = 1 + height(graph, v);
            max = Math.max(max, curr);
        }
        return max;
    }
    public long solve(List<Integer>[] graph, int[] nums, long h, int u, int depth){
        long sum = (long)nums[u] * (h-depth+1);
        for(int v : graph[u]){
            sum += solve(graph, nums, h, v, depth+1);
        }
        return sum;
    }
    public long weightedSum(int[] parent, int[] nums) {
        int n = parent.length;
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int v=1; v<n; v++){
            int u = parent[v];

            graph[u].add(v);
            // graph[v].add(u);
        }

        long h = height(graph, 0); // root, dist=0
        // System.out.println(h);

        long sum = solve(graph, nums, h, 0, 1); // root, depth=0

        return sum;
    }
}