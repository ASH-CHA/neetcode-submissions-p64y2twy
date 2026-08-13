class Solution {
    public int countComponents(int n, int[][] edges) {
        int components = 0;
        int[] visited = new int[n];
        List<Integer>[] adjList = new ArrayList[n];

        for(int i = 0; i < n; i++){
            adjList[i] = new ArrayList<>();
        }

        for(int[] edge : edges){
            adjList[edge[0]].add(edge[1]);
            adjList[edge[1]].add(edge[0]);
        }

        for(int i = 0; i < n; i++){
            if(visited[i] == 0){
                components++;
                dfs(adjList, visited, i);
            }
        }
        return components;
    }

    private void dfs(List<Integer>[] adjList, int[] visited, int startNode){
        visited[startNode] = 1;

        for(int i = 0; i < adjList[startNode].size(); i++){
            if(visited[adjList[startNode].get(i)] == 0){
                dfs(adjList, visited, adjList[startNode].get(i));
            }
        }
    }
}