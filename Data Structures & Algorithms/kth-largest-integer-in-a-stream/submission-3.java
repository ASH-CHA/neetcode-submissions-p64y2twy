class KthLargest {

    PriorityQueue<Integer> minHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        minHeap = new PriorityQueue<>(k);
        this.k = k;
        
        for(int num : nums) add(num);
    }
    
    public int add(int val) {
        if(minHeap.size() < k) minHeap.offer(val);
        else if(minHeap.peek() < val){
            minHeap.poll();
            minHeap.offer(val);
        }
        return minHeap.peek();
    }
}
