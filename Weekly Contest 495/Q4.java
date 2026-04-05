class Solution {
    int[] parent;
    int[] len;
    public void init(int n){
        parent = new int[n];
        len = new int[n]; // path length from root so far
        for(int i=0; i<n; i++){
            parent[i] = i;
            len[i] = 0; // root
        }
    }
    public int find(int x){
        if(parent[x]==x) return x;
        int p = parent[x]; // store old parent
        parent[x] = find(parent[x]); // path compression -> optimization of DSU

        // previously len[x] = dist(x → p)
        // len[p] = dist(p → root)
        // now len[x] becomes dist(x → root)
        len[x] += len[p];

        return parent[x];
    }
    public int union(int a, int b, int wt){
        int parentA = find(a);
        int parentB = find(b);

        // cycle detected
        // len[a], len[b] are distances to SAME root
        // so path(a → b) = |len[a] - len[b]|
        if(parentA==parentB) return Math.abs(len[a]-len[b]);


        // Else - no cycle
        parent[parentB] = parentA; // attach rootB under rootA

        // maintain distances:
        // dist(a → rootA) = len[a]
        // dist(b → rootA) should become:
        //     len[b] + len[parentB]
        // and edge a-b has weight wt
        //
        // enforce:
        // len[a] = len[b] + len[parentB] + wt
        //
        // so:
        len[parentB] = len[a] - len[b] - wt;

        return -1;
    }
    public int numberOfEdgesAdded(int n, int[][] edges) {
        // Abhi dry run krke smjhna baki h

        init(n);
        int count = 0;
        for(int[] e : edges){
            int res = union(e[0], e[1], e[2]);
            if(res==-1){ // no cycle → always safe to add
                count++;
            }else if((res+e[2])%2==0){
                // res = path sum between a and b
                // total cycle sum = res + current edge weight
                count++;
            }
        }
        return count;
    }
}