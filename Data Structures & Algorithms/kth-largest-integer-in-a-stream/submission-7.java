class KthLargest {

    PriorityQueue<Integer> maxHeap;
    int k;

    public KthLargest(int k, int[] nums) {
        maxHeap = new PriorityQueue<>(k);
        this.k = k;

        for(int num : nums) add(num);
    }
    
    public int add(int val) {
        if(maxHeap.size() < k) maxHeap.offer(val);
        else if(maxHeap.peek() < val){
            maxHeap.poll();
            maxHeap.offer(val);
        }
        return maxHeap.peek();
    }
}
