class Solution {
    public boolean isTriplet(int a, int b, int c){
        int asq = a * a;
        int bsq = b * b;
        int csq = c * c;
        if(asq + bsq == csq) return true;
        if(bsq + csq == asq) return true;
        if(asq + csq == bsq) return true;
        return false;
    }
    public void dfs(ArrayList<Integer>[] graph, int curr, boolean[] vis, int[] dist){
        vis[curr] = true;
        for(int ngbr : graph[curr]){
            if(!vis[ngbr]){
                dist[ngbr] = dist[curr] + 1;
                dfs(graph, ngbr, vis, dist);
            }
        }
    }
    public int specialNodes(int n, int[][] edges, int x, int y, int z) {
        int count = 0;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u); // as undirected
        }

        int[] dx = new int[n];
        int[] dy = new int[n];
        int[] dz = new int[n];
        Arrays.fill(dx, -1);
        Arrays.fill(dy, -1);
        Arrays.fill(dz, -1);
        dx[x] = 0;
        dy[y] = 0;
        dz[z] = 0;

        dfs(graph, x, new boolean[n], dx);
        dfs(graph, y, new boolean[n], dy);
        dfs(graph, z, new boolean[n], dz);
        
        for(int i=0; i<n; i++){
            if(dx[i] == -1 || dy[i] == -1 || dz[i] == -1) continue;
            if(isTriplet(dx[i], dy[i], dz[i])) count++;
        }
        return count;
    }
}