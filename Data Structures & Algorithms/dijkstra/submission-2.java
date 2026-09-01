class Solution {
    public Map<Integer, Integer> shortestPath(int n, List<List<Integer>> edges, int src) {
        List<List<int[]>> graph = new ArrayList<>();
        for(int i = 0; i < n; i++){
            graph.add(new ArrayList<>());
        }

        for(List<Integer> edge : edges){
            int u = edge.get(0);
            int v = edge.get(1);
            int w = edge.get(2);
            graph.get(u).add(new int[]{v, w});
        }

        int[] dist = new int[n];
        Arrays.fill(dist, Integer.MAX_VALUE);
        dist[src] = 0;

        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[1] - b[1]);
        pq.offer(new int[]{src, 0});
        boolean[] visited = new boolean[n];

        while(!pq.isEmpty()){
            int[] curr = pq.poll();
            int node = curr[0];
            int d = curr[1];

            if(visited[node]) continue;
            visited[node] = true;

            for(int[] neighbor : graph.get(node)){
                int next = neighbor[0];
                int weight = neighbor[1];

                if(!visited[next] && dist[node] != Integer.MAX_VALUE && dist[node] + weight < dist[next]){
                    dist[next] = dist[node] + weight;
                    pq.offer(new int[]{next, dist[next]});
                }
            }
        }

        Map<Integer, Integer> res = new LinkedHashMap<>();
        for(int i = 0; i < n; i++){
            res.put(i, dist[i] == Integer.MAX_VALUE ? -1 : dist[i]);
        }
        return res;
    }  
}