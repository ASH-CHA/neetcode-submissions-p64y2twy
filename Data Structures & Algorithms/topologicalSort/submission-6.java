class Solution {
    public List<Integer> topologicalSort(int n, int[][] edges) {
        List<List<Integer>> adj = new ArrayList<>();
        int[] inDegree = new int[n];
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(int[] edge : edges){
            int u = edge[0], v = edge[1];
            adj.get(u).add(v);

            inDegree[v]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < n; i++){
            if(inDegree[i] == 0) queue.offer(i);
        }

        List<Integer> ans = new ArrayList<>();

        while(!queue.isEmpty()){
            int node = queue.poll();
            ans.add(node);

            for(int neighbor : adj.get(node)){
                inDegree[neighbor]--;

                if(inDegree[neighbor] == 0) queue.offer(neighbor);
            }
        }

        if(ans.size() != n) return new ArrayList<>();
        return ans;
    }
}