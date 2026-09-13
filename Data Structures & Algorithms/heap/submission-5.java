class MinHeap {

    private List<Integer> heap;

    public MinHeap() {
        heap = new ArrayList<>();
    }

    public void push(int val) {
        heap.add(val);
        siftUp(heap.size() - 1);
    }

    public Integer pop() {
        if(heap.isEmpty()) return -1;

        int min = heap.get(0);
        int last = heap.remove(heap.size() - 1);
        if(!heap.isEmpty()){
            heap.set(0, last);
            siftDown(0);
        }
        return min;
    }

    public Integer top() {
        if(heap.isEmpty()) return -1;
        return heap.get(0);
    }

    public void heapify(List<Integer> nums) {
        heap = new ArrayList<>(nums);

        for(int i = heap.size() / 2 - 1; i >= 0; i--){
            siftDown(i);
        }
    }

    private void siftUp(int i){
        while(i > 0){
            int parent = (i - 1) / 2;

            if(heap.get(i) < heap.get(parent)){
                swap(i, parent);
                i = parent;
            }
            else break;
        }
    }

    private void siftDown(int i){
        int n = heap.size();

        while(i <  n){
            int left = 2 * i + 1;
            int right = 2 * i + 2;
            int smallest = i;

            if(left < n && heap.get(left) < heap.get(smallest)){
                smallest = left;
            }
            if(right < n && heap.get(right) < heap.get(smallest)){
                smallest = right;
            }
            if(smallest == i) break;

            swap(i, smallest);
            i = smallest;
        }
    }

    private void swap(int i, int j){
        Collections.swap(heap, i, j);
    }
}