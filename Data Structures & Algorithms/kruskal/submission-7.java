class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        edges.sort((a, b) -> a.get(2) - b.get(2));

        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        int edgesUsed = 0;
        int totalWeight = 0;

        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if(rootU != rootV){
                union(parent, rank, rootU, rootV);
                edgesUsed++;
                totalWeight += w;

                if(edgesUsed == n - 1) break;
            }
        }
        
        if(edgesUsed != n - 1) return -1;
        return totalWeight;
    }

    private int find(int[] parent, int x){
        if(parent[x] != x){
            parent[x] = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int[] rank, int rootU, int rootV){
        if(rank[rootU] < rank[rootV]){
            parent[rootU] = rootV;
        }
        else if(rank[rootU] > rank[rootV]){
            parent[rootV] = rootU;
        }
        else{
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}