class Graph {

    private Map<Integer, Set<Integer>> adj;

    public Graph() {
        adj = new HashMap<>();
    }

    public void addEdge(int src, int dst) {
        adj.putIfAbsent(src, new HashSet<>());
        adj.putIfAbsent(dst, new HashSet<>());
        adj.get(src).add(dst);
    }

    public boolean removeEdge(int src, int dst) {
        if(!adj.containsKey(src) || !adj.containsKey(dst)){
            return false;
        }
        return adj.get(src).remove(dst);
    }

    public boolean hasPath(int src, int dst) {
        if(src == dst) return true;
        Set<Integer> visited = new HashSet<>();
        Deque<Integer> stack = new ArrayDeque<>();
        visited.add(src);
        stack.push(src);

        while(!stack.isEmpty()){
            int curr = stack.pop();

            if(curr == dst) return true;
            for(int neighbor : adj.getOrDefault(curr, Collections.emptySet())){
                if(!visited.contains(neighbor)){
                    visited.add(neighbor);
                    stack.push(neighbor);
                }
            }
        }
        return false;
    }
}