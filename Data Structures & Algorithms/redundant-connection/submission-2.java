class Solution {
    public int[] findRedundantConnection(int[][] edges) {
        int[] parent = new int[edges.length + 1];
        for(int i = 1; i <= edges.length; i++){
            parent[i] = i;
        }

        for(int[] edge : edges){
            int node1 = edge[0];
            int node2 = edge[1];

            int root1 = find(node1, parent);
            int root2 = find(node2, parent);

            if(root1 == root2) return edge;

            parent[root2] = root1;
        }
        return parent;
    }

    private int find(int node, int[] parent){
        while(node != parent[node]){
            parent[node] = parent[parent[node]];
            node = parent[node];
        }
        return node;
    }
}