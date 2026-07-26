class Solution {
    public long solve(int m, int n, int[][] pen, int i, int j, int evenMove){
        if(i>=m || j>=n) return Long.MAX_VALUE;
        if(i==m-1 && j==n-1){
            return pen[i][j];
        }

        long res = Long.MAX_VALUE;

        // right
        long a = ((i+1)*(j+1)) + (evenMove==0? 0 : pen[i][j]) + solve(m, n, pen, i, j+1, (evenMove==0? 1 : 0));
        res = Math.min(res, a);
        // down
        long b = ((i+1)*(j+1)) + (evenMove==0? 0 : pen[i][j]) + solve(m, n, pen, i+1, j, (evenMove==0? 1 : 0));
        res = Math.min(res, b);
        // left
        long c = ((i+1)*(j+1)) + (evenMove==1? 0 : pen[i][j]) + solve(m, n, pen, i-1, j, (evenMove==0? 1 : 0));
        res = Math.min(res, c);
        // up
        long d = ((i+1)*(j+1)) + (evenMove==1? 0 : pen[i][j]) + solve(m, n, pen, i, j-1, (evenMove==0? 1 : 0));
        res = Math.min(res, d);
        // wait 
        long e = pen[i][j] + solve(m, n, pen, i, j, (evenMove==0? 1 : 0));
        res = Math.min(res, e);

        return res;
    }
    int[][] dir = {{0, 1}, {1, 0}, {0, -1}, {-1, 0}};
    public long dijkstra(int m, int n, int[][] pen){
        PriorityQueue<long[]> pq = new PriorityQueue<>((a, b) -> Long.compare(a[3], b[3])); // r, c, move, cost
        long[][][] dist = new long[m][n][2]; // r, c, parity
        for(long[][] d : dist){
            for(long[] a : d){
                Arrays.fill(a, Long.MAX_VALUE);
            }
        }

        pq.offer(new long[]{0, 0, 1, 1});
        dist[0][0][1] = 1;
        while(!pq.isEmpty()){
            long[] curr = pq.poll();
            int r = (int)curr[0];
            int c = (int)curr[1];
            int move = (int)curr[2];
            long cost = curr[3];

            if(r==m-1 && c==n-1) return cost;

            if(cost>dist[r][c][move]) continue;

            // Wait Action
            long waitCost = pen[r][c] + cost;
            if(waitCost < dist[r][c][1-move]){
                dist[r][c][1-move] = waitCost;
                pq.offer(new long[]{r, c, 1-move, waitCost});
            }

            // Move Actions
            for(int i=0; i<4; i++){
                int nr = r + dir[i][0];
                int nc = c + dir[i][1];

                if(nr>=0 && nr<m && nc>=0 && nc<n){
                    long moveCost = cost + (long)(nr+1) * (nc+1);

                    boolean isViolated = false;
                    if(move==1){
                        if(i==2 || i==3) isViolated = true;
                    }else{
                        if(i==0 || i==1) isViolated = true;
                    }

                    if(isViolated) moveCost += pen[r][c];

                    if(moveCost < dist[nr][nc][1-move]){
                        dist[nr][nc][1-move] = moveCost;
                        pq.offer(new long[]{nr, nc, 1-move, moveCost});
                    }
                }
            }
        }

        return -1;
    }
    public long minCost(int m, int n, int[][] penalty) {
        // return solve(m, n, penalty, 0, 0, 1, 1);
        return dijkstra(m, n, penalty);
    }
}