class Solution {
    int[][] dir = {{-1, 0}, {0, 1}, {1, 0}, {0, -1}};
    public void bfs(int[][] grid, Queue<int[]> q){
        while(!q.isEmpty()){
            int size = q.size();
            // boolean[][] isVis = new boolean[grid.length][grid[0].length]; // for curr level
            HashSet<String> set = new HashSet<>();
            for(int i=0; i<size; i++){ // curr level
                int[] curr = q.poll();
                int r = curr[0];
                int c = curr[1];
                int color = grid[r][c];
                // isVis[r][c] = true;
    
                for(int[] d : dir){
                    int nr = r + d[0];
                    int nc = c + d[1];

                    String key = nr+" "+nc;
    
                    if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && !set.contains(key) && grid[nr][nc]==0){
                        grid[nr][nc] = color;
                        // isVis[nr][nc] = true;
                        set.add(key);
                        q.offer(new int[]{nr, nc});
                    }else if(nr>=0 && nr<grid.length && nc>=0 && nc<grid[0].length && set.contains(key)){
                        grid[nr][nc] = Math.max(color, grid[nr][nc]);
                    }
                }
            }
        }
    }
    public int[][] colorGrid(int n, int m, int[][] sources) {
        int[][] grid = new int[n][m];

        Queue<int[]> q = new LinkedList<>();
        for(int[] s : sources){
            int r = s[0];
            int c = s[1];
            int color = s[2];
            grid[r][c] = color;
            q.offer(new int[]{r, c});
        }
        
        bfs(grid, q);
        return grid;
    }
}