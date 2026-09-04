class HashTable {

    private LinkedList<int[]>[] buckets;
    private int capacity;
    private int size;

    public HashTable(int capacity) {
        this.capacity = capacity;
        this.size = 0;
        this.buckets = new LinkedList[capacity];
        for(int i = 0; i < capacity; i++){
            buckets[i] = new LinkedList<>();
        }
    }

    private int hash(int key){
        return Math.floorMod(Integer.hashCode(key), capacity);
    }

    public void insert(int key, int value) {
        int idx = hash(key);
        for(int[] pair : buckets[idx]){
            if(pair[0] == key){
                pair[1] = value;
                return;
            }
        }

        buckets[idx].add(new int[]{key, value});
        size++;

        if((double) size / capacity >= 0.5){
            resize();
        }
    }

    public int get(int key) {
        int idx = hash(key);
        for(int[] pair : buckets[idx]){
            if(pair[0] == key){
                return pair[1];
            }
        }
        return -1;
    }

    public boolean remove(int key) {
        int idx = hash(key);
        LinkedList<int[]> bucket = buckets[idx];
        for(int[] pair : bucket){
            if(pair[0] == key){
                bucket.remove(pair);
                size--;
                return true;
            }
        }
        return false;
    }

    public int getSize() {
        return size;
    }

    public int getCapacity() {
        return capacity;
    }

    public void resize() {
        int newCapacity = capacity * 2;
        LinkedList<int[]>[] newBuckets = new LinkedList[newCapacity];
        for(int i = 0; i < newCapacity; i++){
            newBuckets[i] = new LinkedList<>();
        }

        int oldCapacity = capacity;
        capacity = newCapacity;

        for(int i = 0; i < oldCapacity; i++){
            for(int[] pair : buckets[i]){
                int newIdx = hash(pair[0]);
                newBuckets[newIdx].add(pair);
            }
        }
        buckets = newBuckets;
    }
}