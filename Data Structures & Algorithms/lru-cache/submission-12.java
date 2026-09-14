class LRUCache {

    class Node{
        int key, val;
        Node prev, next;

        Node(int k, int v){
            key = k;
            val = v;
        }
    }

    private int capacity;
    private Map<Integer, Node> map;
    private Node head, tail;

    public LRUCache(int capacity) {
        this.capacity = capacity;
        map = new HashMap<>();

        head = new Node(0, 0);
        tail = new Node(0, 0);

        head.next = tail;
        tail.prev = head;
    }
    
    public int get(int key) {
        if(!map.containsKey(key)) return -1;

        Node node = map.get(key);
        moveToFront(node);
        return node.val;
    }
    
    public void put(int key, int value) {
        if(map.containsKey(key)){
            Node node = map.get(key);
            node.val = value;
            moveToFront(node);
        }
        else{
            if(capacity == map.size()){
                Node lru = tail.prev;
                removeNode(lru);
                map.remove(lru.key);
            }

            Node newNode = new Node(key, value);
            addToFront(newNode);
            map.put(key, newNode);
        }
    }

    private void removeNode(Node node){
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    private void addToFront(Node node){
        node.next = head.next;
        node.prev = head;

        head.next.prev = node;
        head.next = node;
    }

    private void moveToFront(Node node){
        removeNode(node);
        addToFront(node);
    }
}