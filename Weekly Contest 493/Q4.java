class Solution {
    int[] parent;
    int[] size;
    public void init(int n){
        parent = new int[n];
        size = new int[n];
        for(int i=0; i<n; i++){
            parent[i] = i;
            size[i] = 1;
        }
    }
    public int find(int x){
        if(parent[x]==x) return x;
        return parent[x] = find(parent[x]);
    }
    public void merge(int a, int b){
        int parentA = find(a);
        int parentB = find(b);

        if(parentA==parentB) return;
        if(size[parentA]>=size[parentB]){
            parent[parentB] = parentA;
            size[parentA] += size[parentB];
        }else{
            parent[parentA] = parentB;
            size[parentB] += size[parentA];
        }
    }
    public int maxActivated(int[][] points) {
        int n = points.length;
        init(n);

        HashMap<Integer, Integer> xmap = new HashMap<>();
        HashMap<Integer, Integer> ymap = new HashMap<>();
        for(int i=0; i<n; i++){
            // for(int j=i+1; j<n; j++){
                // int x1 = points[i][0];
                // int y1 = points[i][1];
                // int x2 = points[j][0];
                // int y2 = points[j][1];

                // if(x1==x2 || y1==y2){
                //     merge(i, j);
                // }
                
            // }

            int x = points[i][0];
            int y = points[i][1];

            if(xmap.containsKey(x)){
                merge(i, xmap.get(x));
            }
            xmap.put(x, i);
            if(ymap.containsKey(y)){
                merge(i, ymap.get(y));
            }
            ymap.put(y, i);
        }

        // get 1st largest grp
        int max = 0;
        int mxi = -1;
        for(int i=0; i<n; i++){
            if(parent[i]==i && size[i]>max){
                max = size[i];
                mxi = i;
            }
        }

        // get 2nd largest grp
        int max2 = 0;
        for(int i=0; i<n; i++){
            if(parent[i]==i && size[i]>max2 && i!=mxi){
                max2 = size[i];
            }
        }

        return max+max2+1;
    }
}