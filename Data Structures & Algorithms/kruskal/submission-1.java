class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        edges.sort((a, b) -> a.get(2) - b.get(2));

        int[] parent = new int[n];
        int[] rank = new int[n];
        for(int i = 0; i < n; i++) parent[i] = i;

        int totalWeight = 0;
        int edgesUsed = 0;

        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);

            int rootU = find(parent, u);
            int rootV = find(parent, v);

            if(rootU != rootV){
                union(parent, rank, rootU, rootV);
                totalWeight += w;
                edgesUsed++;

                if(edgesUsed == n - 1) break;
            }
        }
        return (edgesUsed == n - 1) ? totalWeight : -1;
    }

    private int find(int[] parent, int x){
        while(parent[x] != x){
            x = find(parent, parent[x]);
        }
        return parent[x];
    }

    private void union(int[] parent, int[] rank, int rootU, int rootV){
        if(parent[rootU] < parent[rootV]){
            parent[rootU] = rootV;
        }
        else if(parent[rootU] > parent[rootV]){
            parent[rootV] = rootU;
        }
        else{
            parent[rootV] = rootU;
            rank[rootU]++;
        }
    }
}