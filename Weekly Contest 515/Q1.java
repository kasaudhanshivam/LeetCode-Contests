class Solution {
    public int nearestDrone(int[][] drones, int[] target) {
        int n = drones.length;

        int idx = -1;
        int minDist = Integer.MAX_VALUE;
        for(int i=0; i<n; i++){
            int[] d = drones[i];
            int x = d[0];
            int y = d[1];
            int r = d[2];

            int dist = Math.abs(x-target[0]) + Math.abs(y-target[1]);

            if(dist<=r){
                if(minDist>dist){
                    idx = i;
                    minDist = dist;
                }
            }
        }
        return idx;
    }
}