class Solution {
    public int minLights(int[] lights) {
        int n = lights.length;
        List<int[]> range = new ArrayList<>();
        for(int i=0; i<n; i++){
            int v = lights[i];
            if(v!=0){
                int[] ans = new int[2];
                ans[0] = Math.max(0, i - v);
                ans[1] = Math.min(n - 1, i + v);
                range.add(ans);
            }
        }

        Collections.sort(range, (a, b) -> {
            if(a[0]==b[0]) return b[1]-a[1];
            return a[0]-b[0];
        });

        int req = 0;
        int prev = -1;
        for(int[] r : range){
            if(r[0]<=prev+1){
                prev = Math.max(prev, r[1]);
            }else{
                int gap = r[0]-prev-1;
                req += (gap+2)/3;
                prev = r[1];
            }
        }

        if(prev<n-1){
            int gap = n-prev-1;
            req += (gap+2)/3;
        }
        return req;
    }
}