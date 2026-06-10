class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals, (a, b) -> a[0] - b[0]);
        int n = queries.length;
        int[][] q = new int[n][2];

        for(int i = 0; i < n; i++){
            q[i][0] = queries[i];
            q[i][1] = i;
        }

        Arrays.sort(q, (a, b) -> a[0] - b[0]);
        int[] ans = new int[n];
        PriorityQueue<int[]> pq = new PriorityQueue<>((a, b) -> a[0] - b[0]);
        int i = 0;

        for(int[] query : q){
            int val = query[0];
            int idx = query[1];

            while(i < intervals.length && intervals[i][0] <= val){
                int left = intervals[i][0];
                int right = intervals[i][1];
                int length = right - left + 1;

                pq.offer(new int[]{length, right});
                i++;
            }

            while(!pq.isEmpty() && pq.peek()[1] < val){
                pq.poll();
            }

            if(pq.isEmpty()) ans[idx] = -1;
            else ans[idx] = pq.peek()[0];
        }
        return ans;
    }
}