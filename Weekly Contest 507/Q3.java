class Solution {
    public void dijkstra(List<int[]>[] graph, int[][] dist, String s, int k){
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1]-b[1]);
        pq.offer(new int[]{0, dist[0][1], 1}); // node, dist, consec
        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int u = curr[0];
            int d = curr[1];
            int c = curr[2];
            if(d>dist[u][c]) continue;

            for(int[] ngbr : graph[u]){
                int v = ngbr[0];
                int w = ngbr[1];
                if(s.charAt(u)==s.charAt(v)){
                    if(c+1<=k){
                        if(d+w<dist[v][c+1]){
                            dist[v][c+1] = d+w;
                            pq.offer(new int[]{v, dist[v][c+1], c+1});
                        }
                    }
                }else{
                    if(d+w<dist[v][1]){
                        dist[v][1] = d+w;
                        pq.offer(new int[]{v, dist[v][1], 1});
                    }
                }
            }
        }
    }
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        @SuppressWarnings("unchecked")
        List<int[]>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }
        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            int w = e[2];
            graph[u].add(new int[]{v, w});
        }
        int[][] dist = new int[n][k+1]; // dist[node][consec_count]
        for(int[] d : dist){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        dist[0][1] = 0;
        dijkstra(graph, dist, labels, k);
        
        int ans = Integer.MAX_VALUE;
        for(int i=0; i<=k; i++){
            ans = Math.min(ans, dist[n-1][i]);
        }
        return ans==Integer.MAX_VALUE? -1 : ans;
    }
}