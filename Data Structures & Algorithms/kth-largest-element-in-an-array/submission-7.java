class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        int ans = -1;

        for(int num : nums){
            minHeap.offer(num);

            while(minHeap.size() >= k){
                ans = Math.max(ans, minHeap.poll());
            }
        }
        return ans;
    }
}