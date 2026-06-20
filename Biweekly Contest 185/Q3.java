class Solution {
    int[] base;
    public long solve(List<Integer>[] graph, int i){
        long min = Long.MAX_VALUE;
        long max = Long.MIN_VALUE;
        for(int ngbr : graph[i]){
            long ans = solve(graph, ngbr);
            min = Math.min(min, ans);
            max = Math.max(max, ans);
        }
        long ownDur = base[i] + (max!=Long.MIN_VALUE? (max-min) : 0);
        long res = (graph[i].size()!=0? max : 0) + ownDur;
        return res;
    }
    public long finishTime(int n, int[][] edges, int[] baseTime) {
        this.base = baseTime;
        @SuppressWarnings("unchecked")
        List<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
        }

        long res = solve(graph, 0);
        return res;
    }
}