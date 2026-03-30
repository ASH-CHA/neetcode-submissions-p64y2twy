class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<List<Integer>> graph = new ArrayList<>();
        for(int i = 0; i < numCourses; i++){
            graph.add(new ArrayList<>());
        }

        int[] inDegree = new int[numCourses];
        for(int[] p : prerequisites){
            int course = p[0];
            int prereq = p[1];

            graph.get(prereq).add(course);
            inDegree[course]++;
        }

        Queue<Integer> queue = new LinkedList<>();
        for(int i = 0; i < numCourses; i++){
            if(inDegree[i] == 0){
                queue.add(i);
            }
        }

        int[] order = new int[numCourses];
        int index = 0;

        while(!queue.isEmpty()){
            int curr = queue.remove();
            order[index++] = curr;

            for(int next : graph.get(curr)){
                inDegree[next]--;

                if(inDegree[next] == 0) queue.add(next);
            }
        }

        if(index != numCourses) return new int[]{};
        return order;
    }
}
