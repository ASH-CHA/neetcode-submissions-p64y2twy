class Solution {
    public int minimumSpanningTree(List<List<Integer>> edges, int n) {
        List<List<int[]>> adj = new ArrayList<>();
        for(int i = 0; i < n; i++){
            adj.add(new ArrayList<>());
        }

        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            adj.get(u).add(new int[]{v, w});
            adj.get(v).add(new int[]{u, w});
        }

        boolean[] visited = new boolean[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        pq.offer(new int[]{0, 0});

        int totalWeight = 0;
        int visitedCount = 0;

        while(!pq.isEmpty() && visitedCount < n){
            int[] curr = pq.poll();
            int weight = curr[0];
            int u = curr[1];

            if(visited[u]) continue;

            visited[u] = true;
            visitedCount++;
            totalWeight += weight;

            for(int[] neighbor : adj.get(u)){
                int v = neighbor[0];
                int w = neighbor[1];

                if(!visited[v]){
                    pq.offer(new int[]{w, v});
                }
            }
        }

        if(visitedCount != n) return -1;
        return totalWeight;
    }
}