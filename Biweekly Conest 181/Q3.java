class Solution {
    List<List<Integer>> subsets;
    public void generate(int n, int i, List<Integer> curr){
        if(i>=n){
            subsets.add(new ArrayList<>(curr));
            return;
        }

        curr.add(i);
        generate(n, i+1, curr);
        curr.remove(curr.size()-1);
        
        generate(n, i+1, curr);
    }
    public int dfs(ArrayList<Integer>[] graph, int i, boolean[] vis, HashSet<Integer> nodes){
        vis[i] = true;

        int count = 1;
        for(int ngbr : graph[i]){
            if(!vis[ngbr] && nodes.contains(ngbr)){ // go to only nodes that are present in curr subset only
                count += dfs(graph, ngbr, vis, nodes); // count all those nodes
            }
        }
        return count; // total nodes that are in subset and reachable using only those nodes
    }
    public int evenSumSubgraphs(int[] nums, int[][] edges) {
        int n = nums.length;
        ArrayList<Integer>[] graph = new ArrayList[n];
        for(int i=0; i<n; i++){
            graph[i] = new ArrayList<>();
        }

        for(int[] e : edges){
            int u = e[0];
            int v = e[1];
            graph[u].add(v);
            graph[v].add(u);
        }

        // 1. Generate all possible subsets
        subsets = new ArrayList<>();
        generate(n, 0, new ArrayList<>());
        
        int total = 0; // total such subsets that satisfies the condition
        // 2. For each non-empty subset
        for(List<Integer> subset : subsets){

            int sum = 0;
            for(int i : subset){
                sum += nums[i];
            }
            if(sum%2!=0 || subset.isEmpty()) continue; // sum != even

            HashSet<Integer> nodes = new HashSet<>(subset); // for O(1) lookup
            int connected = dfs(graph, subset.get(0), new boolean[n], nodes); // check if all the nodes are connected as required
            if(connected==subset.size()) total++; // if yes, count it as a valid subset
        }
        return total;
    }
}